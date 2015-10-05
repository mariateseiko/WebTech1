package by.bsuir.lab1.controller;

import by.bsuir.lab1.bean.Request;
import by.bsuir.lab1.bean.Response;
import by.bsuir.lab1.controller.command.Command;
import by.bsuir.lab1.controller.command.CommandException;
import by.bsuir.lab1.controller.command.CommandHelper;

/**
 * Created by Maria Teseiko on 03.10.2015.
 */
public class BookController {
    private CommandHelper commandList = new CommandHelper();


    public Response executeRequest(Request request){
        Response response = null;
        try{
            String commandName = request.getCommandName();
            Command command = commandList.getCommand(commandName);
            response = command.execute(request);
        }catch(CommandException ex){
            response = new Response();
            response.setErrorMessage(ex.getMessage());
        }
        return response;
    }
}
