import java.util.Scanner;

public class Asielzoeker extends Gebruiker {
    private String naam;
    private String gender;
    private int leeftijd;
    private Land landVanHerkomst;
    private Dossier dossier;


    public Asielzoeker(String naam, String gender, int leeftijd, Land landVanHerkomst, Dossier dossier) {
        this.naam = naam;
        this.gender = gender;
        this.leeftijd = leeftijd;
        this.landVanHerkomst = landVanHerkomst;
        this.dossier = dossier;
    }

    @Override
    protected void toonMenu() {
        System.out.println("\nKies actie:");
        System.out.println("1. Toon dossier");
        System.out.println("0. Terug");
    }

    @Override
    protected boolean verwerkMenu(int keuze, Scanner scanner) {
        if (keuze == 1) {
            toonDossier();
        } else if (keuze == 0) {
            return false;
        } else {
            System.out.println("Ongeldige keuze. Probeer opnieuw.");
        }
        return true;
    }

    public void toonDossier() {
        if (dossier != null) {
            System.out.println("Asielaanvraag is afgerond: " + (dossier.isAsielaanvraagAfgerond() ? "ja" : "nee"));
            System.out.println("Uitspraak IND: " + dossier.getUitspraakIND());
            System.out.println("Plaatsing in eigen woning: " + (dossier.isInEigenWoning() ? "ja" : "nee"));
            System.out.println("Teruggekeerd naar land van herkomst: " + (dossier.isTeruggekeerdNaarHerkomstland() ? "ja" : "nee"));
        } else {
            System.out.println("Geen dossier gevonden voor deze asielzoeker.");
        }
    }
    public String getNaam() {
        return naam;
    }

    public Land getLandVanHerkomst() {
        return landVanHerkomst;
    }
    public Dossier getDossier() {
        return dossier;
    }
}




