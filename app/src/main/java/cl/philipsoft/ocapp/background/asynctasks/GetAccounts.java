package cl.philipsoft.ocapp.background.asynctasks;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import cl.philipsoft.ocapp.data.AccountsData;
import cl.philipsoft.ocapp.models.AccountsWrapper;
import cl.philipsoft.ocapp.network.RequestCode;
import cl.philipsoft.ocapp.network.accounts.AccountInterceptor;
import cl.philipsoft.ocapp.network.accounts.Accounts;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by phil_ on 13-06-2017.
 */

public class GetAccounts extends AsyncTask<String, Integer, Integer> {
    private final Accounts request = new AccountInterceptor().get();
    private int code = 667;


    @Override
    protected Integer doInBackground(String... params) {
        Log.d("GETACCOUNTS", "params[0]: " + params[0]);
        int currentPage = 1;
        int lastPage = lastPage(request.get(params[0], currentPage));
        currentPage++;

        for (int i = currentPage; i <= lastPage; i++) {
            lastPage(request.get(params[0], i));
        }
        return code;
    }

    private int lastPage(Call<AccountsWrapper> call) {
        int lastPage = 0;
        try {
            Response<AccountsWrapper> response = call.execute();
            code = response.code();
            if (RequestCode.OK == code && response.isSuccessful()) {
                AccountsWrapper wrapper = response.body();
                if (wrapper != null && wrapper.getData().length > 0) {
                    new AccountsData().handler(wrapper.getData());
                    lastPage = wrapper.getLast_page();
                } else {
                    code = 878470;
                }
            } else {
                Log.d("GETACCOUNTS", "Request code: " + String.valueOf(code));
            }
        } catch (IOException e) {
            e.printStackTrace();
            code = e.hashCode();
        }
        return lastPage;
    }
}
