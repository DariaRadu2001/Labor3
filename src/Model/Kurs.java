package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Kurs {
    private String name;
    private Lehrer lehrer;
    private int maximaleAnzahlStudenten;
    private List<Student> listeStudenten;
    private int ects;

    public Kurs(String name, Lehrer lehrer, int maximaleAnzahlStudenten, int ects) {
        this.name = name;
        this.lehrer = lehrer;
        this.maximaleAnzahlStudenten = maximaleAnzahlStudenten;
        this.listeStudenten = new ArrayList<>();
        this.ects = ects;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kurs kurs = (Kurs) o;
        return maximaleAnzahlStudenten == kurs.maximaleAnzahlStudenten && ects == kurs.ects && name.equals(kurs.name) && lehrer.equals(kurs.lehrer) && listeStudenten.equals(kurs.listeStudenten);
    }


    public boolean frei()
    {
        return this.getListeStudenten().size() < this.getMaximaleAnzahlStudenten();
    }

    public void addStudent(Student student)
    {
        this.listeStudenten.add(student);
    }

    public int anzahlFreienPlatze()
    {
        return (this.getMaximaleAnzahlStudenten() - this.getListeStudenten().size());
    }

    public void showStudenten()
    {
        for(Student student : listeStudenten)
        {
            System.out.println(student.getStudentID());
        }
    }

    @Override
    public String toString() {
        return "Kurs{" +
                "name='" + name + '\'' +
                ", lehrer=" + lehrer.getNachname()+
                ", maximaleAnzahlStudenten=" + maximaleAnzahlStudenten +
                ", listeStudenten=" + this.getStudentenID() +
                ", ECTS=" + ects +
                '}';
    }

    public List<Long> getStudentenID()
    {
        List<Long> studentenIDs = new ArrayList<>();
        for(Student student : listeStudenten)
        {
            studentenIDs.add(student.getStudentID());
        }

        return studentenIDs;
    }

    public String toString2() {
        return "Kurs{" +
                "name='" + name + "'"+
                '}';
    }
}
