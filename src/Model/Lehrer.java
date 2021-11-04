package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lehrer extends Person {

    private List<Kurs> kurse;
    private int lehrerID;

    public Lehrer(String vorname, String nachname, int lehrerID) {
        super(vorname, nachname);
        this.kurse = new ArrayList<>();
        this.lehrerID = lehrerID;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lehrer lehrer = (Lehrer) o;
        return lehrerID == lehrer.lehrerID && Objects.equals(kurse, lehrer.kurse);
    }

    /**
     * ein Kurs zu der Liste der unterrichteten Kurse eines Lehrers hinzufügen
     * @param kurs
     */
    public void addKurs(Kurs kurs)
    {
        this.kurse.add(kurs);
    }

    /**
     * ein Kurs von der Liste der unterrichteten Kurse eines Lehrers löschen
     * @param kurs
     */
    public void loschenKurs(Kurs kurs)
    {
        this.kurse.remove(kurs);
    }

    @Override
    public String toString() {
        return "Lehrer{" +
                "kurse=" + this.getKursName() +
                ", lehrerID=" + lehrerID +
                ", Vorname=" + this.getVorname() +
                ", Nachname=" + this.getNachname()+
                '}';
    }

    /**
     * ich verwende diese Methode fur toString(), um die Liste der gerichteten Kurse nur als Name der Kurse anzuzeigen
     * @return eine Liste mit Namen aller Kurse, die ein Lehrer unterrichtet
     */
    public List<String> getKursName()
    {
        List<String> kurseNamen = new ArrayList<>();
        for(Kurs kurs : this.kurse)
        {
            kurseNamen.add(kurs.getName());
        }
        return kurseNamen;
    }


}
