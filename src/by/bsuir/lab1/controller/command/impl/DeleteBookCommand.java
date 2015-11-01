package by.bsuir.lab1.controller.command.impl;

import by.bsuir.lab1.bean.DeleteBookRequest;
import by.bsuir.lab1.bean.DeleteBookResponse;
import by.bsuir.lab1.bean.Request;
import by.bsuir.lab1.bean.Response;
import by.bsuir.lab1.controller.command.Command;
import by.bsuir.lab1.controller.command.CommandException;
import by.bsuir.lab1.entity.UserRole;
import by.bsuir.lab1.service.RepositoryModificationService;
import by.bsuir.lab1.service.ServiceException;

/**
 * Command for handling a {@link by.bsuir.lab1.bean.DeleteBookRequest}
 */
public class DeleteBookCommand implements Command {
    @Override
    public Response execute(Request request) throws CommandException {

        if (!validationParameters(request)) {
            throw new CommandException("Validation Exception.");
        }

        DeleteBookRequest deleteRequest = (DeleteBookRequest) request;
        boolean result;
        try {
            result = RepositoryModificationService
                    .deleteBookService(deleteRequest.getID());
        } catch (ServiceException ex) {
            throw new CommandException("Failed to delete book", ex);
        }

        DeleteBookResponse response = new DeleteBookResponse();
        if (result) {
            response.setResultMessage("Book successfully deleted");
        } else {
            response.setErrorMessage("Couldn't delete book");
        }
        return response;
    }

    /**
     * Validates parameters of the {@link by.bsuir.lab1.bean.DeleteBookRequest}
     * @param request request to be validates
     * @return true if request's user is admin
     */
    private boolean validationParameters(Request request) {
        return request.getRole() == UserRole.ADMIN;
    }
}
