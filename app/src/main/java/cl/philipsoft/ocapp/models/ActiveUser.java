package cl.philipsoft.ocapp.models;

import com.orm.SugarRecord;

/**
 * Created by phil_ on 24-05-2017.
 */

public class ActiveUser extends SugarRecord {
    private String email, name, api_token;

    public ActiveUser() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApi_token() {
        return api_token;
    }

    public void setApi_token(String api_token) {
        this.api_token = api_token;
    }
}
