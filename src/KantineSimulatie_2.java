import java.util.*;

public class KantineSimulatie_2 {

    // kantine
    private Kantine kantine;

    // kantineaanbod
    private KantineAanbod kantineaanbod;

    // random generator
    private Random random;

    // voornamen personen
    private static final String[] voornamen = new String[]
            {"Bob", "Jon", "Ash", "Linda", "Tom", "Rose", "Saffron", "Bert", "Mary"};

    // achternamen personen
    private static final String[] achternamen = new String[]
            {"Dibb", "Ashton", "Martins", "Spencer", "Jonson", "Southwell", "Agar", "Kent", "Ford"};

    // aantal artikelen
    private static final int AANTAL_ARTIKELEN = 4;

    // artikelen
    private static final String[] artikelnamen = new String[]
            {"Koffie", "Broodje pindakaas", "Broodje kaas", "Appelsap"};

    // studierichtingen
    private static final String[] studierichtingen = new String[]
            {"IT", "ET", "ST", "TB", "WI", "EC", "BK", "CI", "BW"};

    // afdelingen
    private static final String[] afdelingen = new String[]
            {"TECH", "TAAL", "GEZ", "MAAT", "KUNS"};

    // prijzen
    private static int[] artikelprijzen = new int[]{150, 210, 165, 165};

    // minimum en maximum aantal artikelen per soort
    private static final int MIN_ARTIKELEN_PER_SOORT = 10;
    private static final int MAX_ARTIKELEN_PER_SOORT = 20;

    // minimum en maximum aantal personen per dag
    private static final int MIN_PERSONEN_PER_DAG = 50;
    private static final int MAX_PERSONEN_PER_DAG = 100;

    // minimum en maximum artikelen per persoon
    private static final int MIN_ARTIKELEN_PER_PERSOON = 1;
    private static final int MAX_ARTIKELEN_PER_PERSOON = 4;

    // Aantal werknemers per kassiere
    private static final int WERKNEMERS_PER_KASSIERE = 3;
    /**
     * Constructor
     */
    public KantineSimulatie_2() {
        kantine = new Kantine();
        random = new Random();
        int[] hoeveelheden = getRandomArray(
                AANTAL_ARTIKELEN,
                MIN_ARTIKELEN_PER_SOORT,
                MAX_ARTIKELEN_PER_SOORT);
        kantineaanbod = new KantineAanbod(
                artikelnamen, artikelprijzen, hoeveelheden);

        kantine.setKantineAanbod(kantineaanbod);
    }

    /**
     * Methode om een array van random getallen liggend tussen
     * min en max van de gegeven lengte te genereren
     *
     * @param lengte
     * @param min
     * @param max
     * @return De array met random getallen
     */
    private int[] getRandomArray(int lengte, int min, int max) {
        int[] temp = new int[lengte];
        for (int i = 0; i < lengte; i++) {
            temp[i] = getRandomValue(min, max);
        }

        return temp;
    }

