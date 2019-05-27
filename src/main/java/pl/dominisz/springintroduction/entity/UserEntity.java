package pl.dominisz.springintroduction.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * http://dominisz.pl
 * 19.05.2019
 */
@Entity
@Getter
@Setter
public class UserEntity {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private String email;

    @Embedded
    private CreditCardEntity creditCard;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<OrderEntity> orders;

}
