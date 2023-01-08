package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


public class BunTest {


    Bun bun =new Bun("Briosh", (float) 22366.12);

    @Test
    public void getNameReturn () throws Exception {

        assertEquals("Briosh", bun.getName());
    }

    @Test
    public void getPriceReturn () throws Exception {

        assertEquals((float)22366.12, bun.getPrice(),1e-15);


    }
}