public class Persoon {
    private int BSN;
    private String voornaam;
    private String achternaam;
    private String geboortedatum;
    private char geslacht;

    public Persoon(int BSN, String voornaam, String achternaam, String geboortedatum, char geslacht) {
        this.BSN = BSN;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
        this.geslacht = geslacht;
    }

    public Persoon() {
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
        return geboortedatum;
    }

    public void setGeboortedatum(String geboortedatum) {
        this.geboortedatum = geboortedatum;
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
}
