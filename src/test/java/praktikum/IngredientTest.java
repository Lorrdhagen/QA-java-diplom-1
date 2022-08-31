package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    BunTest bunTest;
    private IngredientType ingredientType;
    private String name;
    private float price;

    public IngredientTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные({index})")
    public static Object[][] getTestData() {
        return new Object[][]{
                {IngredientType.SAUCE, "cheese sauce", 130},
                {IngredientType.FILLING, "cutlet", 200}
        };
    }

    @Test
    public void getPriceReturnsIngredientPrice() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        float actualPrice = ingredient.getPrice();
        assertEquals(price, actualPrice, bunTest.DELTA);
    }

    @Test
    public void getNameReturnsIngredientName() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        String actualName = ingredient.getName();
        assertEquals(name, actualName);
    }

    @Test
    public void getTypeReturnsIngredientType() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        IngredientType actualType = ingredient.getType();
        assertEquals(ingredientType, actualType);
    }
}