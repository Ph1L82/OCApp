package cl.philipsoft.ocapp.views.login;

/**
 * Created by phil_ on 24-05-2017.
 */

public interface SessionCallback {

    void requieredField();
    void mailFormat();
    void success();
    void failed();
}
