package nl.hanze.kantine;

import java.time.LocalDate;
import java.util.Iterator;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Kassa {

    private KassaRij kassarij;
    private int geldinkassa;
    private int verkochteartikelen;
    private LocalDate datum;
    private EntityManager manager;

    /**
     * Constructor
     */

    public Kassa(){

    }


    public Kassa(KassaRij kassarij) {
        this.kassarij = kassarij;
        geldinkassa = 0;
        verkochteartikelen = 0;
    }

    public Kassa(KassaRij kassarij, EntityManager manager){
        this.kassarij = kassarij;
        geldinkassa = 0;
        verkochteartikelen = 0;
        this.manager = manager;
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
        datum = LocalDate.of(2019, 5, 16);
        Factuur factuur = new Factuur(klant, datum);
        Betaalwijze betaalwijze = klant.getKlant().getBetaalwijze();

        EntityTransaction transaction = null;
        try {
            // Get a transaction, sla de factuur gegevens op en commit de transactie
            transaction = manager.getTransaction();
            transaction.begin();
            manager.persist(factuur);
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }

//        if (!betaalwijze.betaal(factuur.getTotaal())) {
//            System.out.println("De klant kan niet betalen.");
//        } else {
//            geldinkassa += (int) ((factuur.getTotaal()) * 100);
//            verkochteartikelen += getAantalArtikelen(klant.getArtikel());
//        }
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