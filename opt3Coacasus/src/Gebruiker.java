import java.util.Scanner;

abstract class Gebruiker{
    Scanner scanner = new Scanner(System.in);
    boolean running = true;

    public void start() {
        while (running) {
            toonMenu();
            if (scanner.hasNextInt()) {
                int keuze = scanner.nextInt();
                scanner.nextLine();
                running = verwerkMenu(keuze, scanner);
            } else {
                System.out.println("Ongeldige keuze. Probeer opnieuw.");
                scanner.nextLine();
            }
        }
    }

    protected abstract void toonMenu();
    protected abstract boolean verwerkMenu(int keuze, Scanner scanner);
}

