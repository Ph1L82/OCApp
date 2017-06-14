package cl.philipsoft.ocapp.background.asynctasks;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import cl.philipsoft.ocapp.data.BudgetData;
import cl.philipsoft.ocapp.models.Budget;
import cl.philipsoft.ocapp.network.RequestCode;
import cl.philipsoft.ocapp.network.budgets.BudgetInterceptor;
import cl.philipsoft.ocapp.network.budgets.Budgets;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by phil_ on 13-06-2017.
 */

public class GetBudget extends AsyncTask<String, Integer, Integer> {
    private final Budgets request = new BudgetInterceptor().get();
    private int code = 667;

    @Override
    protected Integer doInBackground(String... params) {
        Log.d("GETBUDGET", "params[0]: " + params[0]);
        Call<Budget[]> call = request.get(params[0]);

        try {
            Response<Budget[]> response = call.execute();
            code = response.code();
            if (RequestCode.OK == code && response.isSuccessful()) {
                Budget[] budgets = response.body();
                if (budgets != null && budgets.length > 0) {
                    new BudgetData().handler(budgets);
                } else {
                    code = 878470;
                }
            } else {
                Log.d("GETBUDGET", "Request code: " + String.valueOf(code));
            }
        } catch (IOException e) {
            e.printStackTrace();
            code = e.hashCode();
        }
        return code;
    }
}
