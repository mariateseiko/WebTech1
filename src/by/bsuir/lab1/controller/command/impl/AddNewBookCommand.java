package by.bsuir.lab1.controller.command.impl;

import by.bsuir.lab1.bean.NewBookRequest;
import by.bsuir.lab1.bean.NewBookResponse;
import by.bsuir.lab1.bean.Request;
import by.bsuir.lab1.bean.Response;
import by.bsuir.lab1.controller.command.Command;
import by.bsuir.lab1.controller.command.CommandException;
import by.bsuir.lab1.entity.UserRole;
import by.bsuir.lab1.service.RepositoryModificationService;
import by.bsuir.lab1.service.ServiceException;




/**
 * Created by Maria Teseiko on 03.10.2015.
 */
public class AddNewBookCommand implements Command {
    @Override
    public Response execute(Request request) throws CommandException {
        // validation
        if (!validationParameters(request)) {
            throw new CommandException("Validation Exception.");
        }

        // call service
        NewBookRequest newBookRequest = (NewBookRequest) request;
        boolean result = false;
        try {
            result = RepositoryModificationService
                    .addNewBookService(newBookRequest.getBook());
        } catch (ServiceException ex) {
            throw new CommandException("Command message about exception", ex);
        }

        // create response
        NewBookResponse response = new NewBookResponse();
        if (result) {
            response.setResultMessage("Book was successfully added to the repository");
        } else {
            response.setErrorMessage("Failed to add new book");
        }
        return response;
    }

    private boolean validationParameters(Request request) {
        if (request.getRole() == UserRole.ADMIN)
            return true;
        return false;
    }
}
