package by.bsuir.lab1.bean;

/**
 * A response to {@link by.bsuir.lab1.bean.EditBookRequest}
 */
public class EditBookResponse extends Response {
    private String resultMessage;

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
