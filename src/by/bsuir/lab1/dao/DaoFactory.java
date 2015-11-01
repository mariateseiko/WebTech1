package by.bsuir.lab1.dao;

import by.bsuir.lab1.dao.factoryimp.FileDaoFactory;
import by.bsuir.lab1.resource.ResourceManager;

/**
 * Provides abstract model of DAO Factory and static methods for getting instances of the factories
 */
public abstract class DaoFactory {
    private static final String DAO_TYPE = ResourceManager.getInstance().getProperty("dao_type");

    /**
     * Acquires an instance of an implemented factory for specified type from properties file and returns it
     *
     * @return instance of a factory
     */
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
