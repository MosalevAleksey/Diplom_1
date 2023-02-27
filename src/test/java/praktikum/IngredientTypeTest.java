package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;


public class IngredientTypeTest {

    @Test
    public void valuesOf() {
        assertEquals("FILLING", IngredientType.FILLING.toString());
        assertEquals("SAUCE", IngredientType.SAUCE.toString());
    }


}