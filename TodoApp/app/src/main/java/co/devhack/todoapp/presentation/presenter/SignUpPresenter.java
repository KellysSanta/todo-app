package co.devhack.todoapp.presentation.presenter;

import co.devhack.todoapp.domain.model.User;
import co.devhack.todoapp.domain.useCase.UserUseCase;
import co.devhack.todoapp.domain.useCase.impl.UserUseCaseImpl;
import co.devhack.todoapp.helpers.Callback;

/**
 * Created by kellys on 30/11/2017.
 */

public class SignUpPresenter implements SignUpContract.UserActionsListener{

    private SignUpContract.View view;
    private UserUseCase userUseCase;

    public SignUpPresenter(SignUpContract.View view) {
        this.view = view;
        this.userUseCase = new UserUseCaseImpl();
    }

    @Override
    public void onSignUp(String fullName, String email, String password) {
        userUseCase.signUp(fullName, email, password, new Callback<User>() {
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
