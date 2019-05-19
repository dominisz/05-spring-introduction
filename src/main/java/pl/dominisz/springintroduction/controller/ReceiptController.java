package pl.dominisz.springintroduction.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.dominisz.springintroduction.model.Receipt;

import java.util.List;

/**
 * http://dominisz.pl
 * 19.05.2019
 */
public class ReceiptController {

    public ResponseEntity<Receipt> findById(long id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
