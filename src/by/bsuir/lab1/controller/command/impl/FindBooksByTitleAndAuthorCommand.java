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
 * Command for handling a {@link by.bsuir.lab1.bean.FindBooksRequest} to find by author and title
 */
public class FindBooksByTitleAndAuthorCommand implements Command {
    @Override
    public Response execute(Request request) throws CommandException {

        if (!validationParameters(request)) {
            throw new CommandException("Validation Exception.");
        }

        FindBooksRequest findRequest = (FindBooksRequest) request;
        List<Book> result;
        try {
            result = BookFindService
                    .findBooksByTitleAndAuthorService(findRequest.getTitle(), findRequest.getAuthor());
        } catch (ServiceException ex) {
            throw new CommandException("Book search failed", ex);
        }

        FindBooksResponse response = new FindBooksResponse();
        if (result != null) {
            response.setBooksList(result);
        } else {
            response.setErrorMessage("No books were found");
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
