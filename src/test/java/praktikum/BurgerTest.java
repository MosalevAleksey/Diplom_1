package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

//@RunWith(Parameterized.class)
public class BurgerTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

    }
    @Mock
    Bun bun;
    List<Ingredient> ingredients;
    Ingredient ingredient;

/*

    public BurgerTest (Bun bun, List<Ingredient> ingredients) {
        this.bun = bun;
        this.ingredients = ingredients;

    }
    @Parameterized.Parameters

    public static Object[][] checkTest() {
        return new Object[][] {
                { bun , ingredients},

        };
    }
*/


    @Test
    public void setBunsIsSetting() {
        Burger burger= new Burger();
        when(bun.getName()).thenReturn("REX");
        burger.setBuns(bun);

        assertEquals("REX" ,burger.bun.getName());
    }


      @Test
    public void addIngredientIsAdding() {
        Burger burger= new Burger();
          burger.addIngredient(ingredient);

          assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientIsRemoving() {
        Burger burger= new Burger();
        burger.addIngredient(ingredient);

        burger.removeIngredient(burger.ingredients.indexOf(ingredient));
        assertFalse(burger.ingredients.contains(ingredient));

    }

    @Test
    public void moveIngredientIsMoving() {
        Burger burger= new Burger();
        Ingredient ingredient1= new Ingredient(IngredientType.SAUCE, "Chili", (float)859.23);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient);
        int index=burger.ingredients.indexOf(ingredient1);
        int newindex= index+1;

        burger.moveIngredient(index,newindex);

        assertTrue(burger.ingredients.contains(ingredient1));
        assertNull(burger.ingredients.get(index));
        assertEquals(newindex, burger.ingredients.indexOf(ingredient1));

    }

    @Test
    public void getPriceIsCalculete () {
        Burger burger= new Burger();
        Ingredient ingredient1= new Ingredient(IngredientType.SAUCE, "Chili", (float)859.0);


        burger.setBuns(bun);
        burger.ingredients.add(ingredient1);

       // when(ingredient.getPrice()).thenReturn((float) 22.60);
        when(bun.getPrice()).thenReturn((float) 333.50);

        float actual=burger.getPrice();
        assertEquals(1526, actual, 1e-15);

    }

    @Test
    public void getReceiptReturnRecipt() {
        Burger burger= new Burger();
      Ingredient ingredient1= new Ingredient(IngredientType.SAUCE, "Chili", (float)859.0);


        burger.ingredients.add(ingredient1);

        burger.setBuns(bun);
        when(bun.getPrice()).thenReturn((float) 333.50);
        when(bun.getName()).thenReturn("REX");
        String actual= burger.getReceipt();
        String expected= String.format("(==== REX ====)%n= sauce Chili =%n(==== REX ====)%n%nPrice: 1526,000000%n");
        assertEquals(expected, actual);
        //System.out.println(actual);

    }
}