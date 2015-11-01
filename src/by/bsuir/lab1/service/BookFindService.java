package by.bsuir.lab1.service;

import by.bsuir.lab1.dao.DaoException;
import by.bsuir.lab1.dao.DaoFactory;
import by.bsuir.lab1.dao.FindDao;
import by.bsuir.lab1.entity.Book;

import java.util.List;

/**
 * A service that provides static methods for interactions
 * with DAOs for searching books in the repository
 */
public class BookFindService  {
    private BookFindService() {}

    /**
     * A service for getting a list of all {@link by.bsuir.lab1.entity.Book}
     * @throws ServiceException Thrown if any exception on any underlying level is thrown
     */
    public static List<Book> listAllBooksService() throws ServiceException {
        List<Book> books;
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        FindDao findDao = daoFactory.getFindDao();
        try {
            books = findDao.findAllBooks();
        } catch (DaoException e) {
            throw new ServiceException("Service exception", e);
        }
        return books;
    }

    /**
     * A service for getting a list of all {@link by.bsuir.lab1.entity.Book} with matching author
     * @param author author of the books to be found
     * @return a list of books with matching parameters
     * @throws ServiceException Thrown if any exception on any underlying level is thrown
     */
    public static List<Book> findBookByAuthorService(String author) throws ServiceException {
        List<Book> books;
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        FindDao findDao = daoFactory.getFindDao();
        try {
            books = findDao.findBookByAuthor(author);
        } catch (DaoException e) {
            throw new ServiceException("Service exception", e);
        }
        return books;
    }

    /**
     * A service for getting a list of all {@link by.bsuir.lab1.entity.Book} with matching title
     * @param title title of the books to be found
     * @return a list of books with matching parameters
     * @throws ServiceException Thrown if any exception on any underlying level is thrown
     */
    public static List<Book> findBookByTitleService(String title) throws ServiceException {
        List<Book> books;
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        FindDao findDao = daoFactory.getFindDao();
        try {
            books = findDao.findBookByTitle(title);
        } catch (DaoException e) {
            throw new ServiceException("Service exception", e);
        }
        return books;
    }

    /**
     * A service for getting a list of all {@link by.bsuir.lab1.entity.Book} with matching title and author
     * @param title title of the books to be found
     * @param author author of the books to be found
     * @return a list of books with matching parameters
     * @throws ServiceException Thrown if any exception on any underlying level is thrown
     */
    public static List<Book> findBooksByTitleAndAuthorService(String author, String title) throws ServiceException {
        List<Book> books;
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        FindDao findDao = daoFactory.getFindDao();
        try {
            books = findDao.findBookByTitleAndAuthor(title, author);
        } catch (DaoException e) {
            throw new ServiceException("Service exception", e);
        }
        return books;
    }
}
