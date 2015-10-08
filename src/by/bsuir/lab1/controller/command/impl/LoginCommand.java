package by.bsuir.lab1.controller.command.impl;

import by.bsuir.lab1.bean.LoginRequest;
import by.bsuir.lab1.bean.LoginResponse;
import by.bsuir.lab1.bean.Request;
import by.bsuir.lab1.bean.Response;
import by.bsuir.lab1.controller.command.Command;
import by.bsuir.lab1.controller.command.CommandException;
import by.bsuir.lab1.entity.UserRole;
import by.bsuir.lab1.service.ServiceException;
import by.bsuir.lab1.service.UserAuthorizationService;

/**
 * Created by Maria Teseiko on 05.10.2015.
 */
public class LoginCommand implements Command {
    @Override
    public Response execute(Request request) throws CommandException {
        // validation
        if (!validationParameters(request)) {
            throw new CommandException("Validation Exception.");
        }

        // call service
        LoginRequest loginRequest = (LoginRequest) request;
        UserRole result;
        try {
            result = UserAuthorizationService
                    .loginUserService(loginRequest.getUser());
        } catch (ServiceException ex) {
            throw new CommandException("Command message about exception", ex);
        }

        // create response
        LoginResponse response = new LoginResponse();
        if (result == UserRole.ADMIN) {
            response.setResultMessage("Successfully logged in as admin");
            response.setRole(UserRole.ADMIN);
        } else if (result == UserRole.USER) {
            response.setResultMessage("Successfully logged in");
            response.setRole(UserRole.USER);
        } else {
            response.setErrorMessage("Authorization failed");
        }
        return response;
    }

    private boolean validationParameters(Request request) {
        if (request.getRole() == UserRole.GUEST)
            return true;
        return false;
    }
}
