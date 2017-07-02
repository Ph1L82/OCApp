package cl.philipsoft.ocapp.network.orders;

import cl.philipsoft.ocapp.models.OrdersWrapper;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by phil_ on 01-07-2017.
 */

public interface Orders {
    @GET("orders")
    Call<OrdersWrapper> get(@Query("api_token") String api_token, @Query("page") int page);
}
