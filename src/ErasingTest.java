import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ErasingTest {
    private Pencil pencil;
    @BeforeEach
    void setUp() throws IOException {
        pencil = new Pencil(1000, 10);
    }
}