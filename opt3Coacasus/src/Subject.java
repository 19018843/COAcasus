public interface Subject {

    void addObservers(Observer observer);

    void notifyObservers(String bericht);
}
