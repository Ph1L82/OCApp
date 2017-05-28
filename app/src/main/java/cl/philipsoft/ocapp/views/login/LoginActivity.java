package cl.philipsoft.ocapp.views.login;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;

import cl.philipsoft.ocapp.R;
import io.fabric.sdk.android.Fabric;

public class LoginActivity extends AppCompatActivity implements SessionCallback {

    private TextInputLayout emailTil, passwdTil;
    private EditText emailEt, passwdEt;
    private Button loginBt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());

        setContentView(R.layout.activity_login);

        View view = findViewById(R.id.loginLayout);
        view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);


        emailEt= (EditText) findViewById(R.id.emailEt);
        passwdEt= (EditText) findViewById(R.id.passwordEt);
        loginBt = (Button) findViewById(R.id.loginBt);
        loginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEt.getText().toString();
                String passwd = passwdEt.getText().toString();



                new SingIn(LoginActivity.this).toServer(email,passwd);
            }
        });
    }

    @Override
    public void requieredField() {

    }

    @Override
    public void mailFormat() {

    }

    @Override
    public void success() {

    }

    @Override
    public void failed() {

    }
}
