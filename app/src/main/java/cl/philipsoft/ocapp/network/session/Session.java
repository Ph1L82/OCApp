package cl.philipsoft.ocapp.network.session;

import cl.philipsoft.ocapp.models.ActiveUser;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by phil_ on 24-05-2017.
 */

public interface Session {
    @FormUrlEncoded
    @POST("login")
    Call<ActiveUser> login(@Field("email") String email, @Field("password")String password);
}
