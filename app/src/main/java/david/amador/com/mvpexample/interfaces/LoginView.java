package david.amador.com.mvpexample.interfaces;

/**
 * Created by David on 25/06/2017.
 */

public interface LoginView {

    void showProgress();
    void hideProgress();

    void setErrorUser();
    void setErrorPassword();

    void navigateToHome();

}
