import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Dienblad {
    private ArrayList<Artikel> artikelen;
    private Persoon klant;

    /**
     * Constructor
     */
    public Dienblad(Persoon klant){
        this.klant = klant;
        artikelen = new ArrayList<>();
    }

    public Dienblad() {
        klant = new Persoon();
        artikelen = new ArrayList<>();
    }

    /**
     * Methode om artikel aan dienblad toe te voegen
     *
     * @param artikel
     */
    public void voegToe(Artikel artikel) {
        artikelen.add(artikel);
    }

    /**
     * Methode om aantal artikelen op dienblad te tellen
     *
     * @return Het aantal artikelen
     */
    public int getAantalArtikelen() {
        return artikelen.size();
    }

    /**
     * Methode om de totaalprijs van de artikelen
     * op dienblad uit te rekenen
     *
     * @return De totaalprijs
     */
    public double getTotaalPrijs() {
        int totaal = 0;
        for (Artikel artikel: artikelen){
            totaal += artikel.getPrijs();
        }
        return (double)totaal/100;
    }

    public Persoon getKlant() {
        return klant;
    }

    public void setKlant(Persoon klant) {
        this.klant = klant;
    }
}

