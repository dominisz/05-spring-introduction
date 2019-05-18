package pl.dominisz.springintroduction.service;

public class ChargeResult {
    private String declineMessage;

    public String getDeclineMessage() {
        return declineMessage;
    }

    public boolean wasSuccessful() {
        return false;
    }
}
