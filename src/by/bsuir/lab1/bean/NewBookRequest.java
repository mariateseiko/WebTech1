package by.bsuir.lab1.bean;

import by.bsuir.lab1.entity.Book;

/**
 * Created by Maria Teseiko on 03.10.2015.
 */
public class NewBookRequest extends Request{
    private Book newBook;

    public void setBook(String title, String author, String genre, int pageCount, int publishYear) {
        newBook = new Book(title, author, genre, pageCount, publishYear);
    }

    public Book getBook() {
        return newBook;
    }
}
