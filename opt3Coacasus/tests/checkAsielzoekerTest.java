import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class checkAsielzoekerTest {

    private COAmedewerker coaMedewerker;
    private ArrayList<Land> landen;
    private ArrayList<Asielzoeker> asielzoekers;
    private ArrayList<AZC> azcs;

    @BeforeEach
    public void setUp() {
        Land nederland = new Land("Nederland", true);
        Land rusland = new Land("Rusland", false);

        landen = new ArrayList<>();
        landen.add(nederland);
        landen.add(rusland);

        Dossier Pietdossier = new Dossier(true, "verblijfsvergunning", false, true);
        Dossier Jeffdossier = new Dossier(true, "geen", false, true);
        Asielzoeker Piet = new Asielzoeker("Piet Schout", "man", 30, nederland, Pietdossier);
        Asielzoeker Jeff = new Asielzoeker("Jeff Rezo", "man", 42, rusland, Jeffdossier);

        asielzoekers = new ArrayList<>();
        asielzoekers.add(Piet);
        asielzoekers.add(Jeff);

        azcs = new ArrayList<>();
        coaMedewerker = new COAmedewerker(landen, asielzoekers, azcs);
    }

    @Test
    public void test101() {
        // 1: nieuw asielzoeker, onjuiste gender, juiste land
        assertFalse(coaMedewerker.checkAsielzoeker("Nieuw Persoon", "invalidGender", "Nederland"));
    }

    @Test
    public void test110() {
        // 2: nieuw asielzoeker, juiste gender, onjuiste land
        assertFalse(coaMedewerker.checkAsielzoeker("Nieuw Persoon", "vrouw", "InvalidLand"));
    }

    @Test
    public void test011() {
        // 3: Al bestaande asielzoeker, juist gender, bestaande land
        assertFalse(coaMedewerker.checkAsielzoeker("Piet Schout", "man", "Nederland"));
    }

    @Test
    public void test111() {
        // 4: nieuw asielzoeker, juist gender, bestaande land
        assertTrue(coaMedewerker.checkAsielzoeker("Nieuw Persoon", "vrouw", "Nederland"));
    }
}

