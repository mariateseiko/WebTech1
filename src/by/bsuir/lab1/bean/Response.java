package by.bsuir.lab1.bean;

/**
 * A response for {@link by.bsuir.lab1.bean.Request}
 */
public class Response {
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
