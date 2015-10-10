package by.bsuir.lab1.dao;

import by.bsuir.lab1.entity.Book;
/**
 * Created by Maria Teseiko on 10.09.2015.
 */
public interface ModificationDao {
    boolean addNewBook(Book book) throws DaoException;
    boolean editBookType(int id) throws DaoException;
    boolean editBookTitle(int id, String newTitle) throws DaoException;
    boolean editBookAuthor(int id, String newAuthor) throws DaoException;
    boolean deleteBook(int id) throws DaoException;
}
