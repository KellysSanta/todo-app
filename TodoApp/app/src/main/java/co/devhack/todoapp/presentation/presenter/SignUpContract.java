package co.devhack.todoapp.presentation.presenter;

/**
 * Created by kellys on 30/11/2017.
 */

public interface SignUpContract {

    interface View{

        void goToLoginFragment();

        void goToMainActivity();


        void showMessageError(Exception error);
    }

    interface UserActionsListener{

        void onSignUp(String fullName, String email, String password);
    }
}
