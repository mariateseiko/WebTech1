package by.bsuir.lab1.dao.file;

import by.bsuir.lab1.dao.DaoException;
import by.bsuir.lab1.entity.Book;
import by.bsuir.lab1.resource.ResourceManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maria Teseiko on 08.10.2015.
 */
public class FileCommonDao {
    private final static FileCommonDao instance = new FileCommonDao();

    public static FileCommonDao getInstance() { return instance; }

    private FileCommonDao() {}

    private final static String booksFile = ResourceManager.getInstance().getProperty("booksFile");

    public List<Book> getAllBooks() throws DaoException {
        ArrayList<Book> result = new ArrayList<>();
        try {
            File file = new File(booksFile);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            int i = 0;
            String[] bookInfo = new String[4];
            while ((line = bufferedReader.readLine()) != null ) {
                bookInfo[i++] = line;
                if (i == 4) {
                    int id = Integer.parseInt(bookInfo[0]);
                    String title = bookInfo[1];
                    String author = bookInfo[2];
                    boolean type = Boolean.parseBoolean(bookInfo[3]);
                    Book book = new Book(title, author, type, id);
                    result.add(book);
                    i = 0;
                }
            }

        } catch(IOException e){
            throw new DaoException("Error reading books from "+ booksFile, e);
        }
        return result;
    }

    public void saveAllBooks(List<Book> books) throws DaoException{
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File(booksFile);
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for(Book book: books) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(book.getID() + "\n");
                stringBuilder.append(book.getTitle() + "\n");
                stringBuilder.append(book.getAuthor() + "\n");
                stringBuilder.append(book.getType() + "\n");
                bufferedWriter.write(stringBuilder.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch(IOException e) {
            throw new DaoException("Error saving books to "+booksFile, e);
        }
    }
}
