package cl.philipsoft.ocapp.network.budgets;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import cl.philipsoft.ocapp.network.OCApi;
import cl.philipsoft.ocapp.network.accounts.Accounts;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by phil_ on 13-06-2017.
 */

public class BudgetInterceptor extends OCApi{

    public Budgets get() {
    /*This is very common in gets cause increase the response time wait and add headers and does retrys*/
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS);

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();

                Request request = originalRequest.newBuilder().build();

                Response response = chain.proceed(request);

            /*If the request fail then you get 3 retries*/
                int retryCount = 0;
                while (!response.isSuccessful() && retryCount < 3) {
                    retryCount++;
                    response = chain.proceed(request);
                }

                return response;
            }
        });

        OkHttpClient client = httpClient.build();

        Retrofit interceptor = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        Budgets budget = interceptor.create(Budgets.class);

        return budget;
    }
}
