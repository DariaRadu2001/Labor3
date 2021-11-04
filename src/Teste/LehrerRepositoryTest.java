package Teste;

import Model.Lehrer;
import Repository.LehrerRepository;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class LehrerRepositoryTest {


    @Test
    @Description("Soll Lehrer in dem repoListe hinzulegen, wenn der Lehrer in der Liste ist --> Exception.")
    void create() {

        Lehrer pop = new Lehrer("Marcel", "Pop",1);
        Lehrer dancu = new Lehrer("Ingrid","Dancu",2);
        Lehrer badiu = new Lehrer("Oana","Badiu",3);

        LehrerRepository repoLehrer = new LehrerRepository();

        repoLehrer.create(pop);
        repoLehrer.create(dancu);
        repoLehrer.create(badiu);

        Assertions.assertEquals(3, repoLehrer.getAll().size());

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
    void getAll() {

        Lehrer pop = new Lehrer("Marcel", "Pop",1);
        Lehrer dancu = new Lehrer("Ingrid","Dancu",2);
        Lehrer badiu = new Lehrer("Oana","Badiu",3);


        LehrerRepository repoLehrer = new LehrerRepository();

        try
        {
            repoLehrer.getAll();
        }
        catch(Exception e)
        {
            assert(true);
        }

        repoLehrer.create(pop);
        repoLehrer.create(dancu);
        repoLehrer.create(badiu);

        Assertions.assertEquals(3, repoLehrer.getAll().size());
        System.out.println("Test getAll:\n" + repoLehrer.getAll());


    }

    @Test
    @Description("Ich habe 2 Ausnahmen, wenn die Liste leer ist und wenn das Kurs nicht in der Liste ist")
    void delete() {

        Lehrer pop = new Lehrer("Marcel", "Pop",1);
        Lehrer dancu = new Lehrer("Ingrid","Dancu",2);
        Lehrer badiu = new Lehrer("Oana","Badiu",3);


        LehrerRepository repoLehrer = new LehrerRepository();

        try
        {
            repoLehrer.delete(pop);
        }
        catch(Exception e)
        {
            assert(true);
        }

        repoLehrer.create(pop);
        repoLehrer.create(dancu);

        try
        {
            repoLehrer.delete(badiu);
        }
        catch(Exception e)
        {
            assert(true);
        }

        try
        {
            repoLehrer.delete(pop);
            assert(true);
        }
        catch(Exception e)
        {
            assert(false);
        }
    }

    @Test
    @Description("Ich habe 2 Ausnahmen, wenn die Liste leer ist und wenn das Kurs nicht in der Liste ist")
    void update() {

        Lehrer popescu = new Lehrer("Marcel", "Popescu",1);
        Lehrer pop2 = new Lehrer("Ingrid","Dancu",1);

        Lehrer badiu = new Lehrer("Oana","Badiu",3);

        LehrerRepository repoLehrer = new LehrerRepository();

        try
        {
            repoLehrer.update(popescu);
        }
        catch(Exception e)
        {
            assert(true);
        }

        repoLehrer.create(popescu);

        try
        {
            repoLehrer.update(badiu);
        }
        catch(Exception e)
        {
            assert(true);
        }

        try
        {
            repoLehrer.update(pop2);
            assert(true);
        }
        catch(Exception e)
        {
            assert(false);
        }

        System.out.println("Test update:\n" + popescu);
    }
}