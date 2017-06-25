package david.amador.com.mvpexample.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import david.amador.com.mvpexample.R;
import david.amador.com.mvpexample.interfaces.LoginPresenter;
import david.amador.com.mvpexample.interfaces.LoginView;
import david.amador.com.mvpexample.presenters.LoginPresenterImpl;

public class Login extends AppCompatActivity implements LoginView{

    private EditText user, password;
    private Button btnLogin;
    private ProgressBar progressBar;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        user = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        btnLogin = (Button) findViewById(R.id.button);

        presenter = new LoginPresenterImpl(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation(v);
            }
        });
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setErrorUser() {
        user.setError("Campo obligatorio");
    }

    @Override
    public void setErrorPassword() {
        user.setError("Contraseña incorrecta");
    }

    @Override
    public void navigateToHome() {
        //startActivity(this, Menu.class);
        Toast.makeText(this, "Login Hecho", Toast.LENGTH_SHORT).show();
    }

    public void validation(View v){
        presenter.validateUser(user.getText().toString(), password.getText().toString());
    }
}
