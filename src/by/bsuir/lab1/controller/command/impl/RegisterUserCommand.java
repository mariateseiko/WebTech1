package by.bsuir.lab1.controller.command.impl;

import by.bsuir.lab1.bean.RegistrationRequest;
import by.bsuir.lab1.bean.RegistrationResponse;
import by.bsuir.lab1.bean.Request;
import by.bsuir.lab1.bean.Response;
import by.bsuir.lab1.controller.command.Command;
import by.bsuir.lab1.controller.command.CommandException;
import by.bsuir.lab1.entity.UserRole;
import by.bsuir.lab1.service.ServiceException;
import by.bsuir.lab1.service.UserRegistrationService;

/**
 * Command for handling a {@link by.bsuir.lab1.bean.RegistrationRequest}
 */
public class RegisterUserCommand implements Command {
    @Override
    public Response execute(Request request) throws CommandException {
        if (!validationParameters(request)) {
            throw new CommandException("Validation Exception.");
        }

        RegistrationRequest registrationRequest = (RegistrationRequest) request;
        boolean result;
        try {
            result = UserRegistrationService.registerUserService(registrationRequest.getUserInfo());
        } catch (ServiceException ex) {
            throw new CommandException("User registration failed", ex);
        }

        RegistrationResponse  response = new RegistrationResponse();
        if (result) {
            response.setResultMessage("New user registered successfully");
        } else {
            response.setErrorMessage("Couldn't register user");
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
