package by.bsuir.lab1.service;

/**
 * Exception Thrown if any exception on service or  any underlying level is thrown
 */
public class ServiceException extends Exception {
    public ServiceException(String message){
        super(message);
    }

    public ServiceException(String message, Exception ex){
        super(message, ex);
    }
}
