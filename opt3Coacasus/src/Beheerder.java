import java.util.ArrayList;
import java.util.Scanner;
public class Beheerder extends Gebruiker {
    private ArrayList<Land> landen;
    private ArrayList<Gemeente> gemeentes;
    private ArrayList<AZC> azcs;

    public Beheerder( ArrayList<Land> landen, ArrayList<Gemeente> gemeentes, ArrayList<AZC> azcs) {
        this.landen = landen;
        this.gemeentes = gemeentes;
        this.azcs = azcs;
    }
    @Override
    protected void toonMenu() {
        System.out.println("Beheerder acties:");
        System.out.println("1. Bekijk rapport voor de directeur van COA");
        System.out.println("2. Bekijk overzicht van landen");
        System.out.println("0. Terug");
    }
    @Override
    protected boolean verwerkMenu(int keuze, Scanner scanner) {
        if (keuze == 1) {
            toonRapport();
        } else if (keuze == 2) {
            toonLanden();
        } else if (keuze == 0) {
            return false;
        } else {
            System.out.println("Ongeldige keuze. Probeer opnieuw.");
        }
        return true;
    }

    public void toonRapport() {
        System.out.println("Rapport voor de directeur van COA:");
        for (Gemeente gemeente : gemeentes) {
            System.out.println("Gemeente: " + gemeente.getNaam());
            System.out.println("Aantal inwoners: " + gemeente.getAantalInwoners());
            System.out.println("Beschikbare plaatsen: " + gemeente.getBeschikbarePlaatsen());
            System.out.println("Plaatsingspercentage: " + gemeente.getPlaatsingsPercentage());
            System.out.println("AZC's:");
            for (AZC azc : azcs) {
                if (azc.getAdres().getGemeente().equals(gemeente)) {
                    System.out.println("- " + azc.getNaam() + " (" + azc.getAdres().toString() + ")");
                }
            }
            System.out.println();
        }
    }

    public void toonLanden() {
        System.out.println("Overzicht landen:");
        for (Land land : landen) {
            System.out.println("- " + land.getNaam() + " (Veilig: " + land.isVeilig() + ")");
        }
    }

}