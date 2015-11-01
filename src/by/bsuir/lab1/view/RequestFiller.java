package by.bsuir.lab1.view;

import by.bsuir.lab1.bean.*;
import by.bsuir.lab1.controller.command.CommandName;

/**
 * Fills all types of requests with corresponding parameters
 */
public class RequestFiller {
    /**
     * Verifies parameters of the request and in case of successful verification creates a new Request for the given
     * command name and fills it with corresponding parameters.
     * @param commandName name of the command to create response for
     * @param commandParams parameters to fill in the request
     * @return formed Request
     * @throws ViewException Thrown if command name is invalid
     */
    public static Request fillRequest(String commandName, String[] commandParams) throws ViewException {
        switch (CommandName.valueOf(commandName)) {
            case REGISTER:
                ParametersVerifier.verifyRegistrationParameters(commandParams);
                RegistrationRequest registrationRequest = new RegistrationRequest();
                registrationRequest.setCommandName(commandName);
                registrationRequest.setUserLogin(commandParams[0]);
                registrationRequest.setUserEmail(commandParams[1]);
                registrationRequest.setUserPassword(commandParams[2]);
                return registrationRequest;
            case LOGIN:
                ParametersVerifier.verifyLoginParameters(commandParams);
                LoginRequest loginRequest = new LoginRequest();
                loginRequest.setCommandName(commandName);
                loginRequest.setUserLogin(commandParams[0]);
                loginRequest.setUserPassword(commandParams[1]);
                return loginRequest;
            case LOGOUT:
                Request logoutRequest = new Request();
                logoutRequest.setCommandName(commandName);
                return logoutRequest;
            case ADD_NEW_BOOK:
                ParametersVerifier.verifyAddNewBookParameters(commandParams);
                NewBookRequest newBookRequest = new NewBookRequest();
                newBookRequest.setCommandName(commandName);
                newBookRequest.setBookTitle(commandParams[0]);
                newBookRequest.setBookAuthor(commandParams[1]);
                newBookRequest.setBookType(Boolean.parseBoolean(commandParams[2]));
                return newBookRequest;
            case LIST_ALL_BOOKS:
                Request listAllBooksRequest = new Request();
                listAllBooksRequest.setCommandName(commandName);
                return listAllBooksRequest;
            case FIND_BOOKS_TITLE:
                ParametersVerifier.verifyFindParameters(commandParams, 1);
                FindBooksRequest findBooksByTitleRequest = new FindBooksRequest();
                findBooksByTitleRequest.setCommandName(commandName);
                findBooksByTitleRequest.setTitle(commandParams[0]);
                return findBooksByTitleRequest;
            case FIND_BOOKS_AUTHOR:
                ParametersVerifier.verifyFindParameters(commandParams, 1);
                FindBooksRequest findBooksByAuthorRequest = new FindBooksRequest();
                findBooksByAuthorRequest.setCommandName(commandName);
                findBooksByAuthorRequest.setAuthor(commandParams[0]);
                return findBooksByAuthorRequest;
            case FIND_BOOKS_TITLE_AUTHOR:
                ParametersVerifier.verifyFindParameters(commandParams, 2);
                FindBooksRequest findBooksRequest = new FindBooksRequest();
                findBooksRequest.setCommandName(commandName);
                findBooksRequest.setTitle(commandParams[0]);
                findBooksRequest.setAuthor(commandParams[1]);
                return findBooksRequest;
            case EDIT_BOOK_AUTHOR:
                ParametersVerifier.verifyEditStringParameters(commandParams);
                EditBookRequest editAuthorRequest = new EditBookRequest();
                editAuthorRequest.setCommandName(commandName);
                editAuthorRequest.setID(Integer.parseInt(commandParams[0]));
                editAuthorRequest.setNewAuthor(commandParams[1]);
                return editAuthorRequest;
            case EDIT_BOOK_TITLE:
                ParametersVerifier.verifyEditStringParameters(commandParams);
                EditBookRequest editTitleRequest = new EditBookRequest();
                editTitleRequest.setCommandName(commandName);
                editTitleRequest.setID(Integer.parseInt(commandParams[0]));
                editTitleRequest.setNewTitle(commandParams[1]);
                return editTitleRequest;
            case EDIT_BOOK_TYPE:
                ParametersVerifier.verifyBookID(commandParams[0]);
                EditBookRequest editTypeRequest = new EditBookRequest();
                editTypeRequest.setCommandName(commandName);
                editTypeRequest.setID(Integer.parseInt(commandParams[0]));
                return editTypeRequest;
            case DELETE_BOOK:
                ParametersVerifier.verifyBookID(commandParams[0]);
                DeleteBookRequest deleteBookRequest = new DeleteBookRequest();
                deleteBookRequest.setCommandName(commandName);
                deleteBookRequest.setID(Integer.parseInt(commandParams[0]));
                return deleteBookRequest;
            default:
                throw new ViewException("Invalid command");
        }
    }
}
