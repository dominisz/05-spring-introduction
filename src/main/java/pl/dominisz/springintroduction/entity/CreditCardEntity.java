package pl.dominisz.springintroduction.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.LocalDate;

/**
 * http://dominisz.pl
 * 18.05.2019
 */
@Embeddable
@Getter
@Setter
public class CreditCardEntity {

    private String firstName;
    private String lastName;
    private String number;
    private LocalDate expiryDate;

}

