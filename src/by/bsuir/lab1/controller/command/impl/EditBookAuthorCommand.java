package by.bsuir.lab1.controller.command.impl;

import by.bsuir.lab1.bean.EditBookRequest;
import by.bsuir.lab1.bean.EditBookResponse;
import by.bsuir.lab1.bean.Request;
import by.bsuir.lab1.bean.Response;
import by.bsuir.lab1.controller.command.Command;
import by.bsuir.lab1.controller.command.CommandException;
import by.bsuir.lab1.entity.UserRole;
import by.bsuir.lab1.service.RepositoryModificationService;
import by.bsuir.lab1.service.ServiceException;

/**
 * Command for handling a {@link by.bsuir.lab1.bean.EditBookRequest} to edit author
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
            throw new CommandException("Couldn't edit book's author", ex);
        }

        EditBookResponse response = new EditBookResponse();
        if (result) {
            response.setResultMessage("Book's author successfully edited");
        } else {
            response.setErrorMessage("Couldn't edit book's author");
        }
        return response;
    }

    /**
     * Validates parameters of the {@link by.bsuir.lab1.bean.EditBookRequest}
     * @param request request to be validates
     * @return true if request's user is admin
     */
    private boolean validationParameters(Request request) {
        return (request.getRole() == UserRole.ADMIN);
    }
}
