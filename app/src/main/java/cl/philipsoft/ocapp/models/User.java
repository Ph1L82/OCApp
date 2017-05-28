package cl.philipsoft.ocapp.models;

import com.orm.SugarRecord;

/**
 * Created by phil_ on 24-05-2017.
 */

public class User extends SugarRecord {
    private String email, password, api_token;

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApi_token() {
        return api_token;
    }

    public void setApi_token(String api_token) {
        this.api_token = api_token;
    }
}
