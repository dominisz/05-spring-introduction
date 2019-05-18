package pl.dominisz.springintroduction.service;

public interface TransactionLog {
    void logChargeResult(ChargeResult result);

    void logConnectException(UnreachableException e);
}
