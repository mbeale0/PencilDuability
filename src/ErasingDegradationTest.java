import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ErasingDegradationTest {
    private Pencil pencil;
    @Before
    public void setUp() throws Exception {
        pencil = new Pencil(50, 10, 10);
    }

    @Test
    public void eraserDegradesTest() throws IOException {
        pencil.write("Hello");
        pencil.erase("Hello");
        assertEquals(5, pencil.getEraserDurability());
    }

}