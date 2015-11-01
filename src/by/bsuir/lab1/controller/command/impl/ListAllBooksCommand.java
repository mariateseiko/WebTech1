package by.bsuir.lab1.controller.command.impl;

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
 * Command for handling a {@link by.bsuir.lab1.bean.FindBooksRequest} to get all books
 */
public class ListAllBooksCommand implements Command {
    @Override
    public Response execute(Request request) throws CommandException {
        if (!validationParameters(request)) {
            throw new CommandException("Validation Exception.");
        }

        List<Book> result;
        try {
            result = BookFindService.
                    listAllBooksService();
        } catch (ServiceException ex) {
            throw new CommandException("Failed to get list of books", ex);
        }

        FindBooksResponse response = new FindBooksResponse();
        if (result != null) {
            response.setBooksList(result);
        } else {
            response.setErrorMessage("No book in the repository");
        }
        return response;
    }

    /**
     * Validates parameters of the {@link by.bsuir.lab1.bean.EditBookRequest}
     * @param request request to be validates
     * @return true if request's user is admin or a registered user
     */
    private boolean validationParameters(Request request) {
        return (request.getRole() == UserRole.ADMIN || request.getRole() == UserRole.USER);
    }
}
