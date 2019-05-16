public class Persoon {
    private int BSN;
    private String voornaam;
    private String achternaam;
    private Datum geboortedatum;
    private char geslacht;


    public Persoon(int BSN, String voornaam, String achternaam, int geboortedag, int geboortemaand, int geboortejaar, char geslacht) {
        this();
        this.BSN = BSN;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        setGeslacht(geslacht);
        geboortedatum = new Datum(geboortedag, geboortemaand, geboortejaar);
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
        this.BSN = BSN;
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
        if (geslacht == 'm' || geslacht == 'v') {
            this.geslacht = geslacht;
        } else {
            this.geslacht = 'o';
        }
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
