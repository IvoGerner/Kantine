public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Datum datum = new Datum();
        datum.bestaatDatum(31,1,1999);
        datum.bestaatDatum(31,2,1999);
        datum.bestaatDatum(29,2,1999);
        datum.bestaatDatum(29,2,2000);
        datum.bestaatDatum(31,6,1999);
        datum.bestaatDatum(31,7,1999);

//        datum.getDagenFebruari(1900);
//        datum.getDagenFebruari(1904);
//        datum.getDagenFebruari(1923);
//        datum.getDagenFebruari(2000);
//        datum.getDagenFebruari(2100);
    }
}
