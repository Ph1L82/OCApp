package cl.philipsoft.ocapp.network.budgets;

import cl.philipsoft.ocapp.models.Budget;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by phil_ on 13-06-2017.
 */

public interface Budgets {
    @GET("budgets")
    Call<Budget[]> get(@Query("api_token") String api_token);
}
