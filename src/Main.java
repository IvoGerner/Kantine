
public class Main {

    public static final int DAGEN = 7;

    public static void main(String[] args) {
//        new Testor2();
        new Testor();
        KantineSimulatie_2 simulatie = new KantineSimulatie_2();
        int dagen;

        if (args.length == 0) {
            dagen = DAGEN;
        } else {
            dagen = Integer.parseInt(args[0]);
        }
        simulatie.simuleer(dagen);
    }
}
