package by.bsuir.lab1.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Maria Teseiko on 07.10.2015.
 */
public class ParametersVerifier {
    public static boolean verifyRegistrationParameters(String[] parameters) throws ViewException {
        if (!verifyLogin(parameters[0]))
            throw new ViewException("Invalid login. Should be at least 3 characters long");
        if (!verifyEmail(parameters[1]))
            throw new ViewException("Invalid email address");
        if (!verifyPassword(parameters[2]))
            throw new ViewException("Password should be at least 5 character long");
        return true;
    }

    public static boolean verifyAddNewBookParameters(String[] parameters) throws ViewException {
        if (parameters[0] == null || parameters[0].trim().isEmpty())
            throw new ViewException("You have to specify the title");
        if (parameters[1] == null)
            throw new ViewException("You have to specify the author");
        if (!verifyBookType(parameters[2]))
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
        if (parameters[0].trim().isEmpty())
            throw new ViewException("You have not specified the login");
        if (parameters[1].trim().isEmpty())
            throw new ViewException("You have not specified the password");
        return true;
    }

    public static boolean verifyLogin(String login) {
        if (login.trim().length() >= 3)
            return true;
        else return false;
    }

    public static boolean verifyPassword(String password) {
        if (password.trim().length() >= 5)
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

    public static boolean verifyFindParameters(String[] parameters, int numberOfParameters) throws ViewException {
        for (int i = 0; i < numberOfParameters; i++)
            if  (parameters[i] == null || parameters[i].trim().isEmpty())
                throw new ViewException("One or more parameters is not specified");
        return true;
    }
}
