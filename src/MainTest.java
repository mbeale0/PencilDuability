import org.junit.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    public void writingTest() throws IOException {
        Main.write("Test Statement");
        assertEquals("Test Statement", Main.journal);
    }
}