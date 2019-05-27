package pl.dominisz.springintroduction.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * http://dominisz.pl
 * 18.05.2019
 */
@Getter
@Setter
public class Order {

    private long id;
    private long userId;
    private List<OrderItem> items = new ArrayList<>();

    public void addItem(OrderItem orderItem) {
        items.add(orderItem);
    }

    public BigDecimal getAmount() {
        BigDecimal sum = BigDecimal.ZERO;

        for (OrderItem orderItem : items) {
            sum = sum.add(orderItem.getPrice().multiply(new BigDecimal(orderItem.getQuantity())));
        }

        return sum;
    }
}
