public class Kamer {
    private int capaciteit;
    private String soort;


    public String wijsKamerToe(int leeftijd) {
        if (leeftijd < 18) {
            return "Minderjarige kamer";
        } else if (leeftijd >= 18 && leeftijd < 65) {
            return "Volwassene kamer";
        } else {
            return "Ouderen kamer";
        }
    }

}
