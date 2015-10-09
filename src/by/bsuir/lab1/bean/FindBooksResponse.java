package by.bsuir.lab1.bean;

import by.bsuir.lab1.entity.Book;

import java.util.List;

/**
 * Created by Maria Teseiko on 08.10.2015.
 */
public class FindBooksResponse extends Response {
    private List<Book> books;
    private String resultMessage;

    public void setBooksList(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooksList() {
        return books;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
