package by.bsuir.lab1.view;

/**
 * Created by Maria Teseiko on 07.10.2015.
 */
public class ViewException extends Exception {
    public ViewException(String message) { super(message); }

    public ViewException(String message, Exception ex) { super(message, ex); }
}
