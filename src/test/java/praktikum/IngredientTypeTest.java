package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private String expectedType;
    private IngredientType actualType;

    public IngredientTypeTest(String expectedType, IngredientType actualType) {
        this.expectedType = expectedType;
        this.actualType = actualType;
    }

    @Parameterized.Parameters(name = "Тестовые данные({index})")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"SAUCE", IngredientType.SAUCE},
                {"FILLING", IngredientType.FILLING}
        };
    }

    @Test
    public void checkIngridientTypeContainsSauce() {
        assertEquals(expectedType, actualType.toString());
    }
}