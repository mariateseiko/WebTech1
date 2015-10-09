package by.bsuir.lab1.view;

import by.bsuir.lab1.bean.*;
import by.bsuir.lab1.controller.command.CommandName;

/**
 * Created by Maria Teseiko on 07.10.2015.
 */
public class RequestFiller {
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
                LogoutRequest logoutRequest = new LogoutRequest();
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
                ListAllBooksRequest listAllBooksRequest = new ListAllBooksRequest();
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
            default:
                throw new ViewException("Invalid command");

        }
    }
}
