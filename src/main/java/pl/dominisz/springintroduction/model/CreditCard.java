package pl.dominisz.springintroduction.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * http://dominisz.pl
 * 18.05.2019
 */
@Getter
@Setter
public class CreditCard {

    private String firstName;
    private String lastName;
    private String number;
    private LocalDate expiryDate;

}

