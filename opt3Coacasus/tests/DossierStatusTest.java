import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DossierStatusTest {

    @Test
    public void test1() {
        assertEquals("geplaatst", Dossier.getDossierStatus(true, "geen", true, true));
    }

    @Test
    public void test2() {
        assertEquals("geen asiel", Dossier.getDossierStatus(false, "geen", false, false));
    }

    @Test
    public void test3() {
        assertEquals("geplaatst", Dossier.getDossierStatus(true, "verblijfsvergunning", true, true));
    }

    @Test
    public void test4() {
        assertEquals("verblijfsvergunning", Dossier.getDossierStatus(false, "verblijfsvergunning", false, false));
    }

    @Test
    public void test5() {
        assertEquals("in procedure", Dossier.getDossierStatus(true, "gestart", true, true));
    }

    @Test
    public void test6() {
        assertEquals("geen asiel", Dossier.getDossierStatus(false, "gestart", false, false));
    }

}
