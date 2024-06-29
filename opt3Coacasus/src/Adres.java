public class Adres {

    private String straat;
    private int nummer;
    private String postcode;
    private Gemeente gemeente;
    public Adres(String straat, int nummer, String postcode, Gemeente gemeente){
        this.straat = straat;
        this.nummer = nummer;
        this.postcode = postcode;
        this.gemeente = gemeente;
    }

    public Gemeente getGemeente() {
        return gemeente;
    }
    @Override
    public String toString() {
        return straat + " " + nummer + ", " + postcode + " " + gemeente.getNaam();
    }
}
