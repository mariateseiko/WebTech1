package by.bsuir.lab1.bean;

import by.bsuir.lab1.entity.User;

/**
 * A request to login user into the system
 */
public class LoginRequest extends Request {
    private User userInfo = new User();

    public void setUserLogin(String login){
        userInfo.setLogin(login);
    }

    public void setUserPassword(String password){
        userInfo.setPasswordHash(password);
    }

    public User getUser() {
        return userInfo;
    }
}
