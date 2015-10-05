package by.bsuir.lab1.dao;

import by.bsuir.lab1.entity.User;

/**
 * Created by Maria Teseiko on 10.09.2015.
 */
public interface UserDao {
    boolean authorizeUser(User user) throws DaoException;
    boolean registerUser(User user) throws DaoException;
}
