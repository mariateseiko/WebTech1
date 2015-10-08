package by.bsuir.lab1.view;

import by.bsuir.lab1.bean.LoginResponse;
import by.bsuir.lab1.bean.Request;
import by.bsuir.lab1.bean.Response;
import by.bsuir.lab1.controller.BookController;
import by.bsuir.lab1.controller.UserController;

import java.util.Scanner;

/**
 * Created by Maria Teseiko on 05.10.2015.
 */
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
    private void MenuHandler(String command) {
        String error;
        String[] commandParams = splitParameters(command);
        String commandName = commandParams[0];
        switch(commandName) {
            case "EXIT":
                System.exit(0);
        }
        try {
            Request request = RequestFiller.fillRequest(commandParams);
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
