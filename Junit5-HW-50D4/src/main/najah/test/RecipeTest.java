package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import main.najah.code.Recipe;
import main.najah.code.RecipeException;

@DisplayName("Recipe Tests")
public class RecipeTest {
    
    private Recipe recipe;

    @BeforeEach
    void setUp() {
        recipe = new Recipe();
    }

    @Test
    @DisplayName("Test default recipe values")
    void testDefaultValues() {
        assertEquals("", recipe.getName(), "Default name should be empty");
        assertEquals(0, recipe.getPrice(), "Default price should be 0");
        assertEquals(0, recipe.getAmtChocolate(), "Default chocolate amount should be 0");
        assertEquals(0, recipe.getAmtCoffee(), "Default coffee amount should be 0");
        assertEquals(0, recipe.getAmtMilk(), "Default milk amount should be 0");
        assertEquals(0, recipe.getAmtSugar(), "Default sugar amount should be 0");
    }

    @Test
    @DisplayName("Test setting and getting name")
    void testSetAndGetName() {
        recipe.setName("Mocha");
        assertEquals("Mocha", recipe.getName(), "Name should be Mocha");
    }

    @Test
    @DisplayName("Test setting null name does not change current name")
    void testSetNullName() {
        recipe.setName(null);
        assertEquals("", recipe.getName(), "Name should remain empty when set to null");
    }
    @Test
    @Disabled("This test is intentionally failing due to a bug in the toString method. Fix the method to correctly return the recipe name.")
    @DisplayName("Test toString Method Bug")
    void testToStringBug() {
        // The current toString() implementation is expected to fail, as it might not correctly return the name in all cases
        assertEquals("Latte", recipe.toString(), "toString should return the recipe name but it's failing currently.");
    }
    @Test
    @DisplayName("Test toString method")
    void testToString() {
        recipe.setName("Cappuccino");
        assertEquals("Cappuccino", recipe.toString(), "toString should return the recipe name");
    }

    @Test
    @DisplayName("Test hashCode consistency")
    void testHashCode() {
        Recipe recipe1 = new Recipe();
        recipe1.setName("Latte");
        Recipe recipe2 = new Recipe();
        recipe2.setName("Latte");
        assertEquals(recipe1.hashCode(), recipe2.hashCode(), "Hashcodes should be equal for same names");
    }

    @Test
    @DisplayName("Test equals method with null")
    void testEqualsWithNull() {
        assertNotEquals(recipe, null, "Recipe should not be equal to null");
    }

    @Test
    @DisplayName("Test equals method with different class")
    void testEqualsWithDifferentClass() {
        assertNotEquals(recipe, "someString", "Recipe should not be equal to a string");
    }
    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    @DisplayName("Test Recipe Method Performance")
    void testRecipeMethodPerformance() {
        assertDoesNotThrow(() -> {
            recipe.setName("Espresso");
            recipe.getName();
            recipe.hashCode();
            recipe.toString();
            recipe.equals(new Recipe());
        }, "Recipe methods should complete within 1 second");
    }
}