package pl.dominisz.springintroduction.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * http://dominisz.pl
 * 18.05.2019
 */
@Entity
@Getter
@Setter
public class OrderItemEntity {

    @Id @GeneratedValue
    private Long id;

    private String description;
    private int quantity;
    private BigDecimal price;

}
