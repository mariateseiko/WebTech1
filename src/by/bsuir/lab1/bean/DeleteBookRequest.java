package by.bsuir.lab1.bean;

/**
 * A request to delete a {@link by.bsuir.lab1.entity.Book} with a given ID from the repository
 */
public class DeleteBookRequest extends Request{
    private int id;

    public void setID(int id) { this.id = id; }

    public int getID() { return id; }
}
