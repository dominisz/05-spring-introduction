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

    public OrderItem(String description, BigDecimal price) {
      this.description = description;
      this.quantity = 1;
      this.price = price;
    }

}
