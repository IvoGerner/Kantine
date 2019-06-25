package nl.hanze.kantine;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main {
    public static final int DAGEN = 7;

    public static void main(String[] args) {

        int dagen;

        if (args.length == 0) {
            dagen = DAGEN;
        } else {
            dagen = Integer.parseInt(args[0]);
        }


        KantineSimulatie_2 simulatie = new KantineSimulatie_2();
        simulatie.simuleer(dagen);
    }
}
