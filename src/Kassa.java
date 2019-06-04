import java.util.Iterator;

public class Kassa {

    private KassaRij kassarij;
    private int geldinkassa;
    private int verkochteartikelen;

    /**
     * Constructor
     */
    public Kassa(KassaRij kassarij) {
        this.kassarij = kassarij;
        geldinkassa = 0;
        verkochteartikelen = 0;
    }

    public Kassa(){

    }

    /**
     * Vraag het aantal artikelen en de totaalprijs op.
     * Tel deze gegevens op bij de controletotalen die voor
     * de kassa worden bijgehouden. De implementatie wordt
     * later vervangen door een echte betaling door de persoon.
     *
     * @param klant die moet afrekenen
     */
    public void rekenAf(Dienblad klant) {
        geldinkassa += (int)(getTotaalPrijs(klant.getArtikel())*100);
        verkochteartikelen += getAantalArtikelen(klant.getArtikel());
    }

    public double getTotaalPrijs(Iterator<Artikel> artikelIterator){
        int totaal = 0;
        while (artikelIterator.hasNext()){
            totaal += artikelIterator.next().getPrijs();
        }
        return (double)totaal/100;
    }

    public int getAantalArtikelen(Iterator<Artikel> artikelIterator){
        int totaal = 0;
        while(artikelIterator.hasNext()){
            artikelIterator.next();
            totaal++;
        }
        return totaal;
    }

    /**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd,
     * vanaf het moment dat de methode resetWaarden is aangeroepen.
     *
     * @return aantal artikelen
     */
    public int aantalArtikelen() {
        return verkochteartikelen;
        // method body omitted
    }

    /**
     * Geeft het totaalbedrag van alle artikelen die de kass
     * zijn gepasseerd, vanaf het moment dat de methode
     * resetKassa is aangeroepen.
     *
     * @return hoeveelheid geld in de kassa
     */
    public double hoeveelheidGeldInKassa() {
        return (double)geldinkassa/100;

        // method body omitted
    }

    /**
     * reset de waarden van het aantal gepasseerde artikelen en
     * de totale hoeveelheid geld in de kassa.
     */
    public void resetKassa() {
        verkochteartikelen = 0;
        geldinkassa = 0;
        // method body omitted
    }
}