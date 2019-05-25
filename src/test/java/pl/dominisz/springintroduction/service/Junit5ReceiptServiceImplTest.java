package pl.dominisz.springintroduction.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.dominisz.springintroduction.dto.CreateReceiptDto;
import pl.dominisz.springintroduction.exception.OrderNotFoundException;
import pl.dominisz.springintroduction.exception.UserNotFoundException;
import pl.dominisz.springintroduction.model.CreditCard;
import pl.dominisz.springintroduction.model.Order;
import pl.dominisz.springintroduction.model.User;
import pl.dominisz.springintroduction.repository.OrderRepository;
import pl.dominisz.springintroduction.repository.ReceiptRepository;
import pl.dominisz.springintroduction.repository.UserRepository;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * http://dominisz.pl
 * 25.05.2019
 */
public class Junit5ReceiptServiceImplTest {

    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String NUMBER = "123567890";
    private static final LocalDate EXPIRY_DATE = LocalDate.of(2020, 1, 1);

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

    private CreateReceiptDto createCreateReceiptDto() {
        CreateReceiptDto createReceiptDto = new CreateReceiptDto();
        createReceiptDto.setUserId(USER_ID);
        createReceiptDto.setOrderId(ORDER_ID);
        return createReceiptDto;
    }

    private User createUser() {
        User user = new User();
        user.setId(USER_ID);
        user.setCreditCard(new CreditCard(FIRST_NAME, LAST_NAME, NUMBER, EXPIRY_DATE));
        return user;
    }

    @Test
    public void shouldNotFoundUser() {
        when(userRepository.findById(USER_ID))
                .thenReturn(Optional.empty());

        RuntimeException runtimeException = assertThrows(UserNotFoundException.class,
                () -> receiptService.create(createCreateReceiptDto()));
        assertEquals("User with id 1 not found", runtimeException.getMessage());
    }

    @Test
    public void shouldNotFoundOrder() {
        when(userRepository.findById(USER_ID)).thenReturn(Optional.of(createUser()));
        when(orderRepository.findById(ORDER_ID)).thenReturn(Optional.empty());

        RuntimeException runtimeException = assertThrows(OrderNotFoundException.class,
                () -> receiptService.create(createCreateReceiptDto()));
        assertEquals("Order with id 1 not found", runtimeException.getMessage());
    }

    @Test
    public void shouldCreateReceipt() {

    }
}
