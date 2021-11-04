package Model;

import java.util.ArrayList;
import java.util.LinkedList;
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
                ", angeschriebeneKurse=" + this .getKursName() +
                '}';
    }

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

    public void loschenKurs(Kurs kurs)
    {
        this.angeschriebeneKurse.remove(kurs);
        this.totalKredits -= kurs.getEcts();
    }

    public int notwendigeKredits()
    {
        return (30 - this.getTotalKredits());
    }

    public void enrolled(Kurs kurs)
    {
        this.angeschriebeneKurse.add(kurs);
        this.totalKredits += kurs.getEcts();
    }

    public void showKurse()
    {
        System.out.println(this.getStudentID() + ":");
        for(Kurs kurs : angeschriebeneKurse)
        {
            System.out.println(kurs.toString2());
        }
    }
}
