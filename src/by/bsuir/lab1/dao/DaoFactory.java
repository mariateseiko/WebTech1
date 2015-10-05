package by.bsuir.lab1.dao;

import by.bsuir.lab1.dao.factoryimp.FileDaoFactory;
import by.bsuir.lab1.resource.ResourceManager;

/**
 * Created by Maria Teseiko on 10.09.2015.
 */
public abstract class DaoFactory {
    private static final String DAO_TYPE = ResourceManager.getInstance().getProperty("dao_type");

    public static DaoFactory getDaoFactory(){
        switch (DAO_TYPE){
            case "file":
                return FileDaoFactory.getInstance();
        }
        return null;
    }

    public abstract FindDao getFindDao();
    public abstract ModificationDao getModificationDao();

    public abstract UserDao getUserDao();
}
