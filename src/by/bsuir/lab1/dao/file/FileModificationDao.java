package by.bsuir.lab1.dao.file;

import by.bsuir.lab1.dao.DaoException;
import by.bsuir.lab1.dao.ModificationDao;
import by.bsuir.lab1.entity.Book;
import by.bsuir.lab1.resource.ResourceManager;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Maria Teseiko on 10.09.2015.
 */
public class FileModificationDao implements ModificationDao {
    private final static FileModificationDao instance = new FileModificationDao();
    private final static String booksFile = ResourceManager.getInstance().getProperty("booksFile");
    private FileModificationDao(){}

    public static FileModificationDao getInstance() { return instance; }

    @Override
    public boolean addNewBook(Book book) throws DaoException {
        try {
            List<Book> books = getAllBooks();
            books.add(book);
            saveAllBooks(books);
        } catch (DaoException e) {
            throw new DaoException("Error adding new book");
        }
        return true;
    }

    @Override
    public boolean editBookTitle(int id, String newTitle) throws DaoException {
        try {
            List<Book> books = getAllBooks();
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
                saveAllBooks(books);
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
            List<Book> books = getAllBooks();
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
                saveAllBooks(books);
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
            List<Book> books = getAllBooks();
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

    private List<Book> getAllBooks() throws DaoException{
        ArrayList<Book> result;
        try {
            FileInputStream fileInputStream = new FileInputStream(booksFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            result = (ArrayList<Book>)objectInputStream.readObject();
        } catch(IOException e){
            throw new DaoException("Error reading books from "+booksFile, e);
        } catch(ClassNotFoundException e){
            throw new DaoException("Class not found", e);
        }
        return result;
    }

    private void saveAllBooks(List<Book> books) throws DaoException{
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(booksFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(books);
        } catch(IOException e) {
            throw new DaoException("Error saving books to "+booksFile, e);
        }
    }

}
