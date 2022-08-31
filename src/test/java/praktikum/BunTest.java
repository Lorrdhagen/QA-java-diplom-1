package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    public final float DELTA = 0.00f;

    @Test
    public void getNameReturnsBunName() {
        String expectedName = "big bun";
        float price = 150;
        Bun bun = new Bun(expectedName, price);
        String actualName = bun.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    public void getPriceReturnsBunPrice() {
        String name = "black bun";
        float expectedPrice = 135;
        Bun bun = new Bun(name, expectedPrice);
        float actualPrice = bun.getPrice();
        assertEquals(expectedPrice, actualPrice, DELTA);
    }
}