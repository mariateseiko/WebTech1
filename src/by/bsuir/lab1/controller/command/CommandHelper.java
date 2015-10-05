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
       // commands.put(CommandName.LOGIN, new LoginCommand());
    }

    public Command getCommand(String commandName){
        CommandName command = CommandName.valueOf(commandName);
        return commands.get(command);
    }
}
