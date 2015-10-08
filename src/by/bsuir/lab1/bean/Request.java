package by.bsuir.lab1.bean;

import by.bsuir.lab1.entity.UserRole;

/**
 * Created by Maria Teseiko on 03.10.2015.
 */
public class Request {
    private String commandName;
    private UserRole userRole;

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public UserRole getRole() { return userRole; }

    public void setRole(UserRole role) { userRole = role; }
}
