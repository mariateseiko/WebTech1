package by.bsuir.lab1.service;

import by.bsuir.lab1.dao.DaoException;
import by.bsuir.lab1.dao.DaoFactory;
import by.bsuir.lab1.dao.FindDao;
import by.bsuir.lab1.dao.ModificationDao;
import by.bsuir.lab1.entity.Book;

import java.util.List;

/**
 * Created by Maria Teseiko on 03.10.2015.
 */
public class BookFindService  {
    private BookFindService() {}

    public List<Book> findAllBooksService() throws ServiceException {
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

    public List<Book> findBookByAuthorService(String author) throws ServiceException {
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

    public List<Book> findBookByTitleService(String title) throws ServiceException {
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

    public Book findBookByTitleAndAuthorService(String author, String title) throws ServiceException {
        Book book;
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        FindDao findDao = daoFactory.getFindDao();
        try {
            book = findDao.findBookByTitleAndAuthor(title, author);
        } catch (DaoException e) {
            throw new ServiceException("Service exception", e);
        }
        return book;
    }
}
