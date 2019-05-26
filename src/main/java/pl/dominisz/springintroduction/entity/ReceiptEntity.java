package pl.dominisz.springintroduction.entity;

import lombok.Getter;
import lombok.Setter;

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
public class ReceiptEntity {

    @Id @GeneratedValue
    private Long id;
    private BigDecimal amount;
    private String message;
    private boolean successful;

 }
