package by.bsuir.lab1.bean;

import by.bsuir.lab1.entity.UserRole;

/**
 * Created by Maria Teseiko on 05.10.2015.
 */
public class LoginResponse extends Response {
    private String resultMessage;

    private UserRole role;

    public void setRole(UserRole role) {
        this.role = role;
    }

    public UserRole getRole() {
        return role;
    }

    public String getResultMessage() {
    return resultMessage;
}

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
