package by.bsuir.lab1.view;

import by.bsuir.lab1.bean.LoginResponse;
import by.bsuir.lab1.bean.Request;
import by.bsuir.lab1.bean.Response;
import by.bsuir.lab1.controller.BookController;
import by.bsuir.lab1.controller.UserController;
import by.bsuir.lab1.controller.command.CommandName;

import java.util.Scanner;

public class View {
    private BookController bookController = new BookController();
    private UserController userController = new UserController();
    private Scanner input = new Scanner(System.in);

    public void run(){
        switch(userController.getRole()){
            case GUEST: showGuestMenu(); break;
            case USER: showUserMenu(); break;
            case ADMIN: showAdminMenu(); break;
        }
        System.out.print(">");
        String command = input.nextLine();
        MenuHandler(command);
    }

    private void showGuestMenu(){
        System.out.println("\nGuest menu:");
        System.out.println("LOGIN [login] [password]");
        System.out.println("REGISTER [login] [email] [password]");
        System.out.println("EXIT");
    }

    private void showUserMenu() {
        System.out.println("\nUser menu:");
        System.out.println("LIST_ALL_BOOKS");
        System.out.println("FIND_BOOK_TITLE [title]");
        System.out.println("FIND_BOOK_AUTHOR [author]");
        System.out.println("FIND_BOOK_TITLE_AUTHOR [title] [author]");
        System.out.println("LOGOUT");
    }

    private void showAdminMenu() {
        System.out.println("\nAdmin menu:");
        System.out.println("LIST_ALL_BOOKS");
        System.out.println("FIND_BOOK_TITLE [title]");
        System.out.println("FIND_BOOK_AUTHOR [author]");
        System.out.println("FIND_BOOK_TITLE_AUTHOR [title] [author]");
        System.out.println("ADD_NEW_BOOK [title], [author], [e-book: true || false]");
        System.out.println("EDIT_BOOK_TITLE [bookid] [newtitle]");
        System.out.println("EDIT_BOOK_AUTHOR [bookid] [newauthor]");
        System.out.println("DELETE_BOOK [bookid]");
        System.out.println("LOGOUT");
    }

    private String[] splitParameters(String command) {
        String[] commandParams;
        String[] bookParams = command.split(", ");
        if (bookParams.length == 1) {
            commandParams = command.split(" ");
        } else {
            commandParams = new String[bookParams.length + 1];
            commandParams[0] = bookParams[0].split(" ")[0];
            commandParams[1] = bookParams[0].substring(commandParams[0].length()).trim();
            for (int i = 1; i < bookParams.length; i++) {
                commandParams[i+1] = bookParams[i];
            }
        }
        return commandParams;
    }

    private String[] getParameters(String command) throws ViewException{
        String[] commandParameters = null;
        Scanner scanner = new Scanner(System.in);
        try {
            CommandName commandName = CommandName.valueOf(command);
        } catch (IllegalArgumentException e) {
            throw new ViewException("Invalid command");
        }
        switch(CommandName.valueOf(command)) {
            case LOGIN:
                commandParameters = new String[2];
                System.out.println("Login: ");
                commandParameters[0] = scanner.next();
                System.out.println("Password: ");
                commandParameters[1] = scanner.next();
                break;
            case REGISTER:
                commandParameters = new String[3];
                System.out.println("Login: ");
                commandParameters[0] = scanner.next();
                System.out.println("E-mail: ");
                commandParameters[1] = scanner.next();
                System.out.println("Password: ");
                commandParameters[2] = scanner.next();
                break;
            case FIND_BOOKS_TITLE:
                commandParameters = new String[1];
                System.out.println("Title: ");
                commandParameters[0] = scanner.next();
                break;
            case FIND_BOOKS_AUTHOR:
                commandParameters = new String[1];
                System.out.println("Author: ");
                commandParameters[0] = scanner.next();
                break;
            case FIND_BOOKS_TITLE_AUTHOR:
                commandParameters = new String[2];
                System.out.println("Title: ");
                commandParameters[0] = scanner.next();
                System.out.println("Author: ");
                commandParameters[1] = scanner.next();
                break;
            case ADD_NEW_BOOK:
                commandParameters = new String[3];
                System.out.println("Title: ");
                commandParameters[0] = scanner.nextLine();
                System.out.println("Author: ");
                commandParameters[1] = scanner.nextLine();
                System.out.println("Type (true for E-Book, false for paperback) :");
                commandParameters[2] = scanner.next();
                break;
            case EXIT:
                System.exit(0);
            default:

        }
        return commandParameters;
    }

    private void MenuHandler(String command) {
        String error;
        String commandName = command.trim();

        try {
            String[] commandParams = getParameters(commandName);
            Request request = RequestFiller.fillRequest(commandName, commandParams);
            request.setRole(userController.getRole());
            Response response = bookController.executeRequest(request);
            if ((error = response.getErrorMessage()) != null) {
                System.out.println(error);
            } else {
                ResponseViewer.view(response, commandName);
                if (commandName.equals("LOGIN")) {
                    LoginResponse loginResponse = (LoginResponse) response;
                    userController.setRole(loginResponse.getRole());
                } else if (commandName.equals("LOGOUT")) {
                    userController.setRoleGuest();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            run();
        }
    }
}
