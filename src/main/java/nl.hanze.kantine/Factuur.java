package nl.hanze.kantine;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.spi.AbstractResourceBundleProvider;

@Entity
@Table(name = "factuur")
public class Factuur implements Serializable {
    @Id
    @GeneratedValue
    @Column(name ="id", unique = true)
    private Long id;

    @Column(name = "date", nullable = false)
    private LocalDate datum;

    @Column(name = "korting", nullable = false)
    private double korting;

    @Column(name = "totaal", nullable = false)
    private double totaal;


    public Factuur(){
        totaal = 0;
        korting = 0;
    }

    public Factuur(Dienblad klant, LocalDate datum){
        this();
        this.datum = datum;

        verwerkBestelling(klant);
    }

    private void verwerkBestelling(Dienblad klant){
        boolean artikelKorting = false;
        double kortingArtikel;
        double localTotaal = 0;
        double localKorting = 0;
        Iterator<Artikel> iter = klant.getArtikel();
        Artikel artikel = klant.getArtikel().next();
        while (iter.hasNext()) {
            if (artikel.getKorting() > 0) {
                localKorting = artikel.getKorting();
                localTotaal = (double) artikel.getPrijs() / 100 - localKorting;
                artikelKorting = true;
            } else {
                localTotaal = (double) artikel.getPrijs() / 100;
            }
//        geldinkassa += (int)(getTotaalPrijs(klant.getArtikel())*100);
//        verkochteartikelen += getAantalArtikelen(klant.getArtikel());
            if (klant.getKlant() instanceof KortingskaartHouder && !artikelKorting) {
                KortingskaartHouder kortingPersoon = (KortingskaartHouder) klant.getKlant();
                localKorting = localTotaal * kortingPersoon.geefKortingsPercentage();
                if (kortingPersoon.heeftMaximum() && localKorting > kortingPersoon.geefMaximum()) {
                    localKorting = kortingPersoon.geefMaximum();
                }
                localTotaal -= localKorting;
            }
            totaal += localTotaal;
            korting += localKorting;
            iter.next();
        }
    }


    public double getKorting() {
        return korting;
    }


    public double getTotaal() {
        return totaal;
    }

    @Override
    public String toString() {
        return "Factuur{" +
                "id=" + id +
                ", datum=" + datum +
                ", korting=" + korting +
                ", totaal=" + totaal +
                '}';
    }
}
