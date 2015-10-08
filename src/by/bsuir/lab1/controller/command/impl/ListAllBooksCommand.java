package by.bsuir.lab1.controller.command.impl;

import by.bsuir.lab1.bean.ListAllBooksRequest;
import by.bsuir.lab1.bean.ListAllBooksResponse;
import by.bsuir.lab1.bean.Request;
import by.bsuir.lab1.bean.Response;
import by.bsuir.lab1.controller.command.Command;
import by.bsuir.lab1.controller.command.CommandException;
import by.bsuir.lab1.entity.Book;
import by.bsuir.lab1.entity.UserRole;
import by.bsuir.lab1.service.BookFindService;
import by.bsuir.lab1.service.ServiceException;

import java.util.List;

/**
 * Created by Maria Teseiko on 08.10.2015.
 */
public class ListAllBooksCommand implements Command {
    @Override
    public Response execute(Request request) throws CommandException {
        // validation
        if (!validationParameters(request)) {
            throw new CommandException("Validation Exception.");
        }

        // call service
        ListAllBooksRequest newBookRequest = (ListAllBooksRequest) request;
        List<Book> result;
        try {
            result = BookFindService.
                    listAllBooksService();
        } catch (ServiceException ex) {
            throw new CommandException("Command message about exception", ex);
        }

        // create response
        ListAllBooksResponse response = new ListAllBooksResponse();
        if (result != null) {
            response.setResultMessage("Books in repository: ");
            response.setBooksList(result);
        } else {
            response.setErrorMessage("Fail");
        }
        return response;
    }

    private boolean validationParameters(Request request) {
        if (request.getRole() == UserRole.ADMIN || request.getRole() == UserRole.USER)
            return true;
        return false;
    }
}
