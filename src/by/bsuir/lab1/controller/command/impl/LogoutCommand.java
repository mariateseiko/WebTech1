package by.bsuir.lab1.controller.command.impl;

import by.bsuir.lab1.bean.LogoutResponse;
import by.bsuir.lab1.bean.Request;
import by.bsuir.lab1.bean.Response;
import by.bsuir.lab1.controller.command.Command;
import by.bsuir.lab1.controller.command.CommandException;
import by.bsuir.lab1.entity.UserRole;

/**
 * Command for handling logout request
 */
public class LogoutCommand implements Command {
    @Override
    public Response execute(Request request) throws CommandException {
        if (!validationParameters(request)) {
            throw new CommandException("Validation Exception.");
        }

        LogoutResponse response = new LogoutResponse();
        response.setResultMessage("Successfully logged out");
        response.setUser();
        return response;
    }

    /**
     * Validates parameters of the {@link by.bsuir.lab1.bean.EditBookRequest}
     * @param request request to be validates
     * @return true if request's user is not a guest
     */
    private boolean validationParameters(Request request) {
        return request.getRole() != UserRole.GUEST;
    }

}
