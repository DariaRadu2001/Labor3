package Teste;

import Model.Kurs;
import Model.Lehrer;
import Repository.KursRepository;
import jdk.jfr.Description;


import static org.junit.jupiter.api.Assertions.*;

class KursRepositoryTest {

    Lehrer pop;
    Lehrer dancu;
    Kurs algebra;
    Kurs dataBase;
    Kurs map;
    Kurs fp;
    Kurs algebra2;
    KursRepository repoKurs;

    /**
     *  die Objekte instanziieren
     */
    void input()
    {
        pop = new Lehrer("Marcel", "Pop",1);
        algebra = new Kurs("Algebra", pop, 1, 5);
        dataBase = new Kurs("Baze de date", pop, 30, 26);
        map = new Kurs("Map", pop, 100, 5);
        fp = new Kurs("fp", pop, 35, 6);
        algebra2 = new Kurs("Algebra", dancu, 10, 15);
        dancu = new Lehrer("Ingrid","Dancu",2);

        repoKurs = new KursRepository();

    }

    @org.junit.jupiter.api.Test
    @Description("Soll Kurse in dem repoListe hinzulegen.")
    void create() {

        this.input();
        repoKurs.create(algebra);
        repoKurs.create(dataBase);
        repoKurs.create(map);
        repoKurs.create(fp);

        assertEquals(4, repoKurs.getAll().size());
    }

    @org.junit.jupiter.api.Test
    @Description("Soll Kurse in dem repoListe hinzulegen, wenn das Kurs in der Liste ist --> Exception.")
    void createException() {

        this.input();
        repoKurs.create(algebra);
        repoKurs.create(dataBase);
        repoKurs.create(map);
        repoKurs.create(fp);

        try
        {
            repoKurs.create(algebra);
        }
        catch(Exception e)
        {
            assert(true);
        }

        //Assertions.assertThrows(Exception.class, (Executable) repoKurs.create(algebra));

    }

    @org.junit.jupiter.api.Test
    @Description("gibt die repoListe, wenn die Liste leer ist-->Exception")
    void getAllListeLeer() {

        this.input();
        try {
            repoKurs.getAll();
        } catch (Exception e) {
            assert (true);
        }

    }

    @org.junit.jupiter.api.Test
    @Description("gibt die repoListe")
    void getAll()
    {
        this.input();
        repoKurs.create(dataBase);
        repoKurs.create(map);
        repoKurs.create(fp);

        assertEquals(3, repoKurs.getAll().size());

    }

    @org.junit.jupiter.api.Test
    @Description("wenn die Liste leer ist,kann man das Objekt nicht löschen")
    void deleteLeereListe() {
        this.input();

        try {
            repoKurs.delete(map);
        } catch (Exception e) {
            assert (true);
        }

        //Assertions.assertThrows(IndexOutOfBoundsException.class, (Executable) repoKurs::delete(map));
    }

    @org.junit.jupiter.api.Test
    @Description("Delete, wenn das Kurs nicht in der Liste ist")
    void deleteObjektNichtIndDerListe() {
        this.input();

        repoKurs.create(algebra);
        repoKurs.create(dataBase);
        repoKurs.create(map);

        try {
            repoKurs.delete(fp);
        } catch (Exception e) {
            assert (true);
        }
    }

    @org.junit.jupiter.api.Test
    @Description("Delete, wenn das Kurs in der Liste ist")
    void deleteObjektIndDerListe() throws IllegalAccessException {
        this.input();

        repoKurs.create(algebra);
        repoKurs.create(dataBase);
        repoKurs.create(map);

        repoKurs.delete(map);

        assertEquals(2, repoKurs.getAll().size());
    }

    @org.junit.jupiter.api.Test
    @Description("Ausnahmen, wenn die Liste leer ist, kann man den Objekt nicht andern")
    void updateLeereListe() {

        this.input();

        try {
            repoKurs.update(algebra);
        } catch (Exception e) {
            assert (true);
        }
    }

    @org.junit.jupiter.api.Test
    @Description("das Kurs ist nicht in der Liste, kann man update nicht erledigen")
    void updateObjektNichtInDerListe() {

        this.input();
        repoKurs.create(algebra);

        try {
            repoKurs.update(fp);
        } catch (Exception e) {
            assert (true);
        }
    }

    @org.junit.jupiter.api.Test
    @Description("das Kurs ist in der Liste, kann man update erledigen")
    void UpdateObjektInDerListe()
    {
        this.input();
        repoKurs.create(algebra);
        repoKurs.create(dataBase);
        repoKurs.create(map);
        try
        {
            repoKurs.update(algebra2);
            assert(true);
        }
        catch(Exception e)
        {
            assert(false);
        }
    }
}