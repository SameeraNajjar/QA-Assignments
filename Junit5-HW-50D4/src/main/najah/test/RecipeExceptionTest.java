package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import main.najah.code.RecipeException;

@DisplayName("RecipeException Tests")
public class RecipeExceptionTest {

    @Test
    @DisplayName("Test RecipeException message retrieval")
    void testRecipeExceptionMessage() {
        String expectedMessage = "Test exception message";
        RecipeException exception = new RecipeException(expectedMessage);
        assertEquals(expectedMessage, exception.getMessage(), "Exception message should match the expected value");
    }

@Test
@Timeout(value = 1, unit = TimeUnit.SECONDS)
@DisplayName("Test RecipeException Performance")
void testRecipeExceptionPerformance() {
    assertDoesNotThrow(() -> {
        RecipeException exception = new RecipeException("Test exception message");
        exception.getMessage();
    }, "Creating and retrieving the exception message should complete within 1 second");
}
}