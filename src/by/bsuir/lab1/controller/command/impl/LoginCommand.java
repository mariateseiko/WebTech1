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
 * Command for handling a {@link by.bsuir.lab1.bean.LoginRequest}
 */
public class LoginCommand implements Command {
    @Override
    public Response execute(Request request) throws CommandException {
        if (!validationParameters(request)) {
            throw new CommandException("Validation Exception.");
        }

        LoginRequest loginRequest = (LoginRequest) request;
        UserRole result;
        try {
            result = UserAuthorizationService
                    .loginUserService(loginRequest.getUser());
        } catch (ServiceException ex) {
            throw new CommandException("Failed to perform authorization", ex);
        }

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

    /**
     * Validates parameters of the {@link by.bsuir.lab1.bean.EditBookRequest}
     * @param request request to be validates
     * @return true if request's user is a guest
     */
    private boolean validationParameters(Request request) {
        return (request.getRole() == UserRole.GUEST);
    }
}
