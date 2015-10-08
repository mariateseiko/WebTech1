package by.bsuir.lab1.dao.file;

import by.bsuir.lab1.dao.DaoException;
import by.bsuir.lab1.dao.ModificationDao;
import by.bsuir.lab1.entity.Book;
import by.bsuir.lab1.entity.User;
import by.bsuir.lab1.entity.UserRole;
import by.bsuir.lab1.resource.ResourceManager;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Maria Teseiko on 10.09.2015.
 */
public class FileModificationDao implements ModificationDao {
    private final static FileModificationDao instance = new FileModificationDao();
    private final static String booksFile = ResourceManager.getInstance().getProperty("booksFile");
    private FileModificationDao(){}
    private FileCommonDao commonDao = FileCommonDao.getInstance();
    public static FileModificationDao getInstance() { return instance; }

    @Override
    public boolean addNewBook(Book book) throws DaoException {
        try {
            List<Book> books = commonDao.getAllBooks();
            books.add(book);
            commonDao.saveAllBooks(books);
        } catch (DaoException e) {
            throw new DaoException("Error adding new book");
        }
        return true;
    }

    @Override
    public boolean editBookTitle(int id, String newTitle) throws DaoException {
        try {
            List<Book> books = commonDao.getAllBooks();
            Book book = null;
            Iterator iterator = books.iterator();
            while (iterator.hasNext()) {
                book = (Book)iterator.next();
                if (book.getID() == id) {
                    break;
                }
            }
            if (book != null) {
                Book newBook = books.remove(books.indexOf(book));
                newBook.setTitle(newTitle);
                books.add(newBook);
                commonDao.saveAllBooks(books);
            }
            else return false;
        } catch (DaoException e) {
            throw new DaoException("Error adding new book");
        }
        return true;
    }

    @Override
    public boolean editBookAuthor(int id, String newAuthor) throws DaoException {
        try {
            List<Book> books = commonDao.getAllBooks();
            Book book = null;
            Iterator iterator = books.iterator();
            while (iterator.hasNext()) {
                book = (Book)iterator.next();
                if (book.getID() == id) {
                    break;
                }
            }
            if (book != null) {
                Book newBook = books.remove(books.indexOf(book));
                newBook.setAuthor(newAuthor);
                books.add(newBook);
                commonDao.saveAllBooks(books);
            }
            else return false;
        } catch (DaoException e) {
            throw new DaoException("Couldn't edit book's author");
        }
        return true;
    }



    @Override
    public boolean deleteBook(int id) throws DaoException {
        try {
            List<Book> books = commonDao.getAllBooks();
            Iterator<Book> iterator = books.iterator();
            while (iterator.hasNext()) {
                Book book = iterator.next();
                if (book.getID() == id) {
                    iterator.remove();
                    return true;
                }
            }

        } catch (DaoException e) {
            throw new DaoException("Couldn't edit book's author");
        }
        return false;
    }
}
