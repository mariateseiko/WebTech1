package by.bsuir.lab1.controller.command;

import by.bsuir.lab1.bean.Request;
import by.bsuir.lab1.bean.Response;

/**
 * Represents a command that executes a {@link by.bsuir.lab1.bean.Request} and returns a
 * {@link by.bsuir.lab1.bean.Response}
 */
public interface Command {
        /**
         * Executes a request and generates a response
         * @param request request with specified parameters to be executed
         * @return {@link by.bsuir.lab1.bean.Response} to the request
         * @throws CommandException
         */
        Response execute(Request request) throws CommandException;
}

