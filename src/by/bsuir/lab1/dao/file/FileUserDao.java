package by.bsuir.lab1.dao.file;

import by.bsuir.lab1.dao.DaoException;
import by.bsuir.lab1.dao.UserDao;
import by.bsuir.lab1.entity.User;
import by.bsuir.lab1.entity.UserRole;
import by.bsuir.lab1.resource.ResourceManager;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of {@link by.bsuir.lab1.dao.UserDao} for file storage
 */
public class FileUserDao implements UserDao {
    private final static FileUserDao instance = new FileUserDao();
    private final static String usersFile = ResourceManager.getInstance().getProperty("usersFile");
    private FileUserDao(){}

    /**
     * Singleton pattern implementation
     * @return instance of this data access object
     */
    public static FileUserDao getInstance() { return instance; }

    @Override
    public UserRole authorizeUser(User user) throws DaoException {
        Map<String, User> users;
        users = getAllUsers();
        User userInfo = users.get(user.getLogin());
        if (userInfo != null) {
            if (userInfo.getPasswordHash() == user.getPasswordHash()){
                return userInfo.getRole();
            }
        }
        return null;
    }

    @Override
    public boolean registerUser(User user) throws DaoException {
        user.setRole(UserRole.USER);
        Map<String, User> users = getAllUsers();
        if (users.containsKey(user.getLogin())){
            return false;
        } else {
            users.put(user.getLogin(), user);
            saveAllUsers(users);
            return true;
        }
    }

    /**
     * Reads user's info from file and return a map with login as a key and {@link by.bsuir.lab1.entity.User} as value
     *
     * @return map with login as a key and {@link by.bsuir.lab1.entity.User} as value
     * @throws DaoException Thrown if any issue occurs while working with file
     */
    private Map<String, User> getAllUsers() throws DaoException{
        HashMap<String, User> result = new HashMap<>();
        try {
            File file = new File(usersFile);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] userInfo = line.split(" ");
                String login = userInfo[0];
                String email = userInfo[1];
                int passwordHash = Integer.parseInt(userInfo[2]);
                UserRole role = UserRole.valueOf(userInfo[3]);
                User user = new User(login, passwordHash, email, role);
                result.put(login, user);
            }
        } catch(IOException e){
            throw new DaoException("Error reading users from "+usersFile, e);
        }
        return result;
    }

    /**
     * Writes a map containing all users' info to file
     * @param users a map with login as a key and {@link by.bsuir.lab1.entity.User} as value
     * @throws DaoException Thrown if any issue occurs while working with ile
     */
    private  void saveAllUsers(Map<String, User> users) throws DaoException{
        try {
            File file = new File(usersFile);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for(Map.Entry<String, User> entry : users.entrySet()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(entry.getValue().getLogin());
                stringBuilder.append(" " + entry.getValue().getEmail());
                stringBuilder.append(" " + entry.getValue().getPasswordHash());
                stringBuilder.append(" " + entry.getValue().getRole());
                bufferedWriter.write(stringBuilder.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch(IOException e) {
            throw new DaoException("Error saving books" + usersFile, e);
        }
    }
}
