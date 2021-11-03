package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lehrer extends Person {

    private List<Kurs> kurse;
    private int lehrerID;

    private static int ID = 0;

    public Lehrer(String vorname, String nachname)
    {
        super(vorname, nachname);
        this.kurse = new ArrayList<>();
        ID++;
        this.lehrerID = ID;
    }

    public void setLehrerID(int lehrerID) {
        this.lehrerID = lehrerID;
    }

    public int getID() {
        return this.lehrerID;
    }

    public List<Kurs> getKurse() {
        return kurse;
    }

    public void setKurse(List<Kurs> kurse) {
        this.kurse = kurse;
    }

    @Override
    public String toString() {
        return "Lehrer{" +
                "kurse=" + kurse +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lehrer lehrer = (Lehrer) o;
        return kurse.equals(lehrer.kurse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kurse);
    }

    public void addKurs(Kurs kurs)
    {
        this.kurse.add(kurs);
    }

    public void loschenKurs(Kurs kurs)
    {
        this.kurse.remove(kurs);
    }
}
