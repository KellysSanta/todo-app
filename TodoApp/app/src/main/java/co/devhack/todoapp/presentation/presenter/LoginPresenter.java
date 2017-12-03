package co.devhack.todoapp.presentation.presenter;

import co.devhack.todoapp.domain.model.User;
import co.devhack.todoapp.domain.useCase.UserUseCase;
import co.devhack.todoapp.domain.useCase.impl.UserUseCaseImpl;
import co.devhack.todoapp.helpers.Callback;

/**
 * Created by kellys on 30/11/2017.
 */

public class LoginPresenter implements LoginContract.UserActionsListener{

    private LoginContract.View view;
    private UserUseCase userUseCase;


    public LoginPresenter(LoginContract.View view) {

        this.view = view;
        this.userUseCase = new UserUseCaseImpl();
    }



    @Override
    public void onLogin(String email, String password, boolean remember) {
        userUseCase.login(email, password, remember, new Callback<User>() {
            @Override
            public void success(User result) {
                view.goToMainActivity();
            }

            @Override
            public void error(Exception error) {
                view.showMessageError(error);
            }
        });
    }
}
