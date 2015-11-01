package by.bsuir.lab1.entity;

/**
 * The Book class represents all identifying info of any book object in the system
 */
public class Book {
    private String title;
    private String author;
    private int bookID;
    private boolean isEBook;

    public Book() {}

    /**
     * Constructs a new book wih given title, author and specified book type
     *
     * @param title book's title
     * @param author book's author
     * @param isEBook specifies whether the book is a e-book(value is true) or a paperback book(value is false)
     */
    public Book(String title, String author, boolean isEBook) {
        this.title = title;
        this.author = author;
        this.isEBook = isEBook;
    }

    /**
     *  Constructs a new book wih given title, author and specified book type
     *
     * @param title book's title
     * @param author book's author
     * @param isEBook specifies whether the book is a e-book(value is true) or a paperback book(value is false)
     * @param id book's unique ID assigned by the system, is less or equal to the total number of books in the system
     */
    public Book(String title, String author, boolean isEBook, int id) {
        this(title, author, isEBook);
        this.bookID = id;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    public int getID() { return bookID; }

    public void setType(boolean isEBook) { this.isEBook = isEBook; }

    public boolean getType() { return isEBook; }

    public void setID(int bookID) { this.bookID = bookID; }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("ID: " + bookID + "\n");
        s.append(title + " by " + author + "\n");
        s.append(isEBook ? "E-Book" : "Paperback");
        return s.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Book other = (Book)obj;

        if (title == null) {
            if(other.title != null)
                  return false;
        } else if (!title.equals(other.title))
            return false;

        if (author == null) {
            if(other.author != null)
                return false;
        } else if (!author.equals(other.author))
            return false;

        if (isEBook != other.isEBook)
            return false;

        if (bookID != other.bookID)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        final int PRIME = 31;
        result = result * PRIME + author.hashCode();
        result = result * PRIME + title.hashCode();
        result = result * PRIME + (isEBook ? 1 : 0);
        return result;
    }
}
