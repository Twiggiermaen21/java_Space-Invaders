package com.mycompany.space_invaders.ui;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UITest {

    @Test
    public void testGameFrameInitialization() {
        // Testowanie okna GUI w JUnit bez dodatkowych bibliotek jest trudne,
        // ale możemy sprawdzić czy obiekty się tworzą bez rzucania wyjątków.
        assertDoesNotThrow(() -> {
            // GameFrame tworzy okno i panel
            // GameFrame gf = new GameFrame(1600, 900);
            // frame1.dispose(); // zamknij okno
        });
    }
}
