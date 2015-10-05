package by.bsuir.lab1.bean;

import by.bsuir.lab1.entity.User;

/**
 * Created by Maria Teseiko on 03.10.2015.
 */
public class LoginRequest extends Request {
    private User user;

    public void setUser(String login, String password) {
        user = new User(login, password.hashCode());
    }

    public User getUser() {
        return user;
    }
}
