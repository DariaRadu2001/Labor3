package Person;

import Model.Kurs;

import java.util.List;
import java.util.Objects;

public class Lehrer extends Person{

    private List<Kurs> kurse;
    private int ID;

    public Lehrer(String vorname, String nachname, List<Kurs> kurse, int ID) {
        super(vorname, nachname);
        this.kurse = kurse;
        this.ID = ID;
    }

    public Lehrer() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public void loschenKurs(Kurs kurs)
    {
        this.kurse.remove(kurs);
    }
}
