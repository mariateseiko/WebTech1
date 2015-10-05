package by.bsuir.lab1.service;

/**
 * Created by Maria Teseiko on 03.10.2015.
 */
public class ServiceException extends Exception {
    private static final long serialVersionUID = 1L;

    public ServiceException(String message){
        super(message);
    }

    public ServiceException(String message, Exception ex){
        super(message, ex);
    }
}
