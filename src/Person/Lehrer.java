package Person;

import Model.Kurs;

import java.util.List;

public class Lehrer extends Person{

    private List<Kurs> kurse;

    public Lehrer(String vorname, String nachname, List<Kurs> kurse) {
        super(vorname, nachname);
        this.kurse = kurse;
    }

    public Lehrer() {
    }

    public List<Kurs> getKurse() {
        return kurse;
    }

    public void setKurse(List<Kurs> kurse) {
        this.kurse = kurse;
    }
}
