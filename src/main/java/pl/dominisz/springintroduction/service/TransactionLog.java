package pl.dominisz.springintroduction.service;

/**
 * http://dominisz.pl
 * 18.05.2019
 */
public interface TransactionLog {
    void logChargeResult(ChargeResult result);

    void logConnectException(UnreachableException e);
}
