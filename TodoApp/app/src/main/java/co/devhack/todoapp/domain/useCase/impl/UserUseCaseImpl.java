package co.devhack.todoapp.domain.useCase.impl;

import co.devhack.todoapp.domain.model.User;
import co.devhack.todoapp.domain.useCase.UserUseCase;
import co.devhack.todoapp.helpers.Callback;
import co.devhack.todoapp.repository.UserRepository;
import co.devhack.todoapp.repository.impl.UserFirebaseRepository;

/**
 * Created by kellys on 2/12/2017.
 */

public class UserUseCaseImpl implements UserUseCase {

    private UserRepository userRepository;

    public UserUseCaseImpl() {
        this.userRepository = new UserFirebaseRepository();
    }

    @Override
    public void login(String email, String password, final boolean remember, final Callback<User> callback) {
        userRepository.login(email, password, new Callback<User>() {
            @Override
            public void success(User user) {

                if(user != null && remember){
                    //TODO GUARDAR EMAIL EN SharedPreferences
                }
                callback.success(user);
            }

            @Override
            public void error(Exception error) {
                //error.getCode() = 0001
                  callback.error(error);

            }
        });


    }

    @Override
    public void signUp(String fullName, String email, String password, final Callback<User> callback) {
        User user = new User(fullName, email, password);
        userRepository.signUp(user, new Callback<User>() {
            @Override
            public void success(User user) {
                callback.success(user);
            }

            @Override
            public void error(Exception error) {
                callback.error(error);

            }
        });

    }
}
