package pl.dominisz.springintroduction.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.dominisz.springintroduction.dto.CreateReceiptDto;
import pl.dominisz.springintroduction.exception.UserNotFoundException;
import pl.dominisz.springintroduction.repository.UserRepository;

import java.util.Optional;

/**
 * http://dominisz.pl
 * 25.05.2019
 */
public class Junit5ReceiptServiceImplTest {

    private final long USER_ID = 1;
    private final long ORDER_ID = 1;

    private final UserRepository userRepository = Mockito.mock(UserRepository.class);

    @Test
    public void shouldNotFoundUser() {
        Mockito.when(userRepository.findById(USER_ID))
                .thenReturn(Optional.empty());

        ReceiptServiceImpl receiptService =
                new ReceiptServiceImpl(null, null, userRepository, null);

        CreateReceiptDto createReceiptDto = new CreateReceiptDto();
        createReceiptDto.setUserId(USER_ID);
        createReceiptDto.setOrderId(ORDER_ID);

        RuntimeException runtimeException = Assertions.assertThrows(UserNotFoundException.class,
                () -> receiptService.create(createReceiptDto));
        Assertions.assertEquals("User with id 1 not found", runtimeException.getMessage());
    }

    @Test
    public void shouldNotFoundOrder() {

    }

    @Test
    public void shouldCreateReceipt() {

    }
}
