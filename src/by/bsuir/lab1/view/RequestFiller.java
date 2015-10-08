package by.bsuir.lab1.view;

import by.bsuir.lab1.bean.*;

/**
 * Created by Maria Teseiko on 07.10.2015.
 */
public class RequestFiller {
    public static Request fillRequest(String[] commandParams) throws ViewException {
        String commandName = commandParams[0];
        switch (commandName) {
            case "REGISTER":
                ParametersVerifier.verifyRegistrationParameters(commandParams);
                RegistrationRequest registrationRequest = new RegistrationRequest();
                registrationRequest.setCommandName(commandParams[0]);
                registrationRequest.setUserLogin(commandParams[1]);
                registrationRequest.setUserEmail(commandParams[2]);
                registrationRequest.setUserPassword(commandParams[3]);
                return registrationRequest;
            case "LOGIN":
                ParametersVerifier.verifyLoginParameters(commandParams);
                LoginRequest loginRequest = new LoginRequest();
                loginRequest.setCommandName(commandParams[0]);
                loginRequest.setUserLogin(commandParams[1]);
                loginRequest.setUserPassword(commandParams[2]);
                return loginRequest;
            case "LOGOUT":
                LogoutRequest logoutRequest = new LogoutRequest();
                logoutRequest.setCommandName("LOGOUT");
                return logoutRequest;
            case "ADD_NEW_BOOK":
                ParametersVerifier.verifyAddNewBookParameters(commandParams);
                NewBookRequest newBookRequest = new NewBookRequest();
                newBookRequest.setCommandName(commandParams[0]);
                newBookRequest.setBookTitle(commandParams[1]);
                newBookRequest.setBookAuthor(commandParams[2]);
                newBookRequest.setBookType(Boolean.parseBoolean(commandParams[3]));
                return newBookRequest;
            case "LIST_ALL_BOOKS":
                ListAllBooksRequest listAllBooksRequest = new ListAllBooksRequest();
                listAllBooksRequest.setCommandName(commandParams[0]);
                return listAllBooksRequest;
            case "FIND_BOOKS_BY_TITLE":

            default:
                throw new ViewException("Invalid command");

        }
    }
}
