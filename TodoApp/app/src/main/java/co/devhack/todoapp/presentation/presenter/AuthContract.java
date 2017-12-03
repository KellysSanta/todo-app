package co.devhack.todoapp.presentation.presenter;

/**
 * Created by kellys on 30/11/2017.
 */

public interface AuthContract {

        //Interface que implemnetara el Fragment o Activity
    interface View{
        void goToLoginFragment();



        void goMainActivity();

    }

        //Interface que implementara el presente
    interface UserActionLister{
        void goToFirstFragment();

    }
}
