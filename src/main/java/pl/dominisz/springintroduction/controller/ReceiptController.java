package pl.dominisz.springintroduction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dominisz.springintroduction.dto.CreateReceiptDto;
import pl.dominisz.springintroduction.model.Receipt;
import pl.dominisz.springintroduction.service.ReceiptService;

import java.util.Optional;

/**
 * http://dominisz.pl
 * 19.05.2019
 */
@RestController
public class ReceiptController {

    private final ReceiptService receiptService;

    @Autowired
    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @GetMapping("/receipts/{id}")
    public ResponseEntity<Receipt> findById(@PathVariable long id) {
        return ResponseEntity.of(receiptService.findById(id));
    }

    @PostMapping("/receipts")
    public Receipt create(@RequestBody CreateReceiptDto createReceiptDto) {
        return receiptService.create(createReceiptDto);
    }

}
