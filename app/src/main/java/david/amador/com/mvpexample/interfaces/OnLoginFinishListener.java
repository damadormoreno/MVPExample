package david.amador.com.mvpexample.interfaces;

/**
 * Created by David on 25/06/2017.
 */

public interface OnLoginFinishListener {

    void userNameError();
    void passwordError();

    void onSucces();
}
