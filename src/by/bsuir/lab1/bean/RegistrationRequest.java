package by.bsuir.lab1.bean;

import by.bsuir.lab1.entity.User;

/**
 * Created by Maria Teseiko on 05.10.2015.
 */
public class RegistrationRequest extends Request {
    private User userInfo = new User();

    public void setUserInfo(String login, String password, String email) {
        userInfo = new User(login, password.hashCode());
    }

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
