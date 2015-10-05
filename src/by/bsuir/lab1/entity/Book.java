package by.bsuir.lab1.entity;

/**
 * Created by Maria Teseiko on 10.09.2015.
 */
public class Book {
    private String title;
    private String author;
    private String genre;
    private int pageCount;
    private int publishYear;
    private int bookID;
    private static int bookCount = 0;
    public Book(String title, String author, String genre, int pageCount, int publishYear) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pageCount = pageCount;
        this.publishYear = publishYear;
        this.bookID = ++bookCount;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getPageCount() {
        return pageCount;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public int getID() {
        return bookID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(title + " by " + author + "\n");
        s.append("Genre: " + genre + "\n");
        s.append("Page count: " + pageCount + "\n");
        s.append("Publish year:" + publishYear + "\n");
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
        if (other.pageCount != pageCount)
            return false;

        if (other.publishYear != publishYear)
            return false;

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

        if (genre == null) {
            if(other.genre != null)
                return false;
        } else if (!genre.equals(other.genre))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        final int PRIME = 31;
        result = result * PRIME + pageCount;
        result = result * PRIME + publishYear;
        result = result * PRIME + author.hashCode();
        result = result * PRIME + title.hashCode();
        result = result * PRIME + genre.hashCode();
        return result;
    }
}
