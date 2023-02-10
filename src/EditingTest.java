import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class EditingTest {
    private Pencil pencil;
    @Before
    public void setUp() throws IOException {
        pencil = new Pencil(1000, 10, 10);
    }

    @Test
    public void basicEditingTest() throws IOException {
        pencil.write("I am a junior in college");
        pencil.erase("junior");
        pencil.edit("senior", 1);
        assertEquals("I am a senior in college", pencil.getJournal());
    }

    

    @Test
    public void collisionTest() throws IOException {
        pencil.write("Bacon is the most best thing ever");
        pencil.erase("best");
        pencil.edit("awesome", 1);
        assertEquals("Bacon is the most aweso@@ing ever", pencil.getJournal());
    }
}