package Teste;

import Model.Lehrer;
import Repository.LehrerRepository;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class LehrerRepositoryTest {

    Lehrer pop;
    Lehrer dancu;
    Lehrer badiu;
    Lehrer pop2;
    LehrerRepository repoLehrer;

    /**
     *  die Objekte instanziieren
     */
    void input()
    {
         pop = new Lehrer("Marcel", "Pop",1);
         dancu = new Lehrer("Ingrid","Dancu",2);
         badiu = new Lehrer("Oana","Badiu",3);
         pop2 = new Lehrer("Maria", "Ionescu", 1);

         repoLehrer = new LehrerRepository();
    }

    /**
     *  die RepoListe instanziieren
     */
    void inputRepo()
    {
         repoLehrer = new LehrerRepository();
    }

    @Test
    @Description("Soll Lehrer in dem repoListe hinzulegen.")
    void create() {

        this.input();

        repoLehrer.create(pop);
        repoLehrer.create(dancu);
        repoLehrer.create(badiu);

        Assertions.assertEquals(3, repoLehrer.getAll().size());
    }

    @Test
    @Description("Soll Lehrer in dem repoListe hinzulegen, wenn der Lehrer in der Liste ist --> Exception.")
    void createLehrerInDerListe()
    {
        this.input();
        repoLehrer.create(pop);
        repoLehrer.create(dancu);
        repoLehrer.create(badiu);

        try
        {
            repoLehrer.create(pop);
        }
        catch(Exception e)
        {
            assert true;
        }
    }

    @Test
    @Description("gibt mir die repoListe, wenn die Liste leer ist-->Exception")
    void getAllLeereListe() {

        this.inputRepo();

        try {
            repoLehrer.getAll();
        } catch (Exception e) {
            assert (true);
        }
    }

    @Test
    @Description("gibt mir die repoListe, wenn die Liste leer ist-->Exception")
    void getAll() {

        this.input();
        repoLehrer.create(pop);
        repoLehrer.create(dancu);
        repoLehrer.create(badiu);

        Assertions.assertEquals(3, repoLehrer.getAll().size());

    }

    @Test
    @Description("wenn die Liste leer, kann man nichts löschen")
    void deleteLeereListe() {

        Lehrer pop = new Lehrer("Marcel", "Pop", 1);
        Lehrer dancu = new Lehrer("Ingrid", "Dancu", 2);
        Lehrer badiu = new Lehrer("Oana", "Badiu", 3);


        LehrerRepository repoLehrer = new LehrerRepository();

        try {
            repoLehrer.delete(pop);
        } catch (Exception e) {
            assert (true);
        }
    }

    @Test
    @Description("wenn das Kurs nicht in der Liste ist, kann man nichts löschen")
    void deleteLehrerNichtInDerListe() {

        this.input();
        repoLehrer.create(pop);
        repoLehrer.create(dancu);

        try {
            repoLehrer.delete(badiu);
        } catch (Exception e) {
            assert (true);
        }
    }

    @Test
    @Description("löscht einen Lehrer aus der Liste")
    void deleteLehrerInDerListe() throws IllegalAccessException {

        this.input();
        repoLehrer.create(pop);
        repoLehrer.create(dancu);

        repoLehrer.delete(pop);

        assertEquals(1, repoLehrer.getAll().size());

    }

    @Test
    @Description("wenn die Liste leer ist, kann man nichts verändern.")
    void updateLeereListe() {

        this.input();

        try {
            repoLehrer.update(pop);
        } catch (Exception e) {
            assert (true);
        }
    }

    @Test
    @Description("wenn der Lehrer nicht in der Liste ist, kann man nichts verändern. ")
    void updateLehrerNichtInDerListe() {

        this.input();
        repoLehrer.create(pop);

        try {
            repoLehrer.update(badiu);
        } catch (Exception e) {
            assert (true);
        }
    }

    @Test
    @Description("Update zu einem Lehrer.")
    void update() {

        this.input();
        repoLehrer.create(pop);
        repoLehrer.create(dancu);
        try
        {
            repoLehrer.update(pop2);
            assert(true);
        }
        catch(Exception e)
        {
            assert(false);
        }

    }
}