package by.bsuir.lab1.controller.command.impl;

import by.bsuir.lab1.bean.FindBooksRequest;
import by.bsuir.lab1.bean.FindBooksResponse;
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
public class FindBooksByAuthorCommand implements Command {
    @Override
    public Response execute(Request request) throws CommandException {

        if (!validationParameters(request)) {
            throw new CommandException("Validation Exception.");
        }

        FindBooksRequest findRequest = (FindBooksRequest) request;
        List<Book> result;
        try {
            result = BookFindService
                    .findBookByAuthorService(findRequest.getAuthor());
        } catch (ServiceException ex) {
            throw new CommandException("Command message about exception", ex);
        }

        // create response
        FindBooksResponse response = new FindBooksResponse();
        if (result != null) {
            response.setResultMessage(result.size() + " books found: ");
            response.setBooksList(result);
        } else {
            response.setErrorMessage("No books were found");
        }
        return response;
    }

    private boolean validationParameters(Request request) {
        if (request.getRole() == UserRole.ADMIN || request.getRole() == UserRole.USER)
            return true;
        return false;
    }
}