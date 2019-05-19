package pl.dominisz.springintroduction.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * http://dominisz.pl
 * 18.05.2019
 */
@Data
@AllArgsConstructor
public class OrderItem {

    private String description;
    private int quantity;
    private BigDecimal price;

}
