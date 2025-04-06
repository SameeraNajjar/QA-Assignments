package main.najah.test;

import main.najah.code.UserService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

@DisplayName("UserService Tests")
@Execution(ExecutionMode.CONCURRENT)
public class UserServiceTest {
    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

    @ParameterizedTest
    @CsvSource({"user@example.com, true", "invalidemail, false"})
    @DisplayName("Test Email Validation")
    void testEmailValidation(String email, boolean expected) {
        assertEquals(expected, userService.isValidEmail(email));
    }

    @Test
    @DisplayName("Test Authentication")
    void testAuthentication() {
        assertTrue(userService.authenticate("admin", "1234"));
        assertFalse(userService.authenticate("user", "wrong"));
    }

    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    @DisplayName("Test Authentication Performance")
    void testAuthenticationPerformance() {
        assertDoesNotThrow(() -> {
            userService.authenticate("admin", "1234");
            userService.authenticate("user", "wrong");
        }, "Authentication should complete within 1 second");
    }

    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    @DisplayName("Test Email Validation Performance")
    void testEmailValidationPerformance() {
        assertDoesNotThrow(() -> {
            userService.isValidEmail("user@example.com");
            userService.isValidEmail("invalidemail");
        }, "Email validation should complete within 1 second");
    }
}