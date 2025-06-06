package praktikum;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private IngredientType type;
    private String name;
    private float price;
    Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Ингридиент {1} типа {0}, цена - {2}")
    public static Object[][] setTestData() {
        return new Object[][]{
                {IngredientType.FILLING, "hot sauce", 100.0F},
                {IngredientType.FILLING, "sour cream", 200.0F},
                {IngredientType.FILLING, "chili sauce", 300.0F},
                {IngredientType.SAUCE, "cutlet", 100.0F},
                {IngredientType.SAUCE, "dinosaur", 200.0F},
                {IngredientType.SAUCE, "sausage", 300.0F},
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getPriceTest() {
        float actualPrice = ingredient.getPrice();
        assertEquals("Ожидаемая цена ингридиента: " + price + ", но была получена цена: " + actualPrice, price, actualPrice,0);
    }

    @Test
    public void getNameTest() {
        String actualName = ingredient.getName();
        assertEquals("Ожидаемое имя ингридиента: " + name + ", но было получено имя: " + actualName, name, actualName);
    }

    @Test
    public void getTypeTest() {
        IngredientType actualType = ingredient.getType();
        assertEquals("Ожидаемый тип ингридиента: " + type + ", но был получен тип: " + actualType, type, actualType);
    }

}
