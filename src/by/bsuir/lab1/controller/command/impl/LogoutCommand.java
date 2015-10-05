package by.bsuir.lab1.controller.command.impl;

import by.bsuir.lab1.bean.*;
import by.bsuir.lab1.controller.command.Command;
import by.bsuir.lab1.controller.command.CommandException;
import by.bsuir.lab1.entity.UserRole;

/**
 * Created by Maria Teseiko on 05.10.2015.
 */
public class LogoutCommand implements Command {
    @Override
    public Response execute(Request request) throws CommandException {
        if (!validationParameters(request)) {
            throw new CommandException("Validation Exception.");
        }


        LogoutResponse response = new LogoutResponse();
        response.setResultMessage("Successfully logged out");
        response.setGuestUser();
        return response;
    }

    private boolean validationParameters(Request request) {
        if (request.getRole() != UserRole.GUEST)
            return true;
        return false;
    }

}
