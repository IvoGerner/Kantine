public class Main {

    public static final int DAGEN = 7;

    public static void main(String[] args) {
//        new Testor();
        KantineSimulatie_1 simulatie = new KantineSimulatie_1();
        int dagen;

        if (args.length == 0) {
            dagen = DAGEN;
        } else {
            dagen = Integer.parseInt(args[0]);
        }
        simulatie.simuleer(dagen);
    }
}
