package by.bsuir.lab1.dao;

/**
 * A wrapping exception for any exception thrown at DAO level
 */
public class DaoException extends Exception {

    public DaoException(String message) { super(message); }

    public DaoException(String message, Exception ex) { super(message, ex); }
}
