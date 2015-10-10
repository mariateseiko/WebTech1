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
            book.setID(defineID(books));
            books.add(book);
            commonDao.saveAllBooks(books);
        } catch (DaoException e) {
            throw new DaoException("Error adding new book");
        }
        return true;
    }

    private int defineID(List<Book> books) {
        ArrayList<Integer> idCount = new ArrayList<>();
        for(Book book: books) {
            idCount.set(book.getID(), 1);
        }
        int result = -1;
        for (int i = 0; i < idCount.size(); i++) {
            if (idCount.get(i) == 0) {
                result = i;
                break;
            }
        }
        if (result < 0)
            return idCount.size();
        else
            return result;
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
    public boolean editBookType(int id) throws DaoException {
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
                newBook.setType(!newBook.getType());
                books.add(newBook);
                commonDao.saveAllBooks(books);
            }
            else return false;
        } catch (DaoException e) {
            throw new DaoException("Couldn't edit book's type");
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
