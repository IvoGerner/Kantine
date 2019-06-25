package nl.hanze.kantine;

import java.util.ArrayList;
import java.util.LinkedList;

public class KassaRij {

    private LinkedList<Dienblad> kassaRij;

    /**
     * Constructor
     */
    public KassaRij() {
        kassaRij = new LinkedList<>();
    }

    /**
     * Persoon sluit achter in de rij aan
     *
     * @param klant
     */
    public void sluitAchteraan(Dienblad klant) {
        kassaRij.add(klant);
    }

    /**
     * Indien er een rij bestaat, de eerste klant uit
     * de rij verwijderen en retourneren.
     * Als er niemand in de rij staat geeft deze null terug.
     *
     * @return Eerste klant in de rij of null
     */
    public Dienblad eerstePersoonInRij() {
        Dienblad klant = null;
        if (erIsEenRij()){
            klant = kassaRij.get(0);
            kassaRij.remove(0);
        }
        return klant;
    }

    /**
     * Methode kijkt of er personen in de rij staan.
     *
     * @return Of er wel of geen rij bestaat
     */
    public boolean erIsEenRij() {
        return (kassaRij.size()>0);
    }
}