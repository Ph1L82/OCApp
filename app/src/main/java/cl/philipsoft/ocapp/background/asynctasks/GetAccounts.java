package cl.philipsoft.ocapp.background.asynctasks;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import cl.philipsoft.ocapp.data.AccountsData;
import cl.philipsoft.ocapp.models.Account;
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
        Call<Account[]> call = request.get(params[0]);

        try {
            Response<Account[]> response = call.execute();
            code = response.code();
            if (RequestCode.OK == code && response.isSuccessful()) {
                Account[] accounts = response.body();
                if (accounts != null && accounts.length > 0) {
                    new AccountsData().handler(accounts);
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
        return code;
    }
}
