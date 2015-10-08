package by.bsuir.lab1.service;

import by.bsuir.lab1.dao.DaoException;
import by.bsuir.lab1.dao.DaoFactory;
import by.bsuir.lab1.dao.UserDao;
import by.bsuir.lab1.entity.User;
import by.bsuir.lab1.entity.UserRole;

/**
 * Created by Maria Teseiko on 03.10.2015.
 */
public class UserAuthorizationService {
    private UserAuthorizationService() {}

    public static UserRole loginUserService(User user) throws ServiceException{
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        UserDao userDao = daoFactory.getUserDao();
        try {
            UserRole role = userDao.authorizeUser(user);
            return role;
        } catch (DaoException e) {
            throw new ServiceException("Service exception", e);
        }
    }

    public static boolean logoutUserService(User user) {
        User newGuest = new User();
        newGuest.setRole(UserRole.GUEST);
        user = newGuest;
        return true;
    }


}
