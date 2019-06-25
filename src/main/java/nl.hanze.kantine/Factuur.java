package nl.hanze.kantine;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "factuur")
public class Factuur implements Serializable {
    @Id
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
        double totaal = 0;
        double korting = 0;
        Artikel artikel = klant.getArtikel().next();
        if (artikel.getKorting() > 0) {
            korting = artikel.getKorting();
            totaal = artikel.getPrijs() - korting;
            artikelKorting = true;
        } else {
            totaal = artikel.getPrijs();
        }
//        geldinkassa += (int)(getTotaalPrijs(klant.getArtikel())*100);
//        verkochteartikelen += getAantalArtikelen(klant.getArtikel());
        if (klant.getKlant() instanceof KortingskaartHouder && !artikelKorting) {
            KortingskaartHouder kortingPersoon = (KortingskaartHouder) klant.getKlant();
            korting = totaal * kortingPersoon.geefKortingsPercentage();
            if (kortingPersoon.heeftMaximum() && korting > kortingPersoon.geefMaximum()) {
                korting = kortingPersoon.geefMaximum();
            }
            totaal -= korting;
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
