package pl.dominisz.springintroduction.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.dominisz.springintroduction.dto.CreateReceiptDto;
import pl.dominisz.springintroduction.exception.OrderNotFoundException;
import pl.dominisz.springintroduction.exception.UserNotFoundException;
import pl.dominisz.springintroduction.model.Order;
import pl.dominisz.springintroduction.model.User;
import pl.dominisz.springintroduction.repository.OrderRepository;
import pl.dominisz.springintroduction.repository.ReceiptRepository;
import pl.dominisz.springintroduction.repository.UserRepository;

import java.util.Optional;

/**
 * http://dominisz.pl
 * 25.05.2019
 */
public class Junit5ReceiptServiceImplTest {

    private final long USER_ID = 1;
    private final long ORDER_ID = 1;

    private UserRepository userRepository;
    private OrderRepository orderRepository;
    private BillingService billingService;
    private ReceiptRepository receiptRepository;
    private ReceiptServiceImpl receiptService;

    @BeforeEach
    public void setup() {
        userRepository = Mockito.mock(UserRepository.class);
        orderRepository = Mockito.mock(OrderRepository.class);
        billingService = Mockito.mock(BillingService.class);
        receiptRepository = Mockito.mock(ReceiptRepository.class);

        receiptService = new ReceiptServiceImpl(billingService, orderRepository,
                userRepository, receiptRepository);
    }

    @Test
    public void shouldNotFoundUser() {
        Mockito.when(userRepository.findById(USER_ID))
                .thenReturn(Optional.empty());

        CreateReceiptDto createReceiptDto = new CreateReceiptDto();
        createReceiptDto.setUserId(USER_ID);
        createReceiptDto.setOrderId(ORDER_ID);

        RuntimeException runtimeException = Assertions.assertThrows(UserNotFoundException.class,
                () -> receiptService.create(createReceiptDto));
        Assertions.assertEquals("User with id 1 not found", runtimeException.getMessage());
    }

    @Test
    public void shouldNotFoundOrder() {
        Mockito.when(userRepository.findById(USER_ID))
                .thenReturn(Optional.of(new User()));

        Mockito.when(orderRepository.findById(ORDER_ID))
                .thenReturn(Optional.empty());

        CreateReceiptDto createReceiptDto = new CreateReceiptDto();
        createReceiptDto.setUserId(USER_ID);
        createReceiptDto.setOrderId(ORDER_ID);

        RuntimeException runtimeException = Assertions.assertThrows(OrderNotFoundException.class,
                () -> receiptService.create(createReceiptDto));
        Assertions.assertEquals("Order with id 1 not found", runtimeException.getMessage());
    }

    @Test
    public void shouldCreateReceipt() {

    }
}
