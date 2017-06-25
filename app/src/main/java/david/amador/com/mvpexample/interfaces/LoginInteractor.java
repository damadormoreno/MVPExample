package david.amador.com.mvpexample.interfaces;

/**
 * Created by David on 25/06/2017.
 */

public interface LoginInteractor {

    void validateUser(String user, String password, OnLoginFinishListener listener);

}
