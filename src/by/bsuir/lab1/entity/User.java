package by.bsuir.lab1.entity;

/**
 * The User class contains identifying info about any possible user of the system: guest, registered user and admin
 * @see UserRole
 */
public class User {
    private String login;
    private int passwordHash;
    private String email;
    private UserRole role;

    /**
     * Constructs a user with login-password, e-mail and role.
     *
     * <p>
     *     Typically used during while registering new user or in the process of extracting user's
     *     info from database/storage file
     * </p>
     * @param login user's login
     * @param passwordHash password's hashcode
     * @param email user's e-mail
     * @param role role in the system: guest(UserRole.GUEST), registered user(UserRole.USER) and admin(UserRole.ADMIN)
     *
     * @see UserRole
     */
    public User(String login, int passwordHash, String email, UserRole role) {
        this(login, passwordHash);
        this.email = email;
        this.role = role;
    }

    /**
     * Constructs a user with login and password
     *
     * <p>
     *     Typically used in authentication actions
     * </p>
     *
     * @param login user's login
     * @param passwordHash password's hashcode
     */
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

    public String getLogin() { return login; }

    public int getPasswordHash() { return passwordHash; }

    public String getEmail() { return email; }
}
