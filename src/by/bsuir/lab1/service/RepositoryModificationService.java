package by.bsuir.lab1.service;

import by.bsuir.lab1.dao.DaoException;
import by.bsuir.lab1.dao.DaoFactory;
import by.bsuir.lab1.dao.ModificationDao;
import by.bsuir.lab1.entity.Book;
import by.bsuir.lab1.entity.User;

/**
 * Created by Maria Teseiko on 03.10.2015.
 */
public class RepositoryModificationService {
    private RepositoryModificationService() {}

    public static boolean addNewBookService(Book book) throws ServiceException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        ModificationDao modificationDao = daoFactory.getModificationDao();
        try {
            modificationDao.addNewBook(book);
        } catch (DaoException e) {
            throw new ServiceException("Service exception", e);
        }
        return true;
    }

    public static boolean deleteBookService(int id) throws ServiceException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        ModificationDao modificationDao = daoFactory.getModificationDao();
        try {
            modificationDao.deleteBook(id);
        } catch (DaoException e) {
            throw new ServiceException("Service exception", e);
        }
        return true;
    }

    public static boolean editBookTitleService(int id, String newTitle) throws ServiceException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        ModificationDao modificationDao = daoFactory.getModificationDao();
        try {
            modificationDao.editBookTitle(id, newTitle);
        } catch (DaoException e) {
            throw new ServiceException("Service exception", e);
        }
        return true;
    }

    public static boolean editBookAuthorService(int id, String newAuthor) throws ServiceException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        ModificationDao modificationDao = daoFactory.getModificationDao();
        try {
            modificationDao.editBookAuthor(id, newAuthor);
        } catch (DaoException e) {
            throw new ServiceException("Service exception", e);
        }
        return true;
    }

    public static boolean editBookTypeService(int id) throws ServiceException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        ModificationDao modificationDao = daoFactory.getModificationDao();
        try {
            modificationDao.editBookType(id);
        } catch (DaoException e) {
            throw new ServiceException("Service exception", e);
        }
        return true;
    }
}
