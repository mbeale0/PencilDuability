import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    private Pencil pencil;
    @Before
    public void setUp() throws Exception {
        pencil = new Pencil(50);
    }

    @Test
    public void writingTest() throws IOException {
        pencil.write("Test Statement");
        assertEquals("Test Statement", pencil.getJournal());
    }

    @Test
    public void appendingTest() throws IOException {
        pencil.write("Test Statement");
        pencil.write(" And the appended statement");
        assertEquals("Test Statement And the appended statement", pencil.getJournal());
    }

    @Test
    public void degradationDuringWritingTest() throws IOException {
        pencil.write("15 non spaces long");
        assertEquals(35, pencil.getPtDurability());
    }

    @Test
    public void uppercaseLettersDegradesProperlyTest() throws IOException {
        pencil.write("CAPITAL");
        assertEquals(36, pencil.getPtDurability());
    }

    @Test
    public void lowercaseLettersDegradesProperlyTest() throws IOException {
        pencil.write("lower!?");
        assertEquals(43, pencil.getPtDurability());
    }

    @Test
    public void stopWritingAfterDegradationTest() throws IOException {
        pencil.write("Boy I sure do love my new pencil, I really hope it lasts forever");

        assertEquals("Boy I sure do love my new pencil, I really hope it lasts for    ", pencil.getJournal());
    }
}