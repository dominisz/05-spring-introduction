package pl.dominisz.springintroduction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dominisz.springintroduction.dto.CreateReceiptDto;
import pl.dominisz.springintroduction.exception.OrderNotFoundException;
import pl.dominisz.springintroduction.exception.UserNotFoundException;
import pl.dominisz.springintroduction.model.Order;
import pl.dominisz.springintroduction.model.Receipt;
import pl.dominisz.springintroduction.model.User;
import pl.dominisz.springintroduction.repository.OrderRepository;
import pl.dominisz.springintroduction.repository.ReceiptRepository;
import pl.dominisz.springintroduction.repository.UserRepository;

import java.util.Optional;

/**
 * http://dominisz.pl
 * 25.05.2019
 */
@Service
public class ReceiptServiceImpl implements ReceiptService {

    private final BillingService billingService;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ReceiptRepository receiptRepository;

    @Autowired
    public ReceiptServiceImpl(BillingService billingService, OrderRepository orderRepository, UserRepository userRepository, ReceiptRepository receiptRepository) {
        this.billingService = billingService;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.receiptRepository = receiptRepository;
    }

    @Override
    public Optional<Receipt> findById(long id) {
        return receiptRepository.findById(id);
    }

    @Override
    public Receipt create(CreateReceiptDto createReceiptDto) {
        User user = userRepository
                .findById(createReceiptDto.getUserId())
                .orElseThrow(() -> new UserNotFoundException(createReceiptDto.getUserId()));

        Order order = orderRepository
                .findById(createReceiptDto.getOrderId())
                .orElseThrow(() -> new OrderNotFoundException(createReceiptDto.getOrderId()));

        Receipt receipt = billingService.chargeOrder(order, user.getCreditCard());

        return receiptRepository.save(receipt);
    }
}