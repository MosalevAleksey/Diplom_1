package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {
    private Bun bun = new Bun("Briosh", (float) 22366.12);

    @Test
    public void getNameReturn() throws Exception {
        assertEquals("Briosh", bun.getName());
    }

    @Test
    public void getPriceReturn() throws Exception {
        assertEquals((float) 22366.12, bun.getPrice(), 1e-15);
    }
}