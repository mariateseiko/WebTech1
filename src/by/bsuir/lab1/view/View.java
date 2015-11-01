package by.bsuir.lab1.view;

import by.bsuir.lab1.bean.LoginResponse;
import by.bsuir.lab1.bean.Request;
import by.bsuir.lab1.bean.Response;
import by.bsuir.lab1.controller.BookController;
import by.bsuir.lab1.controller.UserController;
import by.bsuir.lab1.controller.command.CommandName;

import java.util.Scanner;

/**
 * Handles interactions with the user
 */
public class View {
    private BookController bookController = new BookController();
    private UserController userController = new UserController();
    private Scanner input = new Scanner(System.in);

    /**
     * Shows a list of all available commands, gets the user's info and passes it to the {@link #menuHandler}
     */
    public void run(){
        showMenu(userController.getCommandsList());
        System.out.print(">");
        String command = input.nextLine();
        menuHandler(command);
    }

    /**
     * View commands name passed to the method
     * @param commandNames commands to show
     */
    private void showMenu(CommandName[] commandNames) {
        for(CommandName name: commandNames) {
            System.out.println(name);
        }
    }

    /**
     * Handles user's command
     * <p>
     *     Extracts request parameters from the user's input, fills in a {@link by.bsuir.lab1.bean.Request}
     *     and passes it to the controller to execute. In case of successful execution views either error message
     *     or response message. In case of login or logout commands changes current user's role.
     * </p>
     * @param command user's command with parameters
     */
    private void menuHandler(String command) {
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
