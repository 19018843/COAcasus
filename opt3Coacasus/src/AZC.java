import java.util.ArrayList;

public class AZC implements Observer{
    private String naam;
    private Adres adres;
    private ArrayList<Kamer> kamers = new ArrayList<>();
    private ArrayList<Bericht> berichten = new ArrayList<>();

    public AZC(String naam, Adres adres) {
        this.naam = naam;
        this.adres = adres;
    }

    public String getNaam() {
        return naam;
    }

    public Adres getAdres() {
        return adres;
    }

    public String getKamer(int leeftijd) {
        return null;
    }

    @Override
    public void update(String bericht) {
        System.out.println("Bericht ontvangen in berichtenbox "+ naam);
        Bericht nieuwBericht = new Bericht(bericht);
        berichten.add(nieuwBericht);
    }


}