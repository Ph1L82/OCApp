package cl.philipsoft.ocapp.network.paymentMethods;

import cl.philipsoft.ocapp.models.PaymentMethod;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by phil_ on 13-06-2017.
 */

public interface PaymentMethods {
    @GET("paymentmethods")
    Call<PaymentMethod[]> get(@Query("api_token") String api_token);
}
