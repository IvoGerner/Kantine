package nl.hanze.kantine;

public class Persoon {
    private int BSN;
    private String voornaam;
    private String achternaam;
    private Datum geboortedatum;
    private char geslacht;
    private Betaalwijze betaalwijze;


    public Persoon(int BSN, String voornaam, String achternaam, Datum geboortedatum, char geslacht, Betaalwijze betaalwijze) {
        this();
        setBSN(BSN);
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        setGeslacht(geslacht);
        this.geboortedatum = geboortedatum;
        setBetaalwijze(betaalwijze);
    }

    public Persoon() {
        BSN = 0;
        voornaam = "";
        achternaam = "";
        geboortedatum = new Datum(0,0,0);
        geslacht = 'o';
    }

    public int getBSN() {
        return BSN;
    }

    public void setBSN(int BSN) {
        if (BSN == 0){
            this.BSN = 0;
        } else {
            this.BSN = BSN;
        }
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getGeboortedatum() {
        return geboortedatum.getDatumAsString();
    }

    public void setGeboortedatum(int geboortedag, int geboortemaand, int geboortejaar) {
        geboortedatum.setDag(geboortedag);
        geboortedatum.setMaand(geboortemaand);
        geboortedatum.setJaar(geboortejaar);
    }

    public String getGeslacht() {
        if (geslacht == 'm'){
            return "Man";
        }
        else if (geslacht == 'v') {
            return "Vrouw";
        } else {
            return "Onbekend";
        }
    }

    public void setGeslacht(char geslacht) {
        geslacht = Character.toUpperCase(geslacht);
        if (geslacht == 'M' || geslacht == 'V') {
            this.geslacht = geslacht;
        } else {
            this.geslacht = 'o';
        }
    }

    public Betaalwijze getBetaalwijze() {
        return betaalwijze;
    }

    public void setBetaalwijze(Betaalwijze betaalwijze) {
        this.betaalwijze = betaalwijze;
    }

    @Override
    public String toString() {
        return "Persoon{" +
                "BSN=" + BSN +
                ", voornaam='" + voornaam + '\'' +
                ", achternaam='" + achternaam + '\'' +
                ", geboortedatum=" + geboortedatum +
                ", geslacht=" + geslacht +
                '}';
    }
}
