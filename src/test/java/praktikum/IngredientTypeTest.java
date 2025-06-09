package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    public static final String SAUCE = "SAUCE";
    public static final String FILLING = "FILLING";

    @Test
    public void sauceTest() {
        assertEquals(
                String.format("Ожидаемый тип ингредиента %s, но был получен %s", SAUCE, IngredientType.SAUCE),
                SAUCE,
                IngredientType.SAUCE.toString());
    }


    @Test
    public void fillingTest() {
        assertEquals(
                String.format("Ожидаемый тип ингредиента %s, но был получен %s", FILLING, IngredientType.FILLING),
                FILLING,
                IngredientType.FILLING.toString());
    }

}
