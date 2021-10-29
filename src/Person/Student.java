package Person;

import Model.Kurs;

import java.util.List;

public class Student extends Person{

    private long studentID;
    private int totalKredits;
    private List<Kurs> angeschriebeneKurse;

    public Student(String vorname, String nachname, long studentID, int totalKredits, List<Kurs> angeschriebeneKurse) {
        super(vorname, nachname);
        this.studentID = studentID;
        this.totalKredits = totalKredits;
        this.angeschriebeneKurse = angeschriebeneKurse;
    }

    public Student() {
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
}
