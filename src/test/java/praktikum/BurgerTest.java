package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun mockBun;
    @Mock
    Ingredient mockIngridient;

    @Test
    public void setBuns() {
        Burger burger = new Burger();
        String expectedName = "big bun";
        float price = 220f;
        Bun testBun = new Bun(expectedName, price);
        burger.setBuns(testBun);
        String actualName = burger.bun.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    public void addIngredient() {
        Burger burger = new Burger();
        Ingredient expectedIngridient = new Ingredient(IngredientType.FILLING, "long sausage", 200);
        burger.addIngredient(expectedIngridient);
        assertEquals(expectedIngridient, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredient() {
        Burger burger = new Burger();
        burger.ingredients.add(new Ingredient(IngredientType.SAUCE, "super sauce", 150));
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredient() {
        Burger burger = new Burger();
        int expectedIndex = 1;
        Ingredient testIngridient = new Ingredient(IngredientType.SAUCE, "hot sauce", 130);
        burger.ingredients.add(testIngridient);
        burger.ingredients.add(new Ingredient(IngredientType.FILLING, "cutlet", 200));
        burger.moveIngredient(0, 1);
        int actualIndex = burger.ingredients.indexOf(testIngridient);
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void getPrice() {
        Burger burger = new Burger();
        float expectedPrice = 700;
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngridient);
        burger.addIngredient(mockIngridient);
        Mockito.when(mockBun.getPrice()).thenReturn(150f);
        Mockito.when(mockIngridient.getPrice()).thenReturn(200f);
        float actualPrice = burger.getPrice();
        assertEquals(expectedPrice, actualPrice, 0.00f);
    }

    @Test
    public void getReceipt() {
        Burger burger = new Burger();
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngridient);
        burger.addIngredient(mockIngridient);
        Mockito.when(mockBun.getName()).thenReturn("black");
        Mockito.when(mockIngridient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(mockIngridient.getName()).thenReturn("bacon");
        Mockito.when(mockBun.getPrice()).thenReturn(150f);
        Mockito.when(mockIngridient.getPrice()).thenReturn(200f);
        String actualRecipe = burger.getReceipt();
        assertTrue(actualRecipe.contains("= filling bacon =") || actualRecipe.contains("==== black ====") || actualRecipe.contains("Price: 700"));
    }
}