package Model;

import java.util.ArrayList;
import java.util.List;

public class Kurs {
    private String name;
    private Lehrer lehrer;
    private int maximaleAnzahlStudenten;
    private List<Student> listeStudenten;
    private int ECTS;

    public Kurs(String name, Lehrer lehrer, int maximaleAnzahlStudenten, int ECTS) {
        this.name = name;
        this.lehrer = lehrer;
        this.maximaleAnzahlStudenten = maximaleAnzahlStudenten;
        this.listeStudenten = new ArrayList<>();
        this.ECTS = ECTS;
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

    public int getECTS() {
        return ECTS;
    }

    public void setECTS(int ECTS) {
        this.ECTS = ECTS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kurs kurs = (Kurs) o;
        return maximaleAnzahlStudenten == kurs.maximaleAnzahlStudenten && ECTS == kurs.ECTS && name.equals(kurs.name) && lehrer.equals(kurs.lehrer) && listeStudenten.equals(kurs.listeStudenten);
    }

    /**
     * ich untersuche, ob ein Kurs freie Platzen hat
     * @return true, wenn es noch Platzen gibt/ false, wenn es voll ist
     */
    public boolean istFrei()
    {
        return this.getListeStudenten().size() < this.getMaximaleAnzahlStudenten();
    }

    /**
     * ich hinzufüge ein bestimmter Student in der Liste der angemeldeten Studenten
     * @param student
     */
    public void addStudent(Student student)
    {
        this.listeStudenten.add(student);
    }

    /**
     * ich berechne der Anzahl den freien Platzen fur dem Kurs
     * @return Anzahl von freien Platzen
     */
    public int getAnzahlFreienPlatze()
    {
        return (this.getMaximaleAnzahlStudenten() - this.getListeStudenten().size());
    }

    @Override
    public String toString() {
        return "Kurs{" +
                "name='" + name + '\'' +
                ", lehrer=" + lehrer.getNachname()+
                ", maximaleAnzahlStudenten=" + maximaleAnzahlStudenten +
                ", listeStudenten=" + this.getStudentenID() +
                ", ECTS=" + ECTS +
                '}';
    }

    /**
     * Ich benutze es fur dem toString() Funktion, indem ich fur die Liste der Studenten nur die ID anzeige
     * @return Liste von IDs der Studenten die zu dem Kurs angemeldet sind
     */
    public List<Long> getStudentenID()
    {
        List<Long> studentenIDs = new ArrayList<>();
        for(Student student : listeStudenten)
        {
            studentenIDs.add(student.getStudentID());
        }

        return studentenIDs;
    }

    /**
     * ich will nur den Namen des Kurses anzeigen
     * @return String mit dem Namen des Kurses
     */
    public String toString2() {
        return "Kurs{" +
                "name='" + name + "'"+
                '}';
    }
}
