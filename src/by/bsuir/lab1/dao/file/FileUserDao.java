package by.bsuir.lab1.dao.file;

import by.bsuir.lab1.dao.DaoException;
import by.bsuir.lab1.dao.UserDao;
import by.bsuir.lab1.entity.Book;
import by.bsuir.lab1.entity.User;
import by.bsuir.lab1.entity.UserRole;
import by.bsuir.lab1.resource.ResourceManager;

import java.io.*;
import java.util.*;

/**
 * Created by Maria Teseiko on 10.09.2015.
 */
public class FileUserDao implements UserDao {
    private final static FileUserDao instance = new FileUserDao();
    private final static String usersFile = ResourceManager.getInstance().getProperty("usersFile");
    private FileUserDao(){}

    public static FileUserDao getInstance() { return instance; }


    @Override
    public boolean authorizeUser(User user) throws DaoException {
        Map<String, User> users;
        users =(HashMap<String, User>) getAllUsers();
        /*Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()) {
            User nextUser = iterator.next();
            if (nextUser.getLogin().equals(user.getLogin()))

        }*/
        User userInfo = users.get(user.getLogin());
        if (userInfo != null) {
            if (userInfo.getPasswordHash().equals(user.getPasswordHash())){
                user = userInfo;
                return true;
            }
        }
        return false;
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

    private Map<String, User> getAllUsers() throws DaoException{
        Map<String, User> result;
        try {
            FileInputStream fileInputStream = new FileInputStream(usersFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            result = (HashMap<String, User>)objectInputStream.readObject();
        } catch(IOException e){
            throw new DaoException("Error reading books from "+usersFile, e);
        } catch(ClassNotFoundException e){
            throw new DaoException("Class not found", e);
        }
        return result;
    }


    private  void saveAllUsers(Map<String, User> users) throws DaoException{
        Map<String, User> result;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(usersFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(users);
        } catch(IOException e) {
            throw new DaoException("Error reading books from " + usersFile, e);
        }

    }
}
