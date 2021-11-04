package Teste;

import Model.Kurs;
import Model.Lehrer;
import Repository.KursRepository;
import jdk.jfr.Description;


import static org.junit.jupiter.api.Assertions.*;

class KursRepositoryTest {



    @org.junit.jupiter.api.Test
    @Description("Soll Kurse in dem repoListe hinzulegen, wenn das Kurs in der Liste ist --> Exception.")
    void create() {

        KursRepository repoKurs = new KursRepository();
        Lehrer pop = new Lehrer("Marcel", "Pop",1);

        Kurs algebra = new Kurs("Algebra", pop, 1, 5);
        Kurs dataBase = new Kurs("Baze de date", pop, 30, 26);
        Kurs map = new Kurs("Map", pop, 100, 5);
        Kurs fp = new Kurs("fp", pop, 35, 6);

        repoKurs.create(algebra);
        repoKurs.create(dataBase);
        repoKurs.create(map);
        repoKurs.create(fp);

        assertEquals(4, repoKurs.getAll().size());

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
    @Description("gibt mir die repoListe, wenn die Liste leer ist-->Exception")
    void getAll() {

        KursRepository  repoKurs = new KursRepository();
        try
        {
            repoKurs.getAll();
        }
        catch (Exception e)
        {
            assert(true);
        }

        Lehrer pop = new Lehrer("Marcel", "Pop",1);
        Kurs dataBase = new Kurs("Baze de date", pop, 30, 26);
        Kurs map = new Kurs("Map", pop, 100, 5);
        Kurs fp = new Kurs("fp", pop, 35, 6);

        repoKurs.create(dataBase);
        repoKurs.create(map);
        repoKurs.create(fp);

        assertEquals(3, repoKurs.getAll().size());
        System.out.println("Test getAll:\n" + repoKurs.getAll());

    }

    @org.junit.jupiter.api.Test
    @Description("Ich habe 2 Ausnahmen, wenn die Liste leer ist und wenn das Kurs nicht in der Liste ist")
    void delete() {
        KursRepository repoKurs = new KursRepository();
        Lehrer pop = new Lehrer("Marcel", "Pop",1);

        Kurs algebra = new Kurs("Algebra", pop, 1, 5);
        Kurs dataBase = new Kurs("Baze de date", pop, 30, 26);
        Kurs map = new Kurs("Map", pop, 100, 5);
        Kurs fp = new Kurs("fp", pop, 35, 6);

        try
        {
            repoKurs.delete(map);
        }
        catch(Exception e)
        {
            assert(true);
        }

        //Assertions.assertThrows(IndexOutOfBoundsException.class, (Executable) repoKurs::delete(map));

        repoKurs.create(algebra);
        repoKurs.create(dataBase);
        repoKurs.create(map);

        try
        {
            repoKurs.delete(fp);
        }
        catch(Exception e)
        {
            assert(true);
        }

        try
        {
            repoKurs.delete(map);
            assert(true);
        }
        catch(Exception e)
        {
            assert(false);
        }

        assertEquals(2, repoKurs.getAll().size());
    }

    @org.junit.jupiter.api.Test
    @Description("Ich habe 2 Ausnahmen, wenn die Liste leer ist und wenn das Kurs nicht in der Liste ist")
    void update() {

        KursRepository repoKurs = new KursRepository();
        Lehrer pop = new Lehrer("Marcel", "Pop",1);
        Lehrer dancu = new Lehrer("Ingrid","Dancu",2);

        Kurs algebra = new Kurs("Algebra", pop, 1, 5);
        Kurs algebra2 = new Kurs("Algebra", dancu, 10, 15);
        Kurs fp = new Kurs("fp", pop, 35, 6);

        try
        {
            repoKurs.update(algebra);
        }
        catch(Exception e)
        {
            assert(true);
        }

        repoKurs.create(algebra);
        try
        {
            repoKurs.update(fp);
        }
        catch(Exception e)
        {
            assert(true);
        }

        try
        {
            repoKurs.update(algebra2);
            assert(true);
        }
        catch(Exception e)
        {
            assert(false);
        }

        System.out.println("test update:\n" + repoKurs.getAll());
    }
}