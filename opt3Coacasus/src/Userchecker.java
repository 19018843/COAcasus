import java.util.ArrayList;
import java.util.Scanner;

public class Userchecker {
    private Beheerder beheerder;
    private COAmedewerker COAmedewerker;
    private AZCmedewerker azcmedewerker;
    private ArrayList<Asielzoeker> asielzoekers;

    public Userchecker(Beheerder beheerder, COAmedewerker COAmedewerker, AZCmedewerker azcmedewerker, ArrayList<Asielzoeker> asielzoekers) {
        this.beheerder = beheerder;
        this.COAmedewerker = COAmedewerker;
        this.azcmedewerker = azcmedewerker;
        this.asielzoekers = asielzoekers;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean doorgaan = true;

        System.out.println("Welkom bij het COA-systeem!");

        while (doorgaan) {
            System.out.println("\nKies gebruikerstype:");
            System.out.println("1. Beheerder");
            System.out.println("2. COA-medewerker");
            System.out.println("3. Asielzoeker");
            System.out.println("4. AZC-medewerker");
            System.out.println("0. Stoppen");

            int keuze = scanner.nextInt();
            scanner.nextLine();

            if (keuze == 1) {
                beheerder.start();
            } else if (keuze == 2) {
                COAmedewerker.start();
            } else if (keuze == 3) {
                AsielzoekerStart();
            } else if (keuze == 4) {
                azcmedewerker.start();
            } else if (keuze == 0) {
                doorgaan = false;
                System.out.println("Programma afgesloten.");
            } else {
                System.out.println("Ongeldige keuze. Probeer opnieuw.");
            }
        }
        scanner.close();
    }

    private void AsielzoekerStart() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Voer uw volledige naam in:");
        String naam = scanner.nextLine();
        Asielzoeker asielzoeker = null;

        for (Asielzoeker a : asielzoekers) {
            if (a.getNaam().equals(naam)) {
                asielzoeker = a;
                break;
            }
        }

        if (asielzoeker == null) {
            System.out.println("Geen gegevens bekend voor deze naam.");
        } else {
            asielzoeker.toonMenu();
            int keuze = scanner.nextInt();
            scanner.nextLine();

            asielzoeker.verwerkMenu(keuze, scanner);
        }
    }
}