package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient1;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsIsSetting() {
        when(bun.getName()).thenReturn("REX");
        burger.setBuns(bun);
        assertEquals("REX", burger.bun.getName());
    }

    @Test
    public void addIngredientIsAdding() {
        burger.addIngredient(ingredient);
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientIsRemoving() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(burger.ingredients.indexOf(ingredient));
        assertFalse(burger.ingredients.contains(ingredient));
    }

    @Test
    public void moveIngredientIsMoving() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient1);
        burger.moveIngredient(0, 2);
        assertEquals(ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void getPriceIsCalculete() {
        when(bun.getPrice()).thenReturn((float) 333.50);
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        when(ingredient.getPrice()).thenReturn(859.0F);
        float actual = burger.getPrice();
        assertEquals(1526, actual, 0);
    }

    @Test
    public void getReceiptReturnRecipt() {
        burger.ingredients.add(ingredient);
        when(ingredient.getType()).thenReturn(SAUCE);
        when(ingredient.getName()).thenReturn("Chili");
        when(ingredient.getPrice()).thenReturn(859.0F);
        burger.setBuns(bun);
        when(bun.getPrice()).thenReturn((float) 333.50);
        when(bun.getName()).thenReturn("REX");
        String actual = burger.getReceipt();
        String expected = String.format("(==== REX ====)%n= sauce Chili =%n(==== REX ====)%n%nPrice: 1526,000000%n");
        assertEquals(expected, actual);


    }
}