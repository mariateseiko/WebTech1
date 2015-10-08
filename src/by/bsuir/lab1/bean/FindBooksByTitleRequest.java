package by.bsuir.lab1.bean;

/**
 * Created by Maria Teseiko on 08.10.2015.
 */
public class FindBooksByTitleRequest extends Request {
    private String title;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
