package cl.philipsoft.ocapp.background.services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import cl.philipsoft.ocapp.background.asynctasks.GetOrders;
import cl.philipsoft.ocapp.models.ActiveUser;

public class OrderService extends IntentService {

    private static final String ACTION_ORDERS = "cl.philipsoft.ocapp.background.services.action.ORDERS";
    private static final String ACTION_ORDERS_FINISHED = "cl.philipsoft.ocapp.background.services.action.ORDERS_FINISHED";

    public OrderService() {
        super("OrderService");
    }


    public static void startActionOrders(Context context, String param1, String param2) {
        Intent intent = new Intent(context, OrderService.class);
        intent.setAction(ACTION_ORDERS);
        context.startService(intent);
    }

    private void fetchOrders() {
        new FetchOrders().execute(ActiveUser.findById(ActiveUser.class, 1).getApi_token());
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ORDERS.equals(action)) {
                fetchOrders();
            }
        }
    }

    private class FetchOrders extends GetOrders {
        @Override
        protected void onPostExecute(Integer integer) {
            Log.d("ORDERS_RESULT", String.valueOf(integer));
            Intent intent = new Intent();
            intent.setAction(ACTION_ORDERS_FINISHED);
            LocalBroadcastManager.getInstance(OrderService.this).sendBroadcast(intent);
            super.onPostExecute(integer);
        }
    }

}
