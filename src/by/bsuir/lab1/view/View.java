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
        showMenu(userController.getCommandsList());
        System.out.print(">");
        String command = input.nextLine();
        MenuHandler(command);
    }

    private void showMenu(CommandName[] commandNames) {
        for(CommandName name: commandNames) {
            System.out.println(name);
        }
    }

    private void MenuHandler(String command) {
        String error;
        String commandName = command.trim();
        try {
            String[] commandParams = ParametersGetter.get(commandName);
            Request request = RequestFiller.fillRequest(commandName, commandParams);
            request.setRole(userController.getRole());
            Response response = bookController.executeRequest(request);
            if ((error = response.getErrorMessage()) != null) {
                System.out.println(error);
            } else {
                ResponseViewer.view(response, commandName);
                if (commandName.equals(CommandName.LOGIN.toString())) {
                    LoginResponse loginResponse = (LoginResponse) response;
                    userController.setRole(loginResponse.getRole());
                } else if (commandName.equals(CommandName.LOGOUT.toString())) {
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
