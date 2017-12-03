package co.devhack.todoapp.presentation.View.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import co.devhack.todoapp.R;
import co.devhack.todoapp.presentation.View.fragment.LoginFragment;
import co.devhack.todoapp.presentation.presenter.AuthContract;
import co.devhack.todoapp.presentation.presenter.AuthPresenter;

public class AuthActivity extends AppCompatActivity implements AuthContract.View{

    //Creando referencia del presente
    private AuthContract.UserActionLister mActionListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        mActionListener = new AuthPresenter(this);

        mActionListener.goToFirstFragment();
    }

    public void replaceFragment(Fragment fragment, boolean addToBackStack){
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);

        if(addToBackStack){
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();



    }

    @Override
    public void goToLoginFragment() {
        replaceFragment (LoginFragment.getInstance(), true);

    }

    //@Override
    //public void goToSignUpFragment() {

//    }

    @Override
    public void goMainActivity() {

    }
}
