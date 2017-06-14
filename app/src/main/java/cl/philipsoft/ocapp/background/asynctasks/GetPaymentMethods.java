package cl.philipsoft.ocapp.background.asynctasks;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import cl.philipsoft.ocapp.data.PaymentMethodsData;
import cl.philipsoft.ocapp.models.PaymentMethod;
import cl.philipsoft.ocapp.network.RequestCode;
import cl.philipsoft.ocapp.network.paymentMethods.PaymentMethodInterceptor;
import cl.philipsoft.ocapp.network.paymentMethods.PaymentMethods;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by phil_ on 13-06-2017.
 */

public class GetPaymentMethods extends AsyncTask<String, Integer, Integer> {
    private final PaymentMethods request = new PaymentMethodInterceptor().get();
    private int code = 667;

    @Override
    protected Integer doInBackground(String... params) {
        Log.d("GETPAYMENTMETHODS", "params[0]: " + params[0]);
        Call<PaymentMethod[]> call = request.get(params[0]);

        try {
            Response<PaymentMethod[]> response = call.execute();
            code = response.code();
            if (RequestCode.OK == code && response.isSuccessful()) {
                PaymentMethod[] paymentMethods = response.body();
                if (paymentMethods != null && paymentMethods.length > 0) {
                    new PaymentMethodsData().handler(paymentMethods);
                } else {
                    code = 878470;
                }
            } else {
                Log.d("GETPAYMENTMETHODS", "Request code: " + String.valueOf(code));
            }
        } catch (IOException e) {
            e.printStackTrace();
            code = e.hashCode();
        }
        return code;
    }
}
