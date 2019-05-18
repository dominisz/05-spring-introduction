package pl.dominisz.springintroduction.model;

import pl.dominisz.springintroduction.exception.UnreachableException;

public interface TransactionLog {
    void logChargeResult(ChargeResult result);

    void logConnectException(UnreachableException e);
}
