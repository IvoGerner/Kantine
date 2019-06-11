public class Kantinemedewerker extends Persoon {

    private int medewerkersnummer;
    private boolean kassa;

    public Kantinemedewerker (int BSN, String voornaam, String achternaam, Datum geboortedatum, char geslacht, int medewerkersnummer, boolean kassa){
        super(BSN, voornaam, achternaam, geboortedatum, geslacht);
        this.medewerkersnummer = medewerkersnummer;
        this.kassa = kassa;
    }

    public int getMedewerkersnummer() {
        return medewerkersnummer;
    }

    public void setMedewerkersnummer(int medewerkersnummer) {
        this.medewerkersnummer = medewerkersnummer;
    }

    public boolean isKassa() {
        return kassa;
    }

    public void setKassa(boolean kassa) {
        this.kassa = kassa;
    }

    @Override
    public String toString() {
        return "Kantinemedewerker{" +
                "medewerkersnummer=" + medewerkersnummer +
                ", kassa=" + kassa +
                '}';
    }
}
