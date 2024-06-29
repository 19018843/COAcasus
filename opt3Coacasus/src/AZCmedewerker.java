import java.util.ArrayList;
import java.util.Scanner;

public class AZCmedewerker extends Gebruiker implements Observer {

    private ArrayList<Bericht> berichten;
    public AZCmedewerker(ArrayList<Bericht> berichten) {
        this.berichten = berichten;
    }
    @Override
    protected void toonMenu() {
        System.out.println("\nKies een optie:");
        System.out.println("1. Toon niet verwerkte berichten");
        System.out.println("0. Terug");
    }

    @Override
    protected boolean verwerkMenu(int keuze, Scanner scanner) {
        if (keuze == 1) {
            toonBerichten();
        } else if (keuze == 0) {
            return false;
        } else {
            System.out.println("Ongeldige keuze. Probeer opnieuw.");
        }
        return true;
    }

    public void toonBerichten() {
        if (berichten.isEmpty()) {
            System.out.println("Geen niet verwerkte berichten beschikbaar.");
        } else {
            System.out.println("Niet verwerkte berichten:");
            for (Bericht bericht : berichten) {
                System.out.println("- " + bericht.getInhoud());
            }
        }
    }
    @Override
    public void update(String bericht) {
        Bericht nieuwBericht = new Bericht(bericht);
        berichten.add(nieuwBericht);
    }
}

