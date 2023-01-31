import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class SharpeningTest {
    private Pencil pencil;
    @Before
    public void setUp() throws Exception {
        pencil = new Pencil(1000, 10);
    }

    @Test
    public void sharpeningTest() throws IOException {
        pencil.write("Wow this pencil is not sharp at all");
        pencil.sharpen();
        assertEquals(1000, pencil.getPtDurability());
    }

    @Test
    public void lengthDecrementTest() throws IOException {
        pencil.write("This here is a GREAT TEST statement to make sure we see the pencil go down down down!");
        pencil.sharpen();
        assertEquals(9, pencil.getLength());
    }
}