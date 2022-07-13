package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void checkIngridientTypeContainsSauce() {
        String expectedType = "SAUCE";
        IngredientType actualType = IngredientType.SAUCE;
        assertEquals(expectedType, actualType.toString());
    }

    @Test
    public void checkIngridientTypeContainsFilling() {
        String expectedType = "FILLING";
        IngredientType actualType = IngredientType.FILLING;
        assertEquals(expectedType, actualType.toString());
    }
}