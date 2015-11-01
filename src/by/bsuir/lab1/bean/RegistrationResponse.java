package by.bsuir.lab1.bean;

/**
 * A response for {@link by.bsuir.lab1.bean.RegistrationRequest}
 */
public class RegistrationResponse extends Response {
    private String resultMessage;

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
