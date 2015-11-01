package by.bsuir.lab1.service;

import by.bsuir.lab1.dao.DaoException;
import by.bsuir.lab1.dao.DaoFactory;
import by.bsuir.lab1.dao.UserDao;
import by.bsuir.lab1.entity.User;
import by.bsuir.lab1.entity.UserRole;

/**
 * A service that provides static methods for authenticating and authorizing users
 */
public class UserAuthorizationService {
    private UserAuthorizationService() {}

    /**
     * A service for authenticating and authorizing a {@link by.bsuir.lab1.entity.User} in the system
     * @param user user to be authorized
     * @return user's role in the system
     * @throws ServiceException Thrown if any exception on any underlying level is thrown
     */
    public static UserRole loginUserService(User user) throws ServiceException{
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        UserDao userDao = daoFactory.getUserDao();
        try {
            return  userDao.authorizeUser(user);
        } catch (DaoException e) {
            throw new ServiceException("Failed to login user", e);
        }
    }
}
