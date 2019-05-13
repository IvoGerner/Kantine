public class Artikel {

    private int prijs;
    private String naam;

    public Artikel(String naam, int prijs){
        this.naam = naam;
        this.prijs = prijs;
    }

    public Artikel(){
        naam = "N/A";
        prijs = 0;
    }

    public int getPrijs() {
        return prijs;
    }

    public void setPrijs(int prijs) {
        this.prijs = prijs;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}
