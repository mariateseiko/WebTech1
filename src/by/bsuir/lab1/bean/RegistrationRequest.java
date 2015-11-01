package by.bsuir.lab1.bean;

import by.bsuir.lab1.entity.User;

/**
 * A request for registering a new user
 */
public class RegistrationRequest extends Request {
    private User userInfo = new User();

    public void setUserLogin(String login){
        userInfo.setLogin(login);
    }

    public void setUserPassword(String password){
        userInfo.setPasswordHash(password);
    }

    public void setUserEmail(String email){
        userInfo.setEmail(email);
    }

    public User getUserInfo() {
        return userInfo;
    }
}
