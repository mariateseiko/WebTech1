package by.bsuir.lab1.entity;

/**
 * Created by Maria Teseiko on 02.10.2015.
 */
public class User {
    private String login;
    private int passwordHash;
    private String email;
    private UserRole role;
    public User(String login, int password, String email) {
        this(login, password);
        this.email = email;

    }

    public User(String login, int passwordHash) {
        this.login = login;
        this.passwordHash = passwordHash;
    }

    public User() {}

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public int getPasswordHash() {
        return passwordHash;
    }
}
