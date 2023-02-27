package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {

    Ingredient ingredient;
    boolean result;

    public IngredientTest(Ingredient ingredient, boolean result) {
        this.ingredient = ingredient;
        this.result = result;
    }

    @Parameterized.Parameters(name = "Проверка методов класса Ingredient. Тестовые данные: 1)Chili, (float) 859.23), true} 2)cutlet, 1003), false},")
    public static Object[][] checkTest() {
        return new Object[][]{
                {new Ingredient(IngredientType.SAUCE, "Chili", (float) 859.23), true},
                {new Ingredient(IngredientType.FILLING, "cutlet", 1003), false},
        };
    }

    @Test
    public void getPriceReturn() throws Exception {
        var actual = ((float) 859.23 == ingredient.getPrice());
        Assert.assertEquals(result, actual);
    }

    @Test
    public void getNameReturn() throws Exception {
        var actual = ingredient.getName().equals("Chili");
        Assert.assertEquals(result, actual);
    }

    @Test
    public void getTypeReturn() throws Exception {
        var actual = ingredient.getType().toString().equals("SAUCE");
        Assert.assertEquals(result, actual);
    }
}