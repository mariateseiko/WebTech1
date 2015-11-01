package by.bsuir.lab1.bean;

import by.bsuir.lab1.entity.UserRole;

/**
 * A response to {@link by.bsuir.lab1.bean.LoginRequest}
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
