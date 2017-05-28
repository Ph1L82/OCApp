package cl.philipsoft.ocapp.views.login;


import cl.philipsoft.ocapp.network.session.Session;

/**
 * Created by phil_ on 24-05-2017.
 */

public class SingIn {
    private SessionCallback callback;

    public SingIn(SessionCallback callback) {
        this.callback = callback;
    }

    public void toServer(String email, String password){
        if (email.trim().length() <= 0 || password.trim().length() <= 0) {
            callback.requieredField();
        } else {
            if (!email.contains("@")) {
                callback.mailFormat();
            } else {
                Session session = new LoginInterceptor().get();
                Call<CurrentUser> call = session.loggin(email, password);
                call.enqueue(new Callback<CurrentUser>() {
                    @Override
                    public void onResponse(Call<CurrentUser> call, Response<CurrentUser> response) {
                        if (200 == response.code() && response.isSuccessful()) {
                            CurrentUser user = response.body();
                            user.create();
                            callback.success();
                        } else {
                            callback.failed();
                        }
                    }

                    @Override
                    public void onFailure(Call<CurrentUser> call, Throwable t) {
                        callback.failed();
                    }
                });
            }
        }
    }
}
