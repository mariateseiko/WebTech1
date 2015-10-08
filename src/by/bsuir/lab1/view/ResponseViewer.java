package by.bsuir.lab1.view;

import by.bsuir.lab1.bean.*;
import by.bsuir.lab1.entity.Book;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Maria Teseiko on 07.10.2015.
 */
public class ResponseViewer {
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
                viewAllBooks(response);
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

    public static void viewNewBookResponse(Response bookResponse) {
        NewBookResponse response = (NewBookResponse)bookResponse;
        System.out.println(response.getResultMessage());
    }

    public static void viewAllBooks(Response listAllResponse) {
        ListAllBooksResponse response = (ListAllBooksResponse)listAllResponse;
        List<Book> books = response.getBooksList();
        Scanner scanner = new Scanner(System.in);
        int maxBooksViewAtOnce = 3;
        int start = 0;
        boolean listMode = true;
        while (listMode) {
            for (int i = 0; i < 3 && i + start < books.size(); i++)
                System.out.println(books.get(start + i).toString());
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
