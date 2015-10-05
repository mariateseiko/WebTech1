package by.bsuir.lab1.controller.command;

/**
 * Created by Maria Teseiko on 03.10.2015.
 */
public class CommandException extends Exception {
    private static final long serialVersionUID = 1L;

    public CommandException(String message){
        super(message);
    }

    public CommandException(String message, Exception ex){
        super(message, ex);
    }
}
