package pl.dominisz.springintroduction.entity;

import lombok.Getter;
import lombok.Setter;
import pl.dominisz.springintroduction.model.OrderItem;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * http://dominisz.pl
 * 18.05.2019
 */
@Entity
@Getter
@Setter
public class OrderEntity {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private UserEntity user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderItemEntity> items;

}
