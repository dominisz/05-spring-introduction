package pl.dominisz.springintroduction.model;

/**
 * http://dominisz.pl
 * 18.05.2019
 */
public class ChargeResult {

    private boolean successful;
    private String message;

    public ChargeResult(boolean successful, String message) {
        this.successful = successful;
        this.message = message;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public String getDeclineMessage() {
        return message;
    }
}
