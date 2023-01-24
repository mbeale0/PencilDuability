import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    private Main mainClass;
    @Before
    public void setUp() throws Exception {
        mainClass = new Main();
        mainClass.ptDurability = 50;
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

    @Test
    public void degradationDuringWritingTest() throws IOException {
        mainClass.write("15 non spaces long");
        assertEquals(35, mainClass.ptDurability);
    }

    @Test
    public void uppercaseLettersDegradesProperlyTest() throws IOException {
        mainClass.write("CAPITAL");
        assertEquals(36, mainClass.ptDurability);
    }

    @Test
    public void lowercaseLettersDegradesProperlyTest() throws IOException {
        mainClass.write("lower!?");
        assertEquals(43, mainClass.ptDurability);
    }

    @Test
    public void stopWritingAfterDegradationTest() throws IOException {
        mainClass.write("Boy I sure do love my new pencil, I really hope it lasts forever");

        assertEquals("Boy I sure do love my new pencil, I really hope it lasts for    ", mainClass.journal);
    }
}