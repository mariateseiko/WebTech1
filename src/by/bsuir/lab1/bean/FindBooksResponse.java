package by.bsuir.lab1.bean;

import by.bsuir.lab1.entity.Book;

import java.util.List;

/**
 * A response to the {@link by.bsuir.lab1.bean.FindBooksRequest}
 */
public class FindBooksResponse extends Response {
    private List<Book> books;

    public void setBooksList(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooksList() {
        return books;
    }
}
