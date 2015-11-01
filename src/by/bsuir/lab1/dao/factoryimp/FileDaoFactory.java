package by.bsuir.lab1.dao.factoryimp;

import by.bsuir.lab1.dao.DaoFactory;
import by.bsuir.lab1.dao.FindDao;
import by.bsuir.lab1.dao.ModificationDao;
import by.bsuir.lab1.dao.UserDao;
import by.bsuir.lab1.dao.file.FileFindDao;
import by.bsuir.lab1.dao.file.FileModificationDao;
import by.bsuir.lab1.dao.file.FileUserDao;

/**
 * DAO Factory for file storage
 *
 * @see by.bsuir.lab1.dao.DaoFactory
 */
public class FileDaoFactory extends DaoFactory {
    private static final FileDaoFactory instance = new FileDaoFactory();

    private FileDaoFactory(){}

    public static FileDaoFactory getInstance() { return instance; }

    @Override
    public FindDao getFindDao() { return FileFindDao.getInstance(); }

    @Override
    public ModificationDao getModificationDao() { return FileModificationDao.getInstance(); }

    @Override
    public UserDao getUserDao() { return FileUserDao.getInstance(); }


}
