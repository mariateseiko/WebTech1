package by.bsuir.lab1.bean;

/**
 * A response to {@link by.bsuir.lab1.bean.DeleteBookRequest}
 */

public class DeleteBookResponse extends Response {
    private String resultMessage;

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
