package david.amador.com.mvpexample.presenters;

import david.amador.com.mvpexample.interactors.LoginInteractorImpl;
import david.amador.com.mvpexample.interfaces.LoginInteractor;
import david.amador.com.mvpexample.interfaces.LoginPresenter;
import david.amador.com.mvpexample.interfaces.LoginView;
import david.amador.com.mvpexample.interfaces.OnLoginFinishListener;

/**
 * Created by David on 25/06/2017.
 */

public class LoginPresenterImpl implements LoginPresenter, OnLoginFinishListener {

    private LoginView view;
    private LoginInteractor interactor;


    public LoginPresenterImpl(LoginView view) {
        this.view = view;
        interactor = new LoginInteractorImpl();
    }

    @Override
    public void validateUser(String user, String passwd) {
        if (view != null){
            view.showProgress();
        }
        interactor.validateUser(user, passwd, this);
    }

    @Override
    public void userNameError() {
        if (view != null){
            view.hideProgress();
            view.setErrorUser();
        }

    }

    @Override
    public void passwordError() {
        if (view != null){
            view.hideProgress();
            view.setErrorPassword();
        }

    }

    @Override
    public void onSucces() {
        if (view != null){
            view.hideProgress();
            view.navigateToHome();
        }

    }
}
