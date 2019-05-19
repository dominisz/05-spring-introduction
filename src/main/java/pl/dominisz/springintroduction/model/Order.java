package pl.dominisz.springintroduction.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * http://dominisz.pl
 * 18.05.2019
 */
public class Order {

    private long id;
    private long userId;
    private List<OrderItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(OrderItem orderItem) {
        items.add(orderItem);
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        BigDecimal sum = BigDecimal.ZERO;

        for (OrderItem orderItem : items) {
            sum = sum.add(orderItem.getPrice().multiply(new BigDecimal(orderItem.getQuantity())));
        }

        return sum;
    }
}
