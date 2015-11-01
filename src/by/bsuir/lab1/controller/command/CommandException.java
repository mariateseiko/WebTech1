package by.bsuir.lab1.controller.command;

/**
 * Exception Thrown if any exception on current or any underlying level is thrown
 */
public class CommandException extends Exception {
    public CommandException(String message){
        super(message);
    }

    public CommandException(String message, Exception ex){
        super(message, ex);
    }
}
