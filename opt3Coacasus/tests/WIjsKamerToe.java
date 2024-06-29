import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class WIjsKamerToe {

Kamer minderjarigKamer = new Kamer();
Kamer volwasseKamer = new Kamer();
Kamer ouderKamer = new Kamer();
    @Test
    public void testMinderjarigeKamer() {
        assertEquals("Minderjarige kamer", minderjarigKamer.wijsKamerToe(0));
        assertEquals("Minderjarige kamer", minderjarigKamer.wijsKamerToe(17));
    }

    @Test
    public void testVolwasseneKamer() {
        assertEquals("Volwassene kamer", volwasseKamer.wijsKamerToe(18));
        assertEquals("Volwassene kamer", volwasseKamer.wijsKamerToe(64));
    }

    @Test
    public void testOuderenKamer() {
        assertEquals("Ouderen kamer", ouderKamer.wijsKamerToe(65));
        assertEquals("Ouderen kamer", ouderKamer.wijsKamerToe(100));
    }
}

