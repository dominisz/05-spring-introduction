package pl.dominisz.springintroduction.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pl.dominisz.creditcardmodel.CreditCardOperation;
import pl.dominisz.creditcardmodel.CreditCardOperationResult;
import pl.dominisz.creditcardmodel.CreditCardOperationStatus;
import pl.dominisz.creditcardmodel.CreditCardOperationType;
import pl.dominisz.springintroduction.exception.UnreachableException;
import pl.dominisz.springintroduction.model.ChargeResult;
import pl.dominisz.springintroduction.model.CreditCard;

import java.math.BigDecimal;

/**
 * http://dominisz.pl
 * 18.05.2019
 */
@Component
public class PaypalCreditCardProcessor implements CreditCardProcessor {

    @Value("${creditcardapplication.server}")
    private String creditCardServerUrl;

    public ChargeResult charge(CreditCard creditCard, BigDecimal amount) {
        RestTemplate restTemplate = new RestTemplate();

        CreditCardOperation operation = createChargeOperation(creditCard, amount);

        try {
            CreditCardOperationResult operationResult =
                    restTemplate.postForObject(creditCardServerUrl, operation, CreditCardOperationResult.class);

            if (operationResult != null) {
                return new ChargeResult(operationResult.getStatus().equals(CreditCardOperationStatus.OK), operationResult.getMessage());
            } else {
                return new ChargeResult(false, "Null response");
            }
        } catch (RestClientException exception) {
            throw new UnreachableException(exception.getMessage());
        }
    }

    private CreditCardOperation createChargeOperation(CreditCard creditCard, BigDecimal amount) {
        CreditCardOperation operation = new CreditCardOperation();
        operation.setNumber(creditCard.getNumber());
        operation.setAmount(amount);
        operation.setOperationType(CreditCardOperationType.CHARGE);
        return operation;
    }
}