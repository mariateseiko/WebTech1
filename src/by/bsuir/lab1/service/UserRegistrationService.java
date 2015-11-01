package by.bsuir.lab1.service;

import by.bsuir.lab1.dao.DaoException;
import by.bsuir.lab1.dao.DaoFactory;
import by.bsuir.lab1.dao.UserDao;
import by.bsuir.lab1.entity.User;

/**
 *  A service that provides static methods for registering new users
 */
public class UserRegistrationService {
    private UserRegistrationService() {}

    /**
     * A service for registering a new {@link by.bsuir.lab1.entity.User}
     * @param user user to be registered
     * @return true if registration succeeded
     * @throws ServiceException Thrown if any exception on any underlying level is thrown
     */
    public static boolean registerUserService(User user) throws ServiceException{
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        UserDao userDao = daoFactory.getUserDao();
        try {
            return userDao.registerUser(user);
        } catch (DaoException e) {
            throw new ServiceException("Failed to register user");
        }

    }
}
