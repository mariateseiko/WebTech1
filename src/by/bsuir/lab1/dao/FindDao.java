package by.bsuir.lab1.dao;

import by.bsuir.lab1.entity.Book;

import java.util.List;

/**
 * The Find Data Access Object is the interface providing access to extract a book or a list of books by given parameters.
 *
 * @see by.bsuir.lab1.entity.Book
 */
public interface FindDao {
    /**
     * Searches repository for books with a given title
     *
     * @param title title of the books to be found
     * @return list of books matching the search parameters
     * @throws DaoException Thrown if any issue occurs while working with database/file
     */
    List<Book> findBookByTitle(String title) throws DaoException;

    /**
     * Searches repository for books with a given author
     *
     * @param author author of the books to be found
     * @return list of books matching the search parameters
     * @throws DaoException Thrown if any issue occurs while working with database/file
     */
    List<Book> findBookByAuthor(String author) throws DaoException;

    /**
     * Searches repository for books with a given author and title
     *
     * @param title title of the books to be found
     * @param author author of the books to be found
     * @return list of books matching the search parameters
     * @throws DaoException Thrown if any issue occurs while working with database/file
     */
    List<Book> findBookByTitleAndAuthor(String title, String author) throws DaoException;

    /**
     * Returns all books from the repository
     * @return list with all books from the repository
     * @throws DaoException Thrown if any issue occurs while working with database/file
     */
    List<Book> findAllBooks() throws DaoException;
}
