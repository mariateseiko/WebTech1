package by.bsuir.lab1.bean;

import by.bsuir.lab1.entity.UserRole;

/**
 * A request for command from a {@link by.bsuir.lab1.entity.User} with a specified {@link by.bsuir.lab1.entity.UserRole}
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
