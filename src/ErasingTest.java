import org.junit.Test;
import org.junit.Before;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ErasingTest {
    private Pencil pencil;
    @Before
    public void setUp() throws IOException {
        pencil = new Pencil(1000, 10, 15);
    }

    @Test
    public void erasingWordTest() throws IOException {
        pencil.write("I need thgy to erase wrong words!");
        pencil.erase("thgy");
        assertEquals("I need      to erase wrong words!", pencil.getJournal());
    }

    @Test
    public void erasingSameWordTwiceTest() throws IOException {
        pencil.write("I need thgy to erase thgy wrong words!");
        pencil.erase("thgy");
        pencil.erase("thgy");
        assertEquals("I need      to erase      wrong words!", pencil.getJournal());
    }


    @Test
    public void erasingDiffWordsTwiceTest() throws IOException {
        pencil.write("I need thgy to erase chicken wrong words!");
        pencil.erase("thgy");
        pencil.erase("chicken");
        assertEquals("I need      to erase         wrong words!", pencil.getJournal());
    }
}