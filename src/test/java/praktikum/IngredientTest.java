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
import static org.mockito.Mockito.when;


public class IngredientTest {

   Ingredient ingredient= new Ingredient(IngredientType.SAUCE, "Chili", (float)859.23);



    @Test
    public void getPriceReturn () throws Exception {

        assertEquals((float) 859.23, ingredient.getPrice(), 1e-15);

    }

    @Test
    public void getNameReturn () throws Exception {

        Assert.assertEquals("Chili", ingredient.getName());
    }

    @Test
    public void getTypeReturn () throws Exception {

        Assert.assertEquals("SAUCE", ingredient.getType().toString());
    }
}