package nl.hanze.kantine;

public class Pinpas extends Betaalwijze {

    private double kredietlimiet;

    /**
     * Methode om kredietlimiet te zetten
     * @param kredietlimiet
     */
    public void setKredietLimiet(double kredietlimiet) {
        this.kredietlimiet = kredietlimiet;
    }

    /**
     * Methode om betaling af te handelen
     */
    public void betaal(double tebetalen) throws TeWeinigGeldException {
        boolean kanBetalen = (tebetalen <= kredietlimiet+saldo);
        if (kanBetalen){
            saldo -= tebetalen;
        } else {
            throw new TeWeinigGeldException();
        }

    }
}
