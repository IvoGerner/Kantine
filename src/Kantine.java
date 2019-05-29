public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;
    private KantineAanbod kantineAanbod;

    /**
     * Constructor
     */
    public Kantine() {
        kassarij = new KassaRij();
        kassa = new Kassa(kassarij);
    }

    public KantineAanbod getKantineAanbod() {
        return kantineAanbod;
    }

    public void setKantineAanbod(KantineAanbod kantineAanbod) {
        this.kantineAanbod = kantineAanbod;
    }

    /**
     * In deze methode wordt een Persoon en Dienblad gemaakt
     * en aan elkaar gekoppeld. Maak twee Artikelen aan
     * en plaats deze op het dienblad. Tenslotte sluit de
     * Persoon zich aan bij de rij voor de kassa.
     */
    public void loopPakSluitAan(Dienblad dienblad, String[] artikelnamen) {

        for (String artiekel : artikelnamen) {
            dienblad.voegToe(kantineAanbod.getArtikel(artiekel));
        }

//        Persoon jan = new Persoon(981263123, "Jan", "Klaas", 2, 5, 1990, 'm');
//        Persoon anja = new Persoon(567123456, "Anja", "Bakker", 4, 8, 2003, 'v');
//        Dienblad dienbladJan = new Dienblad(jan);
//        Dienblad dienbladAnja = new Dienblad(anja);
//        Artikel soep = new Artikel ("Soep", 150);
//        Artikel toasti = new Artikel ("Toasti", 90);
//        dienbladJan.voegToe(soep);
//        dienbladJan.voegToe(toasti);
//        kassarij.sluitAchteraan(dienbladJan);
    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() {
        while(kassarij.erIsEenRij()) {
            kassa.rekenAf(kassarij.eerstePersoonInRij());
        }
    }

    public Kassa getKassa(){
        return kassa;
    }

//    /**
//     * Deze methode telt het geld uit de kassa
//     *
//     * @return hoeveelheid geld in kassa
//     */
//    public double hoeveelheidGeldInKassa() {
//        return kassa.hoeveelheidGeldInKassa();
//    }
//
//    /**
//     * Deze methode geeft het aantal gepasseerde artikelen.
//     *
//     * @return het aantal gepasseerde artikelen
//     */
//    public int aantalArtikelen() {
//        return kassa.aantalArtikelen();
//    }
//
//    /**
//     * Deze methode reset de bijgehouden telling van
//     * het aantal artikelen en "leegt" de inhoud van de kassa.
//     */
//    public void resetKassa() {
//        kassa.resetKassa();
//    }
}