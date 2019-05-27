package pl.dominisz.springintroduction.service;

import org.springframework.stereotype.Service;
import pl.dominisz.springintroduction.converter.Converter;
import pl.dominisz.springintroduction.dto.CreateReceiptDto;
import pl.dominisz.springintroduction.entity.CreditCardEntity;
import pl.dominisz.springintroduction.entity.OrderEntity;
import pl.dominisz.springintroduction.entity.ReceiptEntity;
import pl.dominisz.springintroduction.entity.UserEntity;
import pl.dominisz.springintroduction.exception.OrderNotFoundException;
import pl.dominisz.springintroduction.exception.UserNotFoundException;
import pl.dominisz.springintroduction.model.CreditCard;
import pl.dominisz.springintroduction.model.Order;
import pl.dominisz.springintroduction.model.Receipt;
import pl.dominisz.springintroduction.repository.ReceiptEntityRepository;
import pl.dominisz.springintroduction.repository.UserEntityRepository;

import java.util.Optional;

/**
 * http://dominisz.pl
 * 25.05.2019
 */
@Service
public class ReceiptServiceImpl implements ReceiptService {

    private final BillingService billingService;
    private final UserEntityRepository userEntityRepository;
    private final ReceiptEntityRepository receiptEntityRepository;
    private final Converter<Order, OrderEntity> orderConverter;
    private final Converter<CreditCard, CreditCardEntity> creditCardConverter;
    private final Converter<Receipt, ReceiptEntity> receiptConverter;

    public ReceiptServiceImpl(BillingService billingService,
                              UserEntityRepository userEntityRepository,
                              ReceiptEntityRepository receiptEntityRepository,
                              Converter<Order, OrderEntity> orderConverter,
                              Converter<CreditCard, CreditCardEntity> creditCardConverter,
                              Converter<Receipt, ReceiptEntity> receiptConverter) {
        this.billingService = billingService;
        this.userEntityRepository = userEntityRepository;
        this.receiptEntityRepository = receiptEntityRepository;
        this.orderConverter = orderConverter;
        this.creditCardConverter = creditCardConverter;
        this.receiptConverter = receiptConverter;
    }

    @Override
    public Optional<Receipt> findById(long id) {
        return receiptEntityRepository.findById(id)
                .map(receiptEntity -> receiptConverter.toModel(receiptEntity));
    }

    @Override
    public Receipt create(CreateReceiptDto createReceiptDto) {
        UserEntity userEntity = userEntityRepository
                .findById(createReceiptDto.getUserId())
                .orElseThrow(() -> new UserNotFoundException(createReceiptDto.getUserId()));

        OrderEntity orderEntity = userEntity.getOrders().stream()
                .filter(orderEntity1 -> orderEntity1.getId().equals(createReceiptDto.getOrderId()))
                .findFirst()
                .orElseThrow(() -> new OrderNotFoundException(createReceiptDto.getOrderId()));

        Order order = orderConverter.toModel(orderEntity);
        CreditCard creditCard = creditCardConverter.toModel(userEntity.getCreditCard());

        Receipt receipt = billingService.chargeOrder(order, creditCard);

        ReceiptEntity receiptEntity = receiptConverter.toEntity(receipt);

        receiptEntity = receiptEntityRepository.save(receiptEntity);

        return receiptConverter.toModel(receiptEntity);
    }
}