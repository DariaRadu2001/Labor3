package Model;

import Person.Lehrer;
import Person.Student;

import java.util.List;
import java.util.Objects;

public class Kurs {
    private String name;
    private Lehrer lehrer;
    private int maximaleAnzahlStudenten;
    private List<Student> listeStudenten;
    private int ects;

    public Kurs(String name, Lehrer lehrer, int maximaleAnzahlStudenten, List<Student> listeStudenten, int ects) {
        this.name = name;
        this.lehrer = lehrer;
        this.maximaleAnzahlStudenten = maximaleAnzahlStudenten;
        this.listeStudenten = listeStudenten;
        this.ects = ects;
    }

    public Kurs() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lehrer getLehrer() {
        return lehrer;
    }

    public void setLehrer(Lehrer lehrer) {
        this.lehrer = lehrer;
    }

    public int getMaximaleAnzahlStudenten() {
        return maximaleAnzahlStudenten;
    }

    public void setMaximaleAnzahlStudenten(int maximaleAnzahlStudenten) {
        this.maximaleAnzahlStudenten = maximaleAnzahlStudenten;
    }

    public List<Student> getListeStudenten() {
        return listeStudenten;
    }

    public void setListeStudenten(List<Student> listeStudenten) {
        this.listeStudenten = listeStudenten;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    @Override
    public String toString() {
        return "Kurs{" +
                "name='" + name + '\'' +
                ", lehrer=" + lehrer +
                ", maximaleAnzahlStudenten=" + maximaleAnzahlStudenten +
                ", listeStudenten=" + listeStudenten +
                ", ects=" + ects +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kurs kurs = (Kurs) o;
        return maximaleAnzahlStudenten == kurs.maximaleAnzahlStudenten && ects == kurs.ects && name.equals(kurs.name) && lehrer.equals(kurs.lehrer) && listeStudenten.equals(kurs.listeStudenten);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lehrer, maximaleAnzahlStudenten, listeStudenten, ects);
    }
}
