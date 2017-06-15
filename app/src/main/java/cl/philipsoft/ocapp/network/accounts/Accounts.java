package cl.philipsoft.ocapp.network.accounts;

import cl.philipsoft.ocapp.models.AccountsWrapper;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by phil_ on 13-06-2017.
 */

public interface Accounts {
    @GET("accounts")
    Call<AccountsWrapper> get(@Query("api_token") String api_token, @Query("page") int page);
}
