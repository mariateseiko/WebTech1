package by.bsuir.lab1.bean;

import by.bsuir.lab1.entity.Book;

/**
 * A request to add a new book to the repository
 */
public class NewBookRequest extends Request{
    private Book newBook = new Book();

    public void setBookTitle(String title) {
        newBook.setTitle(title);
    }

    public void setBookAuthor(String author) {
        newBook.setAuthor(author);
    }

    public void setBookType(boolean isEBook) {
        newBook.setType(isEBook);
    }

    public Book getBook() {
        return newBook;
    }
}
