package by.bsuir.lab1.bean;

import by.bsuir.lab1.entity.Book;

/**
 * Created by Maria Teseiko on 10.10.2015.
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

    public void setNewType(boolean isEBook) { book.setType(isEBook); }
    public boolean getNewType() { return book.getType(); }
}
