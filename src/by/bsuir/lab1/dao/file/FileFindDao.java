package by.bsuir.lab1.dao.file;

import by.bsuir.lab1.dao.DaoException;
import by.bsuir.lab1.dao.FindDao;
import by.bsuir.lab1.entity.Book;
import by.bsuir.lab1.resource.ResourceManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maria Teseiko on 10.09.2015.
 */
public class FileFindDao implements FindDao {
    private final static FileFindDao instance = new FileFindDao();
    private final static String booksFile = ResourceManager.getInstance().getProperty("booksFile");

    private FileFindDao(){}
    private FileCommonDao commonDao = FileCommonDao.getInstance();
    public static FileFindDao getInstance() { return instance; }

    @Override
    public List<Book> findBookByTitle(String title) throws DaoException{
        List<Book> list = commonDao.getAllBooks();
        List<Book> result = new ArrayList<>();
        for(Book book: list){
            if (book.getTitle().equalsIgnoreCase(title))
                result.add(book);
        }
        if (result.size() != 0 )
            return result;
        else return null;
    }

    @Override
    public List<Book> findBookByAuthor(String author) throws DaoException{
        List<Book> list = commonDao.getAllBooks();
        List<Book> result = new ArrayList<>();
        for(Book book: list){
            if (book.getTitle().equalsIgnoreCase(author))
                result.add(book);
        }
        if (result.size() != 0 )
            return result;
        else return null;
    }

    @Override
    public Book findBookByTitleAndAuthor(String title, String author) throws DaoException{
        return null;
    }

    @Override
    public List<Book> findAllBooks() throws DaoException{
       return commonDao.getAllBooks();
    }



}
