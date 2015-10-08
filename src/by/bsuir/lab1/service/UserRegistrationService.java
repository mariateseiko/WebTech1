package by.bsuir.lab1.service;

import by.bsuir.lab1.dao.DaoException;
import by.bsuir.lab1.dao.DaoFactory;
import by.bsuir.lab1.dao.UserDao;
import by.bsuir.lab1.entity.User;

/**
 * Created by Maria Teseiko on 03.10.2015.
 */
public class UserRegistrationService {
    private UserRegistrationService() {}

    public static boolean registerUserService(User user) throws ServiceException{
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        UserDao userDao = daoFactory.getUserDao();
        try {
            if (userDao.registerUser(user))
                return true;
            else return false;
        } catch (DaoException e) {
            throw new ServiceException("Service exception", e);
        }

    }
}
