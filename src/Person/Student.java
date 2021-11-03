package Person;

import Model.Kurs;

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
        this.angeschriebeneKurse = new LinkedList<Kurs>();
    }

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

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", totalKredits=" + totalKredits +
                ", angeschriebeneKurse=" + angeschriebeneKurse +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentID == student.studentID && totalKredits == student.totalKredits && angeschriebeneKurse.equals(student.angeschriebeneKurse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID, totalKredits, angeschriebeneKurse);
    }

    public void loschenKurs(Kurs kurs)
    {
        this.angeschriebeneKurse.remove(kurs);
    }
}
