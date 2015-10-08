package by.bsuir.lab1.entity;

import java.io.Serializable;

/**
 * Created by Maria Teseiko on 02.10.2015.
 */
public class User implements Serializable {
    private String login;
    private int passwordHash;
    private String email;
    private UserRole role;
    public User(String login, int password, String email, UserRole role) {
        this(login, password);
        this.email = email;
        this.role = role;
    }

    public User(String login, int passwordHash) {
        this.login = login;
        this.passwordHash = passwordHash;
    }

    public User() {}

    public void setRole(UserRole role) {
        this.role = role;
    }

    public UserRole getRole() { return role; }

    public void setLogin(String login) { this.login = login; }

    public void setPasswordHash(String password) { this.passwordHash = password.hashCode(); }

    public void setEmail(String email) { this.email = email; }

    public String getLogin() {
        return login;
    }

    public int getPasswordHash() {
        return passwordHash;
    }

    public String getEmail() { return email; }
}
