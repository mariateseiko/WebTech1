package by.bsuir.lab1.dao.factoryimp;

import by.bsuir.lab1.dao.*;

import by.bsuir.lab1.dao.file.FileFindDao;
import by.bsuir.lab1.dao.file.FileModificationDao;
import by.bsuir.lab1.dao.file.FileUserDao;

/**
 * Created by Maria Teseiko on 10.09.2015.
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
