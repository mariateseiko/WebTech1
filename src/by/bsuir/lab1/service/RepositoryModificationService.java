package by.bsuir.lab1.service;

import by.bsuir.lab1.dao.DaoException;
import by.bsuir.lab1.dao.DaoFactory;
import by.bsuir.lab1.dao.ModificationDao;
import by.bsuir.lab1.entity.Book;

/**
 * A service that provides static methods for interactions
 * with DAOs for modification of the book repository
 */
public class RepositoryModificationService {
    private RepositoryModificationService() {}

    /**
     * A service for adding a new{@link by.bsuir.lab1.entity.Book} to the repository
     * @throws ServiceException Thrown if any exception on any underlying level is thrown
     */
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

    /**
     * A service for deleting a {@link by.bsuir.lab1.entity.Book} with a given ID from the repository
     * @throws ServiceException Thrown if any exception on any underlying level is thrown
     */
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

    /**
     * A service for editing a {@link by.bsuir.lab1.entity.Book}'s title with a given ID
     * @throws ServiceException Thrown if any exception on any underlying level is thrown
     */
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

    /**
     * A service for editing a {@link by.bsuir.lab1.entity.Book}'s author with a given ID
     * @throws ServiceException Thrown if any exception on any underlying level is thrown
     */
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

    /**
     * A service for editing a {@link by.bsuir.lab1.entity.Book}'s type with a given ID
     * @throws ServiceException Thrown if any exception on any underlying level is thrown
     */
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
