package co.devhack.todoapp.domain.useCase;

import co.devhack.todoapp.domain.model.User;
import co.devhack.todoapp.helpers.Callback;

/**
 * Created by kellys on 2/12/2017.
 */

public interface UserUseCase {
    void login(String email, String password, boolean remember, Callback<User> callback);

    void signUp(String fullName, String email, String password, Callback<User> callback);
}
