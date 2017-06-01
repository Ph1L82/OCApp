package cl.philipsoft.ocapp.views.login;

import cl.philipsoft.ocapp.models.ActiveUser;

/**
 * Created by phil_ on 24-05-2017.
 */

public interface SessionCallback {

    void requieredField();
    void mailFormat();
    void success(ActiveUser user);
    void failed();
}
