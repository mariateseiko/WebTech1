package by.bsuir.lab1.dao;

import by.bsuir.lab1.entity.User;
import by.bsuir.lab1.entity.UserRole;

/**
 * The User Data Access Object is the interface providing access to User-related information and actions.
 */
public interface UserDao {
    /**
     * Validates given user's login and password and returns corresponding user role
     *
     * @param user contains user's login and password required for authorization
     * @return role of the user with given login and password; null if user with given credentials doesn't exist
     * @throws DaoException Thrown if any issue occurs while working with database/file
     */
    UserRole authorizeUser(User user) throws DaoException;

    /**
     * Adds a new user with given credentials
     * @param user contains user's info required for successful registration
     * @return true if user was successfully added to the storage
     * @throws DaoException Thrown if any issue occurs while working with database/file
     */
    boolean registerUser(User user) throws DaoException;
}
