package by.bsuir.lab1.dao.file;

import by.bsuir.lab1.dao.DaoException;
import by.bsuir.lab1.dao.ModificationDao;
import by.bsuir.lab1.entity.Book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Implementation of {@link by.bsuir.lab1.dao.ModificationDao} for file storage
 */
public class FileModificationDao implements ModificationDao {
    private final static FileModificationDao instance = new FileModificationDao();
    private FileModificationDao(){}
    private FileCommonDao commonDao = FileCommonDao.getInstance();

    /**
     * Singleton pattern implementation
     * @return instance of this data access object
     */
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

    /**
     * Returns first unassigned book ID
     * <p>
     *    Goes over the books list, gets each book ID and defines the smallest ID that doesn't belong to any book.
     * </p>
     * @param books all books in the repository
     * @return smallest ID not assigned to any book
     */
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
            Book bookToEdit = null;
            for(Book book: books) {
                if (book.getID() == id) {
                    bookToEdit = book;
                    break;
                }
            }
            if (bookToEdit != null) {
                Book newBook = books.remove(books.indexOf(bookToEdit));
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
            Book bookToEdit = null;
            for(Book book: books) {
                if (book.getID() == id) {
                    bookToEdit = book;
                    break;
                }
            }
            if (bookToEdit != null) {
                Book newBook = books.remove(books.indexOf(bookToEdit));
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
            Book bookToEdit = null;
            for(Book book: books) {
                if (book.getID() == id) {
                    bookToEdit = book;
                    break;
                }
            }
            if (bookToEdit != null) {
                Book newBook = books.remove(books.indexOf(bookToEdit));
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
