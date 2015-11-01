package by.bsuir.lab1.view;

/**
 * Exception Thrown if any exception on current or any underlying level is thrown
 */
public class ViewException extends Exception {
    public ViewException(String message) { super(message); }

    public ViewException(String message, Exception ex) { super(message, ex); }
}
