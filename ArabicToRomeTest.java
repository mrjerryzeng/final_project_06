import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArabicToRomeTest {
    private ArabicToRome ar;
    @BeforeEach
    void setUp() {
        ar = new ArabicToRome();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void PC() {
        String Trq = ar.change("666");
        assertEquals("DCLXVI", Trq);
        String Frq = ar.change("4000001");
        assertEquals("Please input number around 1~3999999.", Frq);
    }

    @Test
    void CC(){
        String TTFrq = ar.change("4000001");
        assertEquals("Please input number around 1~3999999.", TTFrq);
        String FFTrq = ar.change("-0.5");
        assertEquals("Please input integer.", FFTrq);
    }

    @Test
    void CACC_A(){
        String Trq = ar.change("123");
        assertEquals("CXXIII", Trq);
        String Frq = ar.change("123.1");
        assertEquals("Please input integer.", Frq);
    }

    @Test
    void CACC_B(){
        String Trq = ar.change("123");
        assertEquals("CXXIII", Trq);
        String Frq = ar.change("-1");
        assertEquals("Please input number around 1~3999999.", Frq);
    }

    @Test
    void CACC_C(){
        String Trq = ar.change("123");
        assertEquals("CXXIII", Trq);
        String Frq = ar.change("4000001");
        assertEquals("Please input number around 1~3999999.", Frq);
    }
}
