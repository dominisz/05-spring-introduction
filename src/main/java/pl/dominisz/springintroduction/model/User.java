package pl.dominisz.springintroduction.model;

import lombok.Data;

/**
 * http://dominisz.pl
 * 19.05.2019
 */
@Data
public class User {

    private long id;
    private String name;
    private String email;
    private CreditCard creditCard;

}
