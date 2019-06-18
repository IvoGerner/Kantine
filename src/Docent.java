public class Docent extends Persoon implements KortingskaartHouder{

    private String afkorting;
    private String afdeling;

    public Docent (int BSN, String voornaam, String achternaam, Datum geboortedatum, char geslacht, String afkorting, String afdeling){
        super(BSN, voornaam, achternaam, geboortedatum, geslacht);
        this.afkorting = afkorting;
        this.afdeling = afdeling;
    }

    public String getAfkorting() {
        return afkorting;
    }

    public void setAfkorting(String afkorting) {
        this.afkorting = afkorting;
    }

    public String getAfdeling() {
        return afdeling;
    }

    public void setAfdeling(String afdeling) {
        this.afdeling = afdeling;
    }

    @Override
    public String toString() {
        return "Docent{" +
                "afkorting='" + afkorting + '\'' +
                ", afdeling='" + afdeling + '\'' +
                '}';
    }

    @Override
    public double geefKortingsPercentage() {
        return 0.25;
    }

    @Override
    public boolean heeftMaximum() {
        return true;
    }

    @Override
    public double geefMaximum() {
        return 1;
    }
}
