package cl.philipsoft.ocapp.background.asynctasks;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import cl.philipsoft.ocapp.data.OrdersData;
import cl.philipsoft.ocapp.models.OrdersWrapper;
import cl.philipsoft.ocapp.network.RequestCode;
import cl.philipsoft.ocapp.network.orders.Orders;
import cl.philipsoft.ocapp.network.orders.OrdersInterceptor;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by phil_ on 01-07-2017.
 */

public class GetOrders extends AsyncTask<String, Integer, Integer> {
    private final Orders request = new OrdersInterceptor().get();
    private int code = 667;

    @Override
    protected Integer doInBackground(String... params) {
        Log.d("GETORDERS", "params[0]: " + params[0]);
        int currentPage = 1;
        int lastPage = lastPage(request.get(params[0], currentPage));
        currentPage++;

        for (int i = currentPage; 1 <= lastPage; i++) {
            lastPage(request.get(params[0], i));
        }
        return code;
    }

    private int lastPage(Call<OrdersWrapper> call) {
        int lastPage =0;
        try {
            Response<OrdersWrapper> response = call.execute();
            code=response.code();
            if (RequestCode.OK == code && response.isSuccessful()){
                OrdersWrapper wrapper = response.body();
                if (wrapper!=null&&wrapper.getData().length>0){
                    new OrdersData().handler(wrapper.getData());
                    lastPage = wrapper.getLast_page();
                }else{
                    code = 878470;
                }
            }else {
                Log.d("GETORDERS", "Request code: " + String.valueOf(code));
            }
        } catch (IOException e) {
            e.printStackTrace();
            code = e.hashCode();
        }
        return lastPage;
    }
}
