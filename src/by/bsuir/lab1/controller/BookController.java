package by.bsuir.lab1.controller;

import by.bsuir.lab1.bean.Request;
import by.bsuir.lab1.bean.Response;
import by.bsuir.lab1.controller.command.Command;
import by.bsuir.lab1.controller.command.CommandException;
import by.bsuir.lab1.controller.command.CommandHelper;

/**
 * Controller for handling {@link by.bsuir.lab1.entity.Book} user's {@link by.bsuir.lab1.bean.Request}
 */
public class BookController {
    private CommandHelper commandList = new CommandHelper();

    /**
     * Executes a {@link by.bsuir.lab1.bean.Request} and either returns it's {@link by.bsuir.lab1.bean.Response} or in
     * case of Exception on an underlying layer generates its own Response and returns it
     * @param request request to execute
     * @return response to the request
     */
    public Response executeRequest(Request request){
        Response response;
        try {
            String commandName = request.getCommandName();
            Command command = commandList.getCommand(commandName);
            response = command.execute(request);
        } catch(CommandException ex) {
            response = new Response();
            response.setErrorMessage(ex.getMessage());
        }
        return response;
    }
}
