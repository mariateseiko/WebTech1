package by.bsuir.lab1.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Maria Teseiko on 07.10.2015.
 */
public class ParametersVerifier {
    public static boolean verifyRegistrationParameters(String[] parameters) throws ViewException {
        if (parameters.length < 4)
            throw new ViewException("Invalid command parameters");
        if (!verifyLogin(parameters[1]))
            throw new ViewException("Invalid login. Should be at least 3 characters long");
        if (!verifyEmail(parameters[2]))
            throw new ViewException("Invalid email address");
        if (!verifyPassword(parameters[3]))
            throw new ViewException("Password should be at least 5 character long");
        return true;
    }

    public static boolean verifyAddNewBookParameters(String[] parameters) throws ViewException {
        if (parameters.length < 4)
            throw new ViewException("Invalid command parameters");
        if (parameters[1] == null)
            throw new ViewException("You have to specify the title");
        if (parameters[2] == null)
            throw new ViewException("You have to specify the author");
        if (!verifyBookType(parameters[3]))
            throw new ViewException("You have to specify book type: true for e-book and false for paperback");
        return true;
    }

    public static boolean verifyBookType(String type) {
        if (type != null)
            if (type.equalsIgnoreCase("true") || type.equalsIgnoreCase("false"))
                return true;
        return false;
    }



    public static boolean verifyLoginParameters(String[] parameters) throws ViewException {
        if (parameters.length < 3 || parameters[1] == null || parameters[2] == null)
            throw new ViewException("Invalid command parameters");
        return true;
    }

    public static boolean verifyLogin(String login) {
        if (login != null && login.length() >= 3)
            return true;
        else return false;
    }

    public static boolean verifyPassword(String password) {
        if (password != null && password.length() >= 5)
            return true;
        else return false;
    }

    public static boolean verifyEmail(String email) {
        String regex = "^(\\w{3,64})@(\\w+\\.)([a-z]{2,4})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) { return true; }
        else { return false; }
    }

    public static boolean verifySingleFind(String[] parameters) throws ViewException{
        if (parameters.length < 2)
            throw new ViewException("Invalid parameters");
        return true;
    }
}
