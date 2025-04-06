package main.najah.test;

import main.najah.code.Recipe;
import main.najah.code.RecipeBook;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

@DisplayName("RecipeBook Tests")
public class RecipeBookTest {
    private RecipeBook recipeBook;
    private Recipe recipe;

    @BeforeEach
    void setUp() {
        recipeBook = new RecipeBook();
        recipe = new Recipe();
        recipe.setName("Espresso");
    }

    @Test
    @DisplayName("Test Adding Recipe")
    void testAddRecipe() {
        assertTrue(recipeBook.addRecipe(recipe));
    }

    @Test
    @DisplayName("Test Deleting Recipe")
    void testDeleteRecipe() {
        recipeBook.addRecipe(recipe);
        assertNotNull(recipeBook.deleteRecipe(0));
    }
    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    @DisplayName("Test Adding Recipe Performance")
    void testAddRecipePerformance() {
        assertDoesNotThrow(() -> recipeBook.addRecipe(recipe), "Adding a recipe should complete within 1 second");
    }
}