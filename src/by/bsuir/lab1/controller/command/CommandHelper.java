package by.bsuir.lab1.controller.command;

import by.bsuir.lab1.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Maria Teseiko on 03.10.2015.
 */
public class CommandHelper {
    private Map<CommandName, Command> commands = new HashMap<CommandName, Command>();

    public CommandHelper(){
        commands.put(CommandName.ADD_NEW_BOOK, new AddNewBookCommand());
        commands.put(CommandName.LOGIN, new LoginCommand());
        commands.put(CommandName.REGISTER, new RegisterUserCommand());
        commands.put(CommandName.LOGOUT, new LogoutCommand());
        commands.put(CommandName.LIST_ALL_BOOKS, new ListAllBooksCommand());
        commands.put(CommandName.FIND_BOOKS_TITLE, new FindBookByTitleCommand());
        commands.put(CommandName.FIND_BOOKS_AUTHOR, new FindBookByTitleCommand());
        commands.put(CommandName.FIND_BOOKS_TITLE_AUTHOR, new FindBookByTitleCommand());
        commands.put(CommandName.EDIT_BOOK_AUTHOR, new EditBookAuthorCommand());
        commands.put(CommandName.EDIT_BOOK_TITLE, new EditBookTitleCommand());
        commands.put(CommandName.EDIT_BOOK_TYPE, new EditBookTypeCommand());
        commands.put(CommandName.DELETE_BOOK, new DeleteBookCommand());
    }

    public Command getCommand(String commandName){
        CommandName command = CommandName.valueOf(commandName);
        return commands.get(command);
    }
}
