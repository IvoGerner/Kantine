public class Contant extends Betaalwijze {
    /**
     * Methode om betaling af te handelen
     */
    public boolean betaal(double tebetalen) {
        boolean kanBetalen = (tebetalen <= saldo);
        if (kanBetalen){
            saldo -= tebetalen;
        }
        return kanBetalen;
    }
}