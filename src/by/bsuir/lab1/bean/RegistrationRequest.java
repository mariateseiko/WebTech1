package by.bsuir.lab1.bean;

import by.bsuir.lab1.entity.User;

/**
 * Created by Maria Teseiko on 05.10.2015.
 */
public class RegistrationRequest extends Request {
    private User userInfo;

    public void setUserInfo(String login, String password) {
        userInfo = new User(login, password.hashCode());
    }

    public User getUserInfo() {
        return userInfo;
    }

}
