package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import main.najah.code.Product;

public class ProductTest {
    
    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product("Laptop", 1000);
    }

    @Test
    @DisplayName("Test Price Calculation After Discount")
    void testPriceCalculation() {
        product.applyDiscount(10); // 10% discount on 1000 should be 900
        assertEquals(900, product.getFinalPrice(), "Price after applying 10% discount should be 900");
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, 10, 50})
    @DisplayName("Test Valid Discount Application")
    void testValidDiscounts(double discount) {
        assertDoesNotThrow(() -> product.applyDiscount(discount), "Valid discounts should not throw exceptions");
    }

    @Test
    @DisplayName("Test Invalid Discount Greater than 50%")
    void testInvalidDiscount() {
        assertThrows(IllegalArgumentException.class, () -> product.applyDiscount(60), 
            "Applying a discount greater than 50% should throw an exception");
    }

    @Test
    @DisplayName("Test Negative Discount Throws Exception")
    void testNegativeDiscount() {
        assertThrows(IllegalArgumentException.class, () -> product.applyDiscount(-5), 
            "Applying a negative discount should throw an exception");
    }
    @Test
    @DisplayName("Check Product Name is Not Empty")
    void testProductNameNotEmpty() {
        Product product = new Product("Laptop", 1000.0);
        assertFalse(product.getName().isEmpty());
    }
    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    @DisplayName("Test Discount Calculation Performance")
    void testDiscountPerformance() {
        assertDoesNotThrow(() -> product.applyDiscount(10), "Applying discount should complete within 1 second");
    }
}