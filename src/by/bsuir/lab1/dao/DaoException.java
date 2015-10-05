package by.bsuir.lab1.dao;

/**
 * Created by Maria Teseiko on 10.09.2015.
 */
public class DaoException extends Exception {

    public DaoException(String message) { super(message); }

    public DaoException(String message, Exception ex) { super(message, ex); }
}
