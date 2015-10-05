package by.bsuir.lab1.bean;

import by.bsuir.lab1.entity.User;
import by.bsuir.lab1.entity.UserRole;

/**
 * Created by Maria Teseiko on 05.10.2015.
 */
public class LogoutResponse extends Response {
    private String resultMessage;

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    private User user;

    public void setGuestUser() { user = new User(); user.setRole(UserRole.GUEST); }

    public User getUser() { return user; }
}
