package nl.hanze.kantine;

public class Artikel {

    private int prijs;
    private String naam;
    private double korting;

    public Artikel(String naam, int prijs){
        this.naam = naam;
        this.prijs = prijs;
        korting = 0;
    }

    public Artikel(String naam, int prijs, double korting){
        this.naam = naam;
        this.prijs = prijs;
        this.korting = korting;
    }

    public Artikel(){
        naam = "N/A";
        prijs = 0;
        korting = 0;
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

    @Override
    public String toString() {
        return "Artikel{" +
                "prijs=" + prijs +
                ", naam='" + naam + '\'' +
                '}';
    }

    public double getKorting() {
        return korting;
    }

    public void setKorting(double korting) {
        this.korting = korting;
    }
}
