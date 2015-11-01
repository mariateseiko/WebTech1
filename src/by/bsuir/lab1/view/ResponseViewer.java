package by.bsuir.lab1.view;

import by.bsuir.lab1.bean.*;
import by.bsuir.lab1.entity.Book;

import java.util.List;
import java.util.Scanner;

/**
 * Generates user's view according to response type and command name
 */
public class ResponseViewer {
    /**
     * Chooses a view according to the command name and response
     * @param response response to view
     * @param command specifies type of the response
     */
    public static void view(Response response, String command) {
        switch(command) {
            case "REGISTER":
                viewRegisterResponse(response);
                break;
            case "LOGIN":
                viewLoginResponse(response);
                break;
            case "ADD_NEW_BOOK":
                viewNewBookResponse(response);
                break;
            case "LIST_ALL_BOOKS":
            case "FIND_BOOKS_TITLE":
            case "FIND_BOOKS_AUTHOR":
            case "FIND_BOOKS_TITLE_AUTHOR":
                viewAllBooks(response);
                break;
            case "DELETE_BOOK":
                viewDeleteResponse(response);
                break;
            case "EDIT_BOOK_TITLE":
            case "EDIT_BOOK_AUTHOR":
            case "EDIT_BOOK_TYPE":
                viewEditResponse(response);
                break;
            case "LOGOUT":
                viewLogoutResponse(response);
                break;
        }
    }

    public static void viewRegisterResponse(Response registrationResponse) {
        RegistrationResponse response = (RegistrationResponse)registrationResponse;
        System.out.println(response.getResultMessage());
    }

    public static void viewLoginResponse(Response loginResponse) {
        LoginResponse response = (LoginResponse)loginResponse;
        System.out.println(response.getResultMessage());
    }

    public static void viewLogoutResponse(Response logoutResponse) {
        LogoutResponse response = (LogoutResponse)logoutResponse;
        System.out.println(response.getResultMessage());
    }

    public static void viewEditResponse(Response editResponse) {
        EditBookResponse response = (EditBookResponse)editResponse;
        System.out.println(response.getResultMessage());
    }
    public static void viewNewBookResponse(Response bookResponse) {
        NewBookResponse response = (NewBookResponse)bookResponse;
        System.out.println(response.getResultMessage());
    }

    public static void viewDeleteResponse(Response deleteResponse) {
        DeleteBookResponse response = (DeleteBookResponse)deleteResponse;
        System.out.println(response.getResultMessage());
    }

    /**
     * Views list of all books. Shows {maxBooksViewAtOnce} and let's user to scroll the pages or to exit
     * to the main menu
     * @param listAllResponse list of books to show
     */
    public static void viewAllBooks(Response listAllResponse) {
        FindBooksResponse response = (FindBooksResponse)listAllResponse;
        List<Book> books = response.getBooksList();
        Scanner scanner = new Scanner(System.in);
        int maxBooksViewAtOnce = 3;
        int start = 0;
        boolean listMode = true;
        while (listMode) {
            for (int i = 0; i < 3 && i + start < books.size(); i++) {
                System.out.println(books.get(start + i).toString());
                System.out.println();
            }
            if (books.size() > maxBooksViewAtOnce) {
                if (start + maxBooksViewAtOnce < books.size())
                    System.out.println("Enter + for next page");
                if (start > 0)
                    System.out.println("Enter - for previous page");
                System.out.println("Any other key to return to menu");
                String input = scanner.next();
                if (input.equals("+") && start + maxBooksViewAtOnce < books.size() )
                    start += maxBooksViewAtOnce;
                else if (input.equals("-") && start > 0)
                    start -= maxBooksViewAtOnce;
                else
                    listMode = false;
            } else
                listMode = false;
        }
    }
}
