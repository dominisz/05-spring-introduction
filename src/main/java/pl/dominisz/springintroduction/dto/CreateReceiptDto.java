package pl.dominisz.springintroduction.dto;

import lombok.Data;

/**
 * http://dominisz.pl
 * 25.05.2019
 */
@Data
public class CreateReceiptDto {

    private long userId;
    private long orderId;
}
