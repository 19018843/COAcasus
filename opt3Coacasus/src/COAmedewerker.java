import java.util.ArrayList;
import java.util.Scanner;

public class COAmedewerker extends Gebruiker implements Subject {
    private ArrayList<Observer> observers = new ArrayList<>();
    private ArrayList<Land> landen;
    private ArrayList<Asielzoeker> asielzoekers;
    private ArrayList<AZC> azcs;
    private ArrayList<Bericht> berichten = new ArrayList<>();
    public COAmedewerker(ArrayList<Land> landen, ArrayList<Asielzoeker> asielzoekers, ArrayList<AZC> azcs) {
        this.landen = landen;
        this.asielzoekers = asielzoekers;
        this.azcs = azcs;
    }
    @Override
    protected void toonMenu() {
        System.out.println("COA-medewerker acties:");
        System.out.println("1. Registreer nieuwe asielzoeker");
        System.out.println("2. Asielzoeker vertrek naar land van herkomst");
        System.out.println("0. Terug");
    }

    @Override
    protected boolean verwerkMenu(int keuze, Scanner scanner) {
        if (keuze == 1) {
            registreerAsielzoeker(scanner);
        } else if (keuze == 2) {
             registreerVertrekNaarHerkomstland();
        } else if (keuze == 0) {
            return false;
        } else {
            System.out.println("Ongeldige keuze. Probeer opnieuw.");
        }
        return true;
    }

    public boolean checkAsielzoeker(String naam, String gender, String landVanHerkomstNaam) {

        if (!gender.equalsIgnoreCase("man") && !gender.equalsIgnoreCase("vrouw")) {
            return false;
        }

        Land landVanHerkomst = null;
        for (Land land : landen) {
            if (land.getNaam().equalsIgnoreCase(landVanHerkomstNaam)) {
                landVanHerkomst = land;
                break;
            }
        }
        if (landVanHerkomst == null) {
            return false;
        }
        for (Asielzoeker a : asielzoekers) {
            if (a.getNaam().equalsIgnoreCase(naam) && a.getLandVanHerkomst().equals(landVanHerkomst)) {
                return false;
            }
        }
        return true;
    }

    public boolean registreerAsielzoeker(Scanner scanner) {
        System.out.println("Registreer een nieuwe vluchteling:");
        System.out.print("Naam: ");
        String naam = scanner.nextLine().trim();

        System.out.print("Leeftijd: ");
        int leeftijd = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Geslacht (man/vrouw): ");
        String gender = scanner.nextLine().trim();

        System.out.print("Land van herkomst: ");
        String landVanHerkomstNaam = scanner.nextLine().trim();

        if (!checkAsielzoeker(naam, gender, landVanHerkomstNaam)) {
            System.out.println("Onjuiste gegevens of de vluchteling is al geregistreerd.");
            return false;
        }
        Land landVanHerkomst = null;
        for (Land land : landen) {
            if (land.getNaam().equalsIgnoreCase(landVanHerkomstNaam)) {
                landVanHerkomst = land;
                break;
            }
        }
        System.out.println("Kan de asielzoeker een paspoort tonen? (ja/nee)");
        boolean paspoortGetoond = scanner.nextLine().trim().equalsIgnoreCase("ja");


        Dossier dossier;
        if (paspoortGetoond) {
            dossier = new Dossier(false, "geen", false, false);
        } else {
            dossier = null;
        }

        Asielzoeker nieuweAsielzoeker = new Asielzoeker(naam, gender, leeftijd, landVanHerkomst, dossier);
        asielzoekers.add(nieuweAsielzoeker);

        System.out.println("Asielzoeker succesvol geregistreerd.");
        return true;
    }

    public void registreerVertrekNaarHerkomstland() {
        System.out.println("Voer de naam in van de asielzoeker die vertrekt naar het land van herkomst:");
        String naam = scanner.nextLine().trim();

        Asielzoeker vertrekkendeAsielzoeker = null;

        // check naam
        for (Asielzoeker a : asielzoekers) {
            if (a.getNaam().equalsIgnoreCase(naam)) {
                vertrekkendeAsielzoeker = a;
                break;
            }
        }
        if (vertrekkendeAsielzoeker == null) {
            System.out.println("Geen asielzoeker gevonden met de naam " + naam);
            return;
        }
        // Update dossier van de asielzoeker
        vertrekkendeAsielzoeker.getDossier().setTeruggekeerdNaarHerkomstland(true);
        String berichtInhoud = "Vertrek van " + vertrekkendeAsielzoeker.getNaam() + " naar land van herkomst.";
        Bericht bericht = new Bericht(berichtInhoud);

        berichten.add(bericht);

        // Stuur bericht naar alle AZCs
        notifyObservers(berichtInhoud);

        System.out.println("Vertrek geregistreerd voor " + vertrekkendeAsielzoeker.getNaam());
    }

    @Override
    public void notifyObservers(String bericht) {
        for (Observer observer : observers) {
            observer.update(bericht);
        }
    }
    @Override
    public void addObservers(Observer observer) {
        observers.add(observer);

    }

}
