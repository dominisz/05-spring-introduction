package pl.dominisz.springintroduction.model;

public class ChargeResult {
    private String message;
    private boolean successfull;

    public ChargeResult(String declineMessage, boolean successfull) {
        this.message = declineMessage;
        this.successfull = successfull;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccessful() {
        return successfull;
    }
}
