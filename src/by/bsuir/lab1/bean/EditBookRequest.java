package by.bsuir.lab1.bean;

import by.bsuir.lab1.entity.Book;

/**
 * A request to edit book's chosen parameter
 */
public class EditBookRequest extends Request {
    private int id;
    private Book book = new Book();

    public void setID(int id) { this.id = id; }
    public int getID() { return id; }

    public void setNewTitle(String title) { book.setTitle(title); }
    public String getNewTitle() { return book.getTitle(); }

    public void setNewAuthor(String author) { book.setAuthor(author); }
    public String getNewAuthor() { return book.getAuthor(); }
}
