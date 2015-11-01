package by.bsuir.lab1.bean;

import by.bsuir.lab1.entity.Book;

/**
 * A request to find {@link by.bsuir.lab1.entity.Book} with given parameters
 */
public class FindBooksRequest extends Request {
    private Book book = new Book();

    public void setTitle(String title) { book.setTitle(title); }

    public String getTitle() {
        return book.getTitle();
    }

    public void setAuthor(String author) { book.setAuthor(author); }

    public String getAuthor() { return book.getAuthor(); }
}
