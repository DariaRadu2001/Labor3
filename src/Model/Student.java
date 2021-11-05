package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student extends Person {

    private long studentID;
    private int totalKredits;
    private List<Kurs> angeschriebeneKurse;

    public Student(String vorname, String nachname, long studentID) {
        super(vorname, nachname);
        this.studentID = studentID;
        this.totalKredits = 0;
        this.angeschriebeneKurse = new ArrayList<>();
    }


    public long getStudentID() {
        return studentID;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public int getTotalKredits() {
        return totalKredits;
    }

    public void setTotalKredits(int totalKredits) {
        this.totalKredits = totalKredits;
    }

    public List<Kurs> getAngeschriebeneKurse() {
        return angeschriebeneKurse;
    }

    public void setAngeschriebeneKurse(List<Kurs> angeschriebeneKurse) {
        this.angeschriebeneKurse = angeschriebeneKurse;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID, totalKredits, angeschriebeneKurse);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ",Vorname=" + this.getVorname() +
                ",Nachname=" + this.getNachname() +
                ", totalKredits=" + totalKredits +
                ", angeschriebeneKurse=" + this.getKursName() +
                '}';
    }

    /**
     * ich verwende diese Methode fur toString(), um die Liste der angemeldeten Kurse nur als Name der Kurse anzuzeigen
     * @return eine Liste mit den Namen aller Kurse, bei denen ein Student teilnimmt
     */
    public List<String> getKursName()
    {
        List<String> kurseNamen = new ArrayList<>();
        for(Kurs kurs : this.angeschriebeneKurse)
        {
            kurseNamen.add(kurs.getName());
        }
        return kurseNamen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentID == student.studentID && totalKredits == student.totalKredits && angeschriebeneKurse.equals(student.angeschriebeneKurse);
    }

    /**
     * ich lösche einen Kurs aus der Liste eines Students und subtrahiere die Anzahl des Kurses ECTS von dem Anzahl derKredite des Students
     * @param kurs
     */
    public void loschenKurs(Kurs kurs)
    {
        this.angeschriebeneKurse.remove(kurs);
        this.totalKredits -= kurs.getECTS();
    }

    /**
     * ich berechne wv. Kredite ein Student noch braucht bis er insgesamt 30 hat
     * @return Anzahl notwendigen Krediten
     */
    public int getNotwendigeKredits()
    {
        return (30 - this.getTotalKredits());
    }

    /**
     * Wenn ein Student sich fur einen Kurs anmeldet, dann fuge ich den Kurs in seiner Liste und inkrementiere seine ECTS mit der Anzahl des Kurses ECTS
     * @param kurs
     */
    public void enrolled(Kurs kurs)
    {
        this.angeschriebeneKurse.add(kurs);
        this.totalKredits += kurs.getECTS();
    }

    /**
     * Methode, um nur der Name der Kurse, in denen der Student angemeldet ist
     */
    public void showKurse()
    {
        System.out.println(this.getStudentID() + ":");
        for(Kurs kurs : angeschriebeneKurse)
        {
            System.out.println(kurs.toString2());
        }
    }
}
