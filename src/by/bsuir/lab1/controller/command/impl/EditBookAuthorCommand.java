package by.bsuir.lab1.controller.command.impl;

import by.bsuir.lab1.bean.EditBookRequest;
import by.bsuir.lab1.bean.FindBooksResponse;
import by.bsuir.lab1.bean.Request;
import by.bsuir.lab1.bean.Response;
import by.bsuir.lab1.controller.command.Command;
import by.bsuir.lab1.controller.command.CommandException;
import by.bsuir.lab1.entity.UserRole;
import by.bsuir.lab1.service.RepositoryModificationService;
import by.bsuir.lab1.service.ServiceException;

/**
 * Created by Maria Teseiko on 10.10.2015.
 */
public class EditBookAuthorCommand implements Command {
    @Override
    public Response execute(Request request) throws CommandException {

        if (!validationParameters(request)) {
            throw new CommandException("Validation Exception.");
        }

        EditBookRequest editRequest = (EditBookRequest) request;
        boolean result;
        try {
            result = RepositoryModificationService
                    .editBookAuthorService(editRequest.getID(), editRequest.getNewAuthor());
        } catch (ServiceException ex) {
            throw new CommandException("Command message about exception", ex);
        }

        // create response
        FindBooksResponse response = new FindBooksResponse();
        if (result) {
            response.setResultMessage("Book's author successfully edited");
        } else {
            response.setErrorMessage("Couldn't delete book");
        }
        return response;
    }

    private boolean validationParameters(Request request) {
        if (request.getRole() == UserRole.ADMIN)
            return true;
        return false;
    }
}
