package by.bsuir.lab1.view;

import by.bsuir.lab1.controller.command.CommandName;

import java.util.Scanner;

/**
 * Created by Maria Teseiko on 10.10.2015.
 */
public class ParametersGetter {
    public static String[] get(String command) throws ViewException {
        String[] commandParameters = null;
        Scanner scanner = new Scanner(System.in);
        try {
            CommandName.valueOf(command);
        } catch (IllegalArgumentException e) {
            throw new ViewException("Invalid command");
        }
        switch(CommandName.valueOf(command)) {
            case LOGIN:
                commandParameters = new String[2];
                System.out.println("Login: ");
                commandParameters[0] = scanner.nextLine();
                System.out.println("Password: ");
                commandParameters[1] = scanner.nextLine();
                break;
            case REGISTER:
                commandParameters = new String[3];
                System.out.println("Login: ");
                commandParameters[0] = scanner.nextLine();
                System.out.println("E-mail: ");
                commandParameters[1] = scanner.nextLine();
                System.out.println("Password: ");
                commandParameters[2] = scanner.nextLine();
                break;
            case FIND_BOOKS_TITLE:
                commandParameters = new String[1];
                System.out.println("Title: ");
                commandParameters[0] = scanner.nextLine();
                break;
            case FIND_BOOKS_AUTHOR:
                commandParameters = new String[1];
                System.out.println("Author: ");
                commandParameters[0] = scanner.nextLine();
                break;
            case FIND_BOOKS_TITLE_AUTHOR:
                commandParameters = new String[2];
                System.out.println("Title: ");
                commandParameters[0] = scanner.nextLine();
                System.out.println("Author: ");
                commandParameters[1] = scanner.nextLine();
                break;
            case ADD_NEW_BOOK:
                commandParameters = new String[3];
                System.out.println("Title: ");
                commandParameters[0] = scanner.nextLine();
                System.out.println("Author: ");
                commandParameters[1] = scanner.nextLine();
                System.out.println("Type (true for E-Book, false for paperback) :");
                commandParameters[2] = scanner.nextLine();
                break;
            case EDIT_BOOK_AUTHOR:
                commandParameters = new String[2];
                System.out.println("Book's id: ");
                commandParameters[0] = scanner.nextLine();
                System.out.println("New Author: ");
                commandParameters[1] = scanner.nextLine();
                break;
            case EDIT_BOOK_TITLE:
                commandParameters = new String[2];
                System.out.println("Book's id: ");
                commandParameters[0] = scanner.nextLine();
                System.out.println("New Title: ");
                commandParameters[1] = scanner.nextLine();
                break;
            case EDIT_BOOK_TYPE:
            case DELETE_BOOK:
                commandParameters = new String[1];
                System.out.println("Book's id: ");
                commandParameters[0] = scanner.nextLine();
                break;

            case EXIT:
                System.exit(0);
            default:
        }
        return commandParameters;
    }
}
