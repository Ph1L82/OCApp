package cl.philipsoft.ocapp.background.services;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import cl.philipsoft.ocapp.background.asynctasks.GetAccounts;
import cl.philipsoft.ocapp.models.ActiveUser;

public class AccountService extends IntentService {
    private static final String ACTION_ACCOUNTS = "cl.philipsoft.ocapp.background.services.action.ACCOUNTS";
    private static final String ACTION_ACCOUNTS_FINISHED = "cl.philipsoft.ocapp.background.services.action.ACCOUNTS_FINISHED";


    public AccountService() {
        super("AccountService");
    }

    public static void startActionAccounts(Context context) {
        Intent intent = new Intent(context, AccountService.class);
        intent.setAction(ACTION_ACCOUNTS);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ACCOUNTS.equals(action)) {
                fetchAccounts();
            }
        }
    }

    private void fetchAccounts() {
        new FetchAccounts().execute(ActiveUser.findById(ActiveUser.class, 1).getApi_token());
    }

    private class FetchAccounts extends GetAccounts {
        @Override
        protected void onPostExecute(Integer integer) {
            Log.d("ACCOUNTS_RESULT", String.valueOf(integer));
            Intent intent = new Intent();
            intent.setAction(ACTION_ACCOUNTS_FINISHED);
            LocalBroadcastManager.getInstance(AccountService.this).sendBroadcast(intent);
            super.onPostExecute(integer);
        }
    }

}
