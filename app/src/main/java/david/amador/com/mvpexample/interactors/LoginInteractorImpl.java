package david.amador.com.mvpexample.interactors;

import android.os.Handler;
import android.text.TextUtils;

import david.amador.com.mvpexample.interfaces.LoginInteractor;
import david.amador.com.mvpexample.interfaces.OnLoginFinishListener;

/**
 * Created by David on 25/06/2017.
 */

public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void validateUser(final String user, final String password, final OnLoginFinishListener listener) {

        new Handler().postDelayed(new Runnable(){

            @Override
            public void run() {
                if (!TextUtils.isEmpty(user) && !TextUtils.isEmpty(password)){

                    listener.onSucces();

                }else {
                    if (TextUtils.isEmpty(user)){
                        listener.userNameError();
                    }else if (TextUtils.isEmpty(password)){
                        listener.passwordError();
                    }
                }
            }
        }, 2000);

    }
}
