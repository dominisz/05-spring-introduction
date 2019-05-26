package pl.dominisz.springintroduction.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * http://dominisz.pl
 * 18.05.2019
 */
@Data
@NoArgsConstructor
public class Receipt {

    private long id;
    private BigDecimal amount;
    private String message;
    private boolean successful;

    public Receipt(BigDecimal amount, String message, boolean successful) {
        this.amount = amount;
        this.message = message;
        this.successful = successful;
    }

    public static Receipt forSuccessfulCharge(BigDecimal amount) {
        return new Receipt(amount, null, true);
    }

    public static Receipt forDeclinedCharge(String declineMessage) {
        return new Receipt(null, declineMessage, false);
    }

    public static Receipt forSystemFailure(String message) {
        return new Receipt(null, message, false);
    }
}
