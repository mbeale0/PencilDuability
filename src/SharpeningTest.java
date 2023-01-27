import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class SharpeningTest {
    private Pencil pencil;
    @Before
    public void setUp() throws Exception {
        pencil = new Pencil(1000);
    }

    @Test
    public void sharpeningTest() throws IOException {
        pencil.write("Wow this pencil is not sharp at all");
        pencil.sharpen();
        assertEquals(1000, pencil.getPtDurability());
    }
}