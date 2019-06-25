package nl.hanze.kantine;

public class Contant extends Betaalwijze {
    /**
     * Methode om betaling af te handelen
     */
    public void betaal(double tebetalen) throws TeWeinigGeldException{
        boolean kanBetalen = (tebetalen <= saldo);
        if (kanBetalen){
            saldo -= tebetalen;
        } else {
            throw new TeWeinigGeldException();
        }

    }
}