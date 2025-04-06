package main.najah.test;

import main.najah.code.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
@DisplayName("Calculator Tests")
public class CalculatorTest {
    private Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Starting Calculator tests");
    }

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @Order(1)
    @DisplayName("Test Addition")
    void testAddition() {
        assertEquals(10, calculator.add(5, 5));
        assertEquals(0, calculator.add()); // No arguments case
        assertEquals(-5, calculator.add(-2, -3));
        assertEquals(5, calculator.add(5)); // Single number case
        assertEquals(15, calculator.add(1, 2, 3, 4, 5)); // Multiple numbers case
    }

    @Test
    @Order(2)
    @DisplayName("Test Subtraction")
    void testSubtraction() {
        assertEquals(5, calculator.subtract(10, 5));
        assertEquals(-5, calculator.subtract(5, 10));
        assertEquals(0, calculator.subtract(7, 7));
    }

    @Test
    @Order(3)
    @DisplayName("Test Division")
    void testDivision() {
        assertEquals(2, calculator.divide(10, 5));
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }

    @ParameterizedTest
    @CsvSource({"0,1", "1,1", "5,120", "7,5040"})
    @Order(4)
    @DisplayName("Test Factorial with Parameters")
    void testFactorial(int input, int expected) {
        assertEquals(expected, calculator.factorial(input));
    }

    @Test
    @Order(5)
    @DisplayName("Test Factorial Edge Cases")
    void testFactorialEdgeCases() {
        assertEquals(1, calculator.factorial(1)); // Testing factorial of 1
        assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-5)); // Negative input
    }

    @Test
    @Order(6)
    @Timeout(1)
    @DisplayName("Test Factorial Timeout")
    void testTimeout() {
        assertDoesNotThrow(() -> calculator.factorial(10));
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test complete");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Calculator tests complete");
    }
}