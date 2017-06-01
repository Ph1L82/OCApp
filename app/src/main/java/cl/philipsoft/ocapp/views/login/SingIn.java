package cl.philipsoft.ocapp.views.login;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cl.philipsoft.ocapp.models.ActiveUser;
import cl.philipsoft.ocapp.network.session.LoginInterceptor;
import cl.philipsoft.ocapp.network.session.Session;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by phil_ on 24-05-2017.
 */

public class SingIn {
    private SessionCallback callback;

    public SingIn(SessionCallback callback) {
        this.callback = callback;
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$");

    private boolean validateEmail(String email) {
        if (email.trim().length() > 0) {
            Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
            return matcher.find();
        }
        return false;
    }

    public void toServer(String email, String password) {
        if (email.trim().length() <= 0 || password.trim().length() <= 0) {
            callback.requieredField();
        } else {
            if (validateEmail(email)) {
                callback.mailFormat();
            } else {
                Session session = new LoginInterceptor().get();
                Call<ActiveUser> call = session.login(email, password);
                call.enqueue(new Callback<ActiveUser>() {
                    @Override
                    public void onResponse(Call<ActiveUser> call, Response<ActiveUser> response) {
                        if (200 == response.code() && response.isSuccessful()) {
                            ActiveUser user = response.body();
                            user.save();
                            callback.success(user);
                        } else {
                            callback.failed();
                        }
                    }

                    @Override
                    public void onFailure(Call<ActiveUser> call, Throwable t) {
                        callback.failed();
                    }
                });
            }
        }
    }
}
