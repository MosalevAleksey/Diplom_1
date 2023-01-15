package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class IngredientTest {

    Ingredient ingredient;
    boolean result;
    public IngredientTest (Ingredient ingredient,boolean result) {
        this.ingredient = ingredient;
        this.result=result;
    }
    @Parameterized.Parameters

    public static Object[][] checkTest() {
        return new Object[][] {
                { new Ingredient(IngredientType.SAUCE, "Chili", (float)859.23), true},
                { new Ingredient(IngredientType.FILLING, "cutlet", 1003), false},


        };
    }




    @Test
    public void getPriceReturn () throws Exception {

       // assertTrue(result, assertEquals((float) 859.23, ingredient.getPrice(), 1e-15));
        //assertEquals((float) 859.23, ingredient.getPrice(), 1e-15);
        var actual=((float) 859.23==ingredient.getPrice());
        Assert.assertEquals(result,actual);

    }

    @Test
    public void getNameReturn () throws Exception {

        var actual=ingredient.getName().equals("Chili");
        Assert.assertEquals(result,actual);
    }

    @Test
    public void getTypeReturn () throws Exception {

        var actual=ingredient.getType().toString().equals("SAUCE");
        Assert.assertEquals(result,actual);
    }
}