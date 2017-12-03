package co.devhack.todoapp.presentation.View.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import co.devhack.todoapp.R;
import co.devhack.todoapp.helpers.Utilities;
import co.devhack.todoapp.presentation.View.activity.AuthActivity;
import co.devhack.todoapp.presentation.View.activity.MainActivity;
import co.devhack.todoapp.presentation.presenter.LoginContract;
import co.devhack.todoapp.presentation.presenter.LoginPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements LoginContract.View, View.OnClickListener {

    private LoginContract.UserActionsListener mActionListener;
    private TextInputLayout tilEmail;
    private TextInputLayout tilPassword;
    private TextView tvForgotPassword;
    private Switch swRemember;
    private Button btnStar;
    private Button btnNotHaceAccount;




    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment getInstance(){
        return new LoginFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        mActionListener= new LoginPresenter(this);

        tilEmail = view.findViewById(R.id.tilEmail);
        tilPassword = view.findViewById(R.id.tilPassword);
        tvForgotPassword = view.findViewById(R.id.tvForgotPassword);
        swRemember = view.findViewById(R.id.swRemember);
        btnStar = view.findViewById(R.id.btnStart);
        btnNotHaceAccount = view.findViewById(R.id.btnNotHaveAccount);

        btnStar.setOnClickListener(this);
        btnNotHaceAccount.setOnClickListener(this);
        tvForgotPassword.setOnClickListener(this);


        return view;
    }

    @Override
    public void goToSignUpFragment() {
        AuthActivity authActivity = (AuthActivity) getActivity();
        authActivity.replaceFragment(SignUpFragment.getInstance(), true);

    }

    @Override
    public void goToMainActivity() {
        Intent intent = new Intent(getContext(), MainActivity.class);
        startActivity(intent);

    }

    public void goToRecoveryPassword(){
        RecoveryPasswordFragment recoveryPasswordFragment = RecoveryPasswordFragment.getInstance();
        recoveryPasswordFragment.show(getFragmentManager(), null);

    }

    @Override
    public void showMessageError(Exception error) {
        Snackbar.make(getView(), error.getMessage(),Snackbar.LENGTH_LONG).show();

    }

    private void onLogin(){
        try {
            boolean result=true;
            String email= tilEmail.getEditText().getText().toString();
            String password = tilPassword.getEditText().getText().toString();
            boolean remember = swRemember.isChecked();

            if(Utilities.isEmpty(email)){
                tilEmail.setError(getString(R.string.is_required));
                tilEmail.setErrorEnabled(true);
                result=false;
            }else{
                tilEmail.setError(null);
                tilEmail.setErrorEnabled(false);
            }

            if(Utilities.isEmpty(email)){
                tilPassword.setError(getString(R.string.is_required));
                tilPassword.setErrorEnabled(true);
                result=false;
            }else{
                tilPassword.setError(null);
                tilPassword.setErrorEnabled(false);
            }

            if(result){
                mActionListener.onLogin(email, password, remember);
            }
        }catch (Exception e){

        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnStart:
                onLogin();
                break;
            case R.id.btnNotHaveAccount:
                goToSignUpFragment();
                break;
            case R.id.tvForgotPassword:
                goToRecoveryPassword();
                break;
        }

    }
}
