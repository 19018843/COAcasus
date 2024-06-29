import java.util.ArrayList;

public class Gemeente {
    private String naam;
    private int aantalInwoners;
    private int beschikbarePlaatsen;

    public Gemeente(String naam, int aantalInwoners, int beschikbarePlaatsen) {
        this.naam = naam;
        this.aantalInwoners = aantalInwoners;
        this.beschikbarePlaatsen = beschikbarePlaatsen;
    }

    public String getNaam() {
        return naam;
    }

    public int getAantalInwoners() {
        return aantalInwoners;
    }

    public int getBeschikbarePlaatsen() {
        return beschikbarePlaatsen;
    }

    public float getPlaatsingsPercentage() {
        return 0.0F;
    }
}