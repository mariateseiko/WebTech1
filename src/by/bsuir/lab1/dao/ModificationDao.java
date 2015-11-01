package by.bsuir.lab1.dao;

import by.bsuir.lab1.entity.Book;

/**
 * The Modification Data Access Object is the interface handling changing interactions with book repository.
 *
 * @see by.bsuir.lab1.entity.Book
 */
public interface ModificationDao {
    /**
     * Adds a given book to the repository
     *
     * @param book book to add to the repository
     * @return returns true if book was successfully added to the repository
     * @throws DaoException  Thrown if any issue occurs while working with database/file
     */
    boolean addNewBook(Book book) throws DaoException;

    /**
     * Changes type of the book with a given ID
     *
     * @param id book's unique ID
     * @return returns true if book's type was successfully modified
     * @throws DaoException Thrown if any issue occurs while working with database/file
     */
    boolean editBookType(int id) throws DaoException;

    /**
     * Changes title of the book with a given ID to the specified new title
     *
     * @param id book's unique ID
     * @param newTitle new title of the book
     * @return returns true if book's title was successfully modified
     * @throws DaoException Thrown if any issue occurs while working with database/file
     */
    boolean editBookTitle(int id, String newTitle) throws DaoException;

    /**
     * Changes author of the book with a given ID to the specified new author
     *
     * @param id book's unique ID
     * @param newAuthor new author of the book
     * @return returns true if book's author was successfully modified
     * @throws DaoException Thrown if any issue occurs while working with database/file
     */
    boolean editBookAuthor(int id, String newAuthor) throws DaoException;

    /**
     * Deletes a book with a given ID from the repository
     * @param id book's unique ID
     * @return returns true if book was successfully deleted
     * @throws DaoException Thrown if any issue occurs while working with database/file
     */
    boolean deleteBook(int id) throws DaoException;
}
