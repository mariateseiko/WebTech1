package by.bsuir.lab1.bean;

import by.bsuir.lab1.entity.User;
import by.bsuir.lab1.entity.UserRole;

/**
 * A response of logout command result
 */
public class LogoutResponse extends Response {
    private String resultMessage;
    private User user;

    public String getResultMessage() {
        return resultMessage;
    }
    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public void setUser() { user = new User(); user.setRole(UserRole.GUEST); }
    public User getUser() { return user; }
}
