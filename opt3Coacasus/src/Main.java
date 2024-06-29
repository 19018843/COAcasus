import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Gemeente denhaag = new Gemeente("Den Haag", 552000, 2000);
        Land nederland = new Land("Nederland", true);
        Land rusland = new Land("Rusland", false);

        Adres dhAdres1 = new Adres("Kleiweg", 15, "2521 ZN", denhaag);
        Adres dhAdres2 = new Adres("Janstraat", 19, "2562 BW", denhaag);

        AZC azcEscamp = new AZC("AZC Escamp", dhAdres1);
        AZC azcLoosduinen = new AZC("AZC Loosduinen", dhAdres2);
        Kamer kamer = new Kamer();
        Dossier Pietdossier = new Dossier(true, "verblijfsvergunning", false, true);
        Dossier Jeffdossier = new Dossier(false, "geen", false, false);
        Asielzoeker Piet = new Asielzoeker("Piet Schout", "man", 30, nederland, Pietdossier);
        Asielzoeker Jeff = new Asielzoeker("Jeff Rezo", "man", 42, rusland, Jeffdossier);

        Kamer minderjarigKamer = new Kamer();
        Kamer volwasseKamer = new Kamer();
        Kamer ouderKamer = new Kamer();

        ArrayList<Land> landen = new ArrayList<>();
        ArrayList<Gemeente> gemeentes = new ArrayList<>();
        ArrayList<AZC> azcs = new ArrayList<>();
        ArrayList<Asielzoeker> asielzoekers = new ArrayList<>();
        ArrayList<Bericht> berichten = new ArrayList<>();

        landen.add(nederland);
        landen.add(rusland);
        gemeentes.add(denhaag);
        azcs.add(azcEscamp);
        azcs.add(azcLoosduinen);
        asielzoekers.add(Piet);
        asielzoekers.add(Jeff);

        Beheerder beheerder = new Beheerder(landen, gemeentes, azcs);
        COAmedewerker COAmedewerker = new COAmedewerker(landen, asielzoekers, azcs);
        COAmedewerker.addObservers(azcEscamp);
        COAmedewerker.addObservers(azcLoosduinen);
        AZCmedewerker azcmedewerker = new AZCmedewerker(berichten);
        COAmedewerker.addObservers(azcmedewerker);

        Userchecker uc = new Userchecker(beheerder, COAmedewerker, azcmedewerker, asielzoekers);
        uc.start();
    }
}