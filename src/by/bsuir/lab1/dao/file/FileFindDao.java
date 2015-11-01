package by.bsuir.lab1.dao.file;

import by.bsuir.lab1.dao.DaoException;
import by.bsuir.lab1.dao.FindDao;
import by.bsuir.lab1.entity.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link by.bsuir.lab1.dao.FindDao} for file storage
 */
public class FileFindDao implements FindDao {
    private final static FileFindDao instance = new FileFindDao();

    private FileFindDao(){}
    private FileCommonDao commonDao = FileCommonDao.getInstance();

    /**
     * Singleton pattern implementation
     * @return instance of this data access object
     */
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
            if (book.getAuthor().equalsIgnoreCase(author))
                result.add(book);
        }
        if (result.size() != 0 )
            return result;
        else return null;
    }

    @Override
    public List<Book> findBookByTitleAndAuthor(String title, String author) throws DaoException{
        List<Book> list = commonDao.getAllBooks();
        List<Book> result = new ArrayList<>();
        for(Book book: list){
            if ((book.getTitle().equalsIgnoreCase(title)) && (book.getAuthor().equalsIgnoreCase(author)))
                result.add(book);
        }
        if (result.size() != 0)
            return result;
        else return null;
    }

    @Override
    public List<Book> findAllBooks() throws DaoException{
       return commonDao.getAllBooks();
    }
}
