package nl.hanze.kantine;

public class Student extends Persoon {

    private int studentnummer;
    private String studierichting;

    public Student (int BSN, String voornaam, String achternaam, Datum geboortedatum, char geslacht, int studentnummer, String studierichting, Betaalwijze betaalwijze){
        super(BSN, voornaam, achternaam, geboortedatum, geslacht, betaalwijze);
        this.studentnummer = studentnummer;
        this.studierichting = studierichting;
    }

    public int getStudentnummer() {
        return studentnummer;
    }

    public void setStudentnummer(int studentnummer) {
        this.studentnummer = studentnummer;
    }

    public String getStudierichting() {
        return studierichting;
    }

    public void setStudierichting(String studierichting) {
        this.studierichting = studierichting;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentnummer=" + studentnummer +
                ", studierichting='" + studierichting + '\'' +
                '}';
    }
}
