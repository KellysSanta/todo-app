package co.devhack.todoapp.helpers;

import co.devhack.todoapp.domain.model.User;

/**
 * Created by kellys on 2/12/2017.
 */

public interface Callback<T> {
    void success(T result);

    void error(Exception e);
}
