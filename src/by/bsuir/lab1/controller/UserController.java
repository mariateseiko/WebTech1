package by.bsuir.lab1.controller;

import by.bsuir.lab1.controller.command.CommandName;
import by.bsuir.lab1.entity.UserRole;

/**
 * Controls {@link by.bsuir.lab1.entity.User}'s access rights and provides him with a corresponding set of Commands names
 */
public class UserController {
    private UserRole role;
    private static final CommandName[] userCommands = {CommandName.LIST_ALL_BOOKS, CommandName.FIND_BOOKS_TITLE, CommandName.FIND_BOOKS_AUTHOR,
            CommandName.FIND_BOOKS_TITLE_AUTHOR, CommandName.LOGOUT, CommandName.EXIT};

    private static final CommandName[] adminCommands = {CommandName.LIST_ALL_BOOKS, CommandName.ADD_NEW_BOOK, CommandName.EDIT_BOOK_AUTHOR,
            CommandName.EDIT_BOOK_TITLE, CommandName.EDIT_BOOK_TYPE, CommandName.DELETE_BOOK,
            CommandName.FIND_BOOKS_TITLE, CommandName.FIND_BOOKS_AUTHOR, CommandName.FIND_BOOKS_TITLE_AUTHOR,
            CommandName.LOGOUT, CommandName.EXIT};

    private static final CommandName[] guestCommands = {CommandName.LOGIN, CommandName.REGISTER, CommandName.EXIT};

    public CommandName[] getCommandsList() {
        switch(role) {
            case GUEST: return guestCommands;
            case USER: return userCommands;
            case ADMIN: return adminCommands;
            default: return null;
        }
    }

    public UserController(){
        setRoleGuest();
    }

    public void setRoleGuest(){
        role = UserRole.GUEST;
    }

    public void setRole(UserRole role) { this.role = role; }

    public UserRole getRole(){
        return role;
    }


}