    /**
     * Methode om een random getal tussen min(incl)
     * en max(incl) te genereren.
     *
     * @param min
     * @param max
     * @return Een random getal
     */
    private int getRandomValue(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * Methode om op basis van een array van indexen voor de array
     * artikelnamen de bijhorende array van artikelnamen te maken
     *
     * @param indexen
     * @return De array met artikelnamen
     */
    private String[] geefArtikelNamen(int[] indexen) {
        String[] artikelen = new String[indexen.length];

        for (int i = 0; i < indexen.length; i++) {
            artikelen[i] = artikelnamen[indexen[i]];

        }

        return artikelen;
    }

    private Persoon maakPersoon(String type){
        Persoon persoon = new Persoon();
        boolean req = true;
        int BSN = getRandomValue(0, 999999999);
        Datum geboortedatum = new Datum();
        // maak persoon en dienblad aan, koppel ze
        //voornamen
        int arrayPos = random.nextInt(voornamen.length);
        String voornaam = voornamen[arrayPos];
        //achternamen
        arrayPos =random.nextInt(achternamen.length);
        String achternaam = achternamen[arrayPos];

        //geboortedatum
        while(req){
            int dag = getRandomValue(1, 31);
            int maand = getRandomValue(1, 12);
            int jaar = getRandomValue(1900, 2100);
            geboortedatum = new Datum(dag, maand, jaar);
            if (geboortedatum.bestaatDatum(dag, maand, jaar)) {
                req = false;
            }
        }

        char geslacht;
        if(random.nextInt(2)==0){
            geslacht = 'm';
        } else {
            geslacht = 'v';
        }
        switch(type) {
            case "student":
                int studentnummer = getRandomValue(10000, 99999);
                arrayPos = random.nextInt(studierichtingen.length);
                String studierichting = studierichtingen[arrayPos];
                persoon = new Student(BSN, voornaam, achternaam, geboortedatum, geslacht, studentnummer, studierichting);
                break;
            case "docent":
                String afkorting = achternaam.substring(0, 2).toUpperCase() + voornaam.substring(0, 2).toUpperCase();
                arrayPos = random.nextInt(afdelingen.length);
                String afdeling = afdelingen[arrayPos];
                persoon = new Docent(BSN, voornaam, achternaam, geboortedatum, geslacht, afkorting, afdeling);
                break;
            case "kantinemedewerker":
                boolean kassa = false;
                if (random.nextInt(WERKNEMERS_PER_KASSIERE + 1) <= 1) {
                    kassa = true;
                }
                int medewerkersnummer = getRandomValue(10, 99);
                persoon = new Kantinemedewerker(BSN, voornaam, achternaam, geboortedatum, geslacht, medewerkersnummer, kassa);
                break;
        }
        return persoon;
    }

    /**
     * Deze methode simuleert een aantal dagen
     * in het verloop van de kantine
     *
     * @param dagen
     */
    public void simuleer(int dagen) {
        // for lus voor dagen
        for(int i = 0; i < dagen; i++) {

            // bedenk hoeveel personen vandaag binnen lopen
            int aantalpersonen = getRandomValue(MIN_PERSONEN_PER_DAG, MAX_PERSONEN_PER_DAG) ;

            // laat de personen maar komen...
            for(int j = 0; j < aantalpersonen; j++) {
                int randomNummer = random.nextInt(100);
                String type;
                if (randomNummer<89){
                    type = "student";
                }
                else if (randomNummer<99){
                    type = "docent";
                } else {
                    type = "kantinemedewerker";
                }
//                System.out.println(maakPersoon(type).toString());
                Dienblad dienblad = new Dienblad(maakPersoon(type));
                // en bedenk hoeveel artikelen worden gepakt
                int aantalartikelen = getRandomValue(MIN_ARTIKELEN_PER_PERSOON, MAX_ARTIKELEN_PER_PERSOON) ;

                // genereer de "artikelnummers", dit zijn indexen
                // van de artikelnamen
                int[] tepakken = getRandomArray(
                    aantalartikelen, 0, AANTAL_ARTIKELEN-1);

                // vind de artikelnamen op basis van
                // de indexen hierboven
                String[] artikelen = geefArtikelNamen(tepakken);


                // loop de kantine binnen, pak de gewenste
                // artikelen, sluit aan
                kantine.loopPakSluitAan(dienblad, artikelen);

            }

            // verwerk rij voor de kassa
            kantine.verwerkRijVoorKassa();
            // druk de dagtotalen af en hoeveel personen binnen

            // zijn gekomen
            System.out.println("Na dag " + (i+1) + " is het dagtotaal: " + kantine.getKassa().hoeveelheidGeldInKassa() + ". Aantal verkochte artikelen: " + kantine.getKassa().aantalArtikelen());
            // reset de kassa voor de volgende dag
            kantine.getKassa().resetKassa();
        }
    }
}