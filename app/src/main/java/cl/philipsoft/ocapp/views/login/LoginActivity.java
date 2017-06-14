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
import cl.philipsoft.ocapp.models.ActiveUser;
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

        emailEt = (EditText) findViewById(R.id.emailEt);
        passwdEt = (EditText) findViewById(R.id.passwordEt);
        loginBt = (Button) findViewById(R.id.loginBt);
        emailTil = (TextInputLayout) findViewById(R.id.emailTil);
        passwdTil = (TextInputLayout) findViewById(R.id.passwdTil);

        loginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEt.getText().toString();
                String passwd = passwdEt.getText().toString();
                emailTil.setVisibility(View.GONE);
                passwdTil.setVisibility(View.GONE);
                loginBt.setVisibility(View.GONE);

                new SingIn(LoginActivity.this).toServer(email, passwd);
            }
        });
    }

    @Override
    public void requieredField() {
        restoreViews();
        emailEt.setError(String.valueOf(R.string.required_field));
        passwdEt.setError(String.valueOf(R.string.required_field));
    }

    private void restoreViews() {
        emailEt.setError(null);
        passwdEt.setError(null);
        emailTil.setVisibility(View.VISIBLE);
        passwdTil.setVisibility(View.VISIBLE);
        loginBt.setVisibility(View.VISIBLE);
    }

    @Override
    public void mailFormat() {
        restoreViews();
        emailEt.setError(String.valueOf(R.string.mail_format_error));
    }

    @Override
    public void success(ActiveUser user) {
        Toast.makeText(this, user.getName() + " logged with tokn: " + user.getApi_token(), Toast.LENGTH_SHORT).show();
        // TODO: 31-05-2017 start service to get: accounts, budget, last purchase orders

    }

    @Override
    public void failed() {
        Toast.makeText(this, "FAILED!", Toast.LENGTH_SHORT).show();
        restoreViews();
    }
}
