package by.bsuir.lab1.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Provides static methods for verifying parameters of the request
 */
public class ParametersVerifier {
    /**
     * Verifies registration parameters.
     * @param parameters login, email and password of the user to be registered
     * @return true if parameters are verified successfully
     * @throws ViewException Thrown if login, email or password are invalid
     * @see #verifyLogin, #verifyEmail, #verifyPassword
     */
    public static boolean verifyRegistrationParameters(String[] parameters) throws ViewException {
        if (!verifyLogin(parameters[0]))
            throw new ViewException("Invalid login. Should be at least 3 characters long");
        if (!verifyEmail(parameters[1]))
            throw new ViewException("Invalid email address");
        if (!verifyPassword(parameters[2]))
            throw new ViewException("Password should be at least 5 character long");
        return true;
    }

    /**
     * Verifies registration parameters.
     * @param parameters title, author and type of the book to be added
     * @return true if parameters are verified successfully
     * @throws ViewException Thrown if book's title or author is empty or null, or book's title is invalid
     * @see #verifyBookType
     */
    public static boolean verifyAddNewBookParameters(String[] parameters) throws ViewException {
        if (parameters[0] == null || parameters[0].trim().isEmpty())
            throw new ViewException("You have to specify the title");
        if (parameters[1] == null)
            throw new ViewException("You have to specify the author");
        if (!verifyBookType(parameters[2]))
            throw new ViewException("You have to specify book type: true for e-book and false for paperback");
        return true;
    }

    /**
     * Verifies book type
     * @param type book's type
     * @return true if type's string can be converted to boolean value
     */
    public static boolean verifyBookType(String type) {
        if (type != null)
            if (type.equalsIgnoreCase("true") || type.equalsIgnoreCase("false"))
                return true;
        return false;
    }

    /**
     * Verifies user's login parameters
     * @param parameters login and password
     * @return true if login and password are valid
     * @throws ViewException Thrown if login or password is invalid
     * @see #verifyLogin, #verifyPassword
     */
    public static boolean verifyLoginParameters(String[] parameters) throws ViewException {
        if (verifyLogin(parameters[0]))
            throw new ViewException("You have not specified the login");
        if (verifyPassword(parameters[1]))
            throw new ViewException("You have not specified the password");
        return true;
    }

    /**
     * Verifies user's login
     * @param login user's login to verify
     * @return true if login length's is more or equals 3 characters
     */
    public static boolean verifyLogin(String login) {
        return (login.trim().length() >= 3);
    }

    /**
     * Verifies user's password
     * @param password user's password to verify
     * @return true if password's length >= 5
     */
    public static boolean verifyPassword(String password) {
        return (password.trim().length() >= 5);
    }

    /**
     * Verifies user's e-mail with a regular expression
     * @param email e-mail to verify
     * @return true if e-mail matches to the pattern
     */
    public static boolean verifyEmail(String email) {
        String regex = "^(\\w{3,64})@(\\w+\\.)([a-z]{2,4})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * Verifies search parameters
     * @param parameters title and/or author or type
     * @param numberOfParameters number of search parameters
     * @return true if each parameter's not empty or null
     * @throws ViewException
     */
    public static boolean verifyFindParameters(String[] parameters, int numberOfParameters) throws ViewException {
        for (int i = 0; i < numberOfParameters; i++)
            if  (parameters[i] == null || parameters[i].trim().isEmpty())
                throw new ViewException("One or more parameters is not specified");
        return true;
    }

    /**
     * Verifies bookID parameter
     * @param id book's ID
     * @throws ViewException Thrown if parameter can't be converted to an integer
     */
    public static void verifyBookID(String id) throws ViewException{
        try {
            Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new ViewException("Book's id should be a numeric value");
        }
    }

    /**
     * Verifies book's edition parameters
     * @param parameters bookID and new value of edited parameter
     * @throws ViewException if book's ID is invalid or new value is empty or null
     */
    public static void verifyEditStringParameters(String[] parameters) throws ViewException {
        verifyBookID(parameters[0]);
        if (parameters[1] == null || parameters[1].isEmpty())
            throw new ViewException("You have to specify search parameter");
    }


}
