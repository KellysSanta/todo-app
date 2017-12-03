package co.devhack.todoapp.presentation.presenter;

/**
 * Created by kellys on 30/11/2017.
 */

public class AuthPresenter implements AuthContract.UserActionLister {

    private AuthContract.View view;

    public AuthPresenter(AuthContract.View view) {
        this.view = view;
    }

    @Override
    public void goToFirstFragment() {
        view.goToLoginFragment();

        //view.goMainActivity
    }
}
