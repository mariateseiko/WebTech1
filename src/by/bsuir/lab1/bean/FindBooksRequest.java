package by.bsuir.lab1.bean;

import by.bsuir.lab1.entity.Book;

/**
 * Created by Maria Teseiko on 08.10.2015.
 */
public class FindBooksRequest extends Request {
    private Book book = new Book();

    public void setTitle(String title) { book.setTitle(title); }

    public String getTitle() {
        return book.getTitle();
    }

    public void setAuthor(String author) { book.setAuthor(author); }

    public String getAuthor() { return book.getAuthor(); }

    public void setType(boolean isEBook) { book.setType(isEBook); }

    public boolean getType() { return book.getType(); }
}
