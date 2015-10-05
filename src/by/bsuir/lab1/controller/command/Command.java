package by.bsuir.lab1.controller.command;

import by.bsuir.lab1.bean.Request;
import by.bsuir.lab1.bean.Response;


/**
 * Created by Maria Teseiko on 03.10.2015.
 */
public interface Command {
        Response execute(Request request) throws CommandException;
}

