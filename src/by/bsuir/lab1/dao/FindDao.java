package by.bsuir.lab1.dao;

import java.util.List;

import by.bsuir.lab1.entity.Book;

/**
 * Created by Maria Teseiko on 10.09.2015.
 */
public interface FindDao {
    List<Book> findBookByTitle(String title) throws DaoException;
    List<Book> findBookByAuthor(String author) throws DaoException;
    Book findBookByTitleAndAuthor(String title, String author) throws DaoException;
    List<Book> findAllBooks() throws DaoException;
}
