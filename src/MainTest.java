import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    private Main mainClass;
    @Before
    public void setUp() throws Exception {
        mainClass = new Main();
    }

    @Test
    public void writingTest() throws IOException {
        mainClass.write("Test Statement");
        assertEquals("Test Statement", mainClass.journal);
    }

    @Test
    public void appendingTest() throws IOException {
        mainClass.write("Test Statement");
        mainClass.write(" And the appended statement");
        assertEquals("Test Statement And the appended statement", mainClass.journal);
    }
}