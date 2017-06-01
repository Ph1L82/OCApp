package cl.philipsoft.ocapp.network.session;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by phil_ on 31-05-2017.
 */

public class LoginInterceptor {

    protected static final String BASE_URL = "https://oca.philipsoft.cl/api/";

    public Session get() {
        Retrofit interceptor = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Session session = interceptor.create(Session.class);
        return session;
    }
}
