package praktikum;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    public Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient1;

    @Mock
    private Ingredient ingredient2;

    @Mock
    private Ingredient ingredient3;


    @Before
    public void setUp() {
        burger = new Burger();

        when(bun.getName()).thenReturn("black bun");
        when(bun.getPrice()).thenReturn(100F);

        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient1.getName()).thenReturn("chili sauce");
        when(ingredient1.getPrice()).thenReturn(300F);

        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getName()).thenReturn("cutlet");
        when(ingredient2.getPrice()).thenReturn(100F);

        when(ingredient3.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient3.getName()).thenReturn("sausage");
        when(ingredient3.getPrice()).thenReturn(300F);
    }


    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals("Неверное название булочки", bun.getName(), burger.bun.getName());
    }

    @Test
    public void addIngredientRightAmountTest() {
        burger.addIngredient(ingredient1);
        assertEquals("В бургер было добавлено " + burger.ingredients.size() + " ингредиентов", 1, burger.ingredients.size());
    }

    @Test
    public void addRightIngredientTest() {
        burger.addIngredient(ingredient1);
        assertTrue("Ингридиент не был добавлен в бургер", burger.ingredients.contains(ingredient1));
    }

    @Test
    public void removeIngredientTest() {
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        burger.ingredients.add(ingredient3);
        burger.removeIngredient(2);
        assertEquals("Из бургера не был убран ингредиент", 2, burger.ingredients.size());
    }

    @Test
    public void removeRightIngredientTest() {
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        burger.ingredients.add(ingredient3);
        burger.removeIngredient(2);
        List<Ingredient> expected = List.of(ingredient1, ingredient2);
        assertTrue("Из бургера был убран неверный ингридиент", burger.ingredients.containsAll(expected));
    }

    @Test
    public void moveIngredientToNewPlaceTest() {
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        burger.ingredients.add(ingredient3);
        burger.moveIngredient(1, 0);
        assertEquals("Ингридиент не был перемещён на новое место", burger.ingredients.get(0), ingredient2);
    }

    @Test
    public void moveIngredientFromOldPlaceTest() {
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        burger.ingredients.add(ingredient3);
        burger.moveIngredient(1, 0);
        assertEquals("Ингридиент не был перемещён со старого места", burger.ingredients.get(1), ingredient1);
    }

    @Test
    public void getPriceTest() {
        burger.bun = bun;
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        burger.ingredients.add(ingredient3);

        float expectedPrice = bun.getPrice() * 2 + ingredient1.getPrice() + ingredient2.getPrice() + ingredient3.getPrice();

        assertEquals("Ожидалась итоговая цена " + expectedPrice + ", но была получена " + burger.getPrice(), expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        burger.bun = bun;
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        burger.ingredients.add(ingredient3);

        String actualReceipt = burger.getReceipt();
        String expectedReceipt = "(==== black bun ====)\r\n" +
                "= sauce chili sauce =\r\n" +
                "= filling cutlet =\r\n" +
                "= filling sausage =\r\n" +
                "(==== black bun ====)\r\n" +
                "\r\n" +
                "Price: 900,000000\r\n";

        assertEquals("Получен чек неверного вида", expectedReceipt, actualReceipt);
    }

}
