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
 * Command for handling a {@link by.bsuir.lab1.bean.NewBookRequest}
 */
public class AddNewBookCommand implements Command {

    @Override
    public Response execute(Request request) throws CommandException {
        if (!validationParameters(request)) {
            throw new CommandException("Validation Exception.");
        }
        NewBookRequest newBookRequest = (NewBookRequest) request;
        boolean result;
        try {
            result = RepositoryModificationService
                    .addNewBookService(newBookRequest.getBook());
        } catch (ServiceException ex) {
            throw new CommandException("Failed to add book to the repository", ex);
        }

        NewBookResponse response = new NewBookResponse();
        if (result) {
            response.setResultMessage("Book was successfully added to the repository");
        } else {
            response.setErrorMessage("Failed to add book to the repository");
        }
        return response;
    }

    /**
     * Validates parameters of the {@link by.bsuir.lab1.bean.NewBookRequest}
     * @param request request to be validates
     * @return true if request's user is admin
     */
    private boolean validationParameters(Request request) {
        return (request.getRole() == UserRole.ADMIN);
    }
}
