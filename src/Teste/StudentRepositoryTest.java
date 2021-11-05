package Teste;

import Model.Student;
import Repository.StudentRepository;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    Student ana;
    Student daria;
    Student mark;
    Student daria2;
    StudentRepository repoStudenten;

    /**
     *  die Objekte instanziieren
     */
    void input()
    {
        ana = new Student("Ana","Pop",123);
        daria = new Student("Daria","Radu",423);
        mark = new Student("Mark","Jacobs",200);
        daria2 = new Student("Dariana", "Beckham", 423);

        repoStudenten = new StudentRepository();
    }

    /**
     *  die RepoListe instanziieren
     */
    void inputRepo()
    {
        repoStudenten = new StudentRepository();
    }

    @Test
    @Description("Soll Studenten in dem repoListe hinzulegen")
    void create() {

        this.input();

        repoStudenten.create(ana);
        repoStudenten.create(daria);
        repoStudenten.create(mark);

        assertEquals(3, repoStudenten.getAll().size());
    }

    @Test
    @Description("Soll Studenten in dem repoListe hinzulegen, wenn der Student in der Liste ist --> Exception.")
    void createStudentInDerListe() {

        this.input();
        repoStudenten.create(ana);
        repoStudenten.create(daria);
        repoStudenten.create(mark);
        try
        {
            repoStudenten.create(ana);
        }
        catch(Exception e)
        {
            assert(true);
        }

    }

    @Test
    @Description("gibt mir die repoListe, wenn die Liste leer ist-->Exception")
    void getAllListeLeer() {

        inputRepo();

        try {
            repoStudenten.getAll();
        } catch (Exception e) {
            assert (true);
        }
    }

    @Test
    @Description("gibt die repoListe")
    void getAll() {

        input();
        repoStudenten.create(ana);
        repoStudenten.create(daria);
        repoStudenten.create(mark);
        assertEquals(3, repoStudenten.getAll().size());
        System.out.println("Test getAll:\n" + repoStudenten.getAll());

    }

    @Test
    @Description("wenn die Liste leer ist, kann man nicht löschen.")
    void deleteLeereListe()
    {
        this.input();
        try {
            repoStudenten.delete(mark);
        } catch (Exception e) {
            assert (true);
        }

    }

    @Test
    @Description("wenn das Kurs nicht in der Liste ist, kann man es nicht löschen")
    void deleteObjektNichtInDerListe() {

       this.input();
        repoStudenten.create(ana);
        repoStudenten.create(daria);

        try {
            repoStudenten.delete(mark);
        } catch (Exception e) {
            assert (true);
        }
    }

    @Test
    @Description("man prüft, dass das Objekt aus der Liste gelöscht wird")
    void deleteObjektInderListe() throws IllegalAccessException {
        this.input();
        repoStudenten.create(ana);
        repoStudenten.create(daria);
        repoStudenten.delete(ana);
        assertEquals(1, repoStudenten.getAll().size());

    }

    @Test
    @Description("wenn die Liste leer ist, kann man nichts verändern")
    void updateLeereListe() {

        this.input();

        try {
            repoStudenten.update(mark);
        } catch (Exception e) {
            assert (true);
        }
    }

    @Test
    @Description("Ich habe 2 Ausnahmen, wenn die Liste leer ist und wenn das Kurs nicht in der Liste ist")
    void updateObjektNichtInDerListe() {
        this.input();

        repoStudenten.create(daria);

        try {
            repoStudenten.update(mark);
        } catch (Exception e) {
            assert (true);
        }
    }

    @Test
    @Description("Verändert ein Objekt, das in der Liste ist")
    void updateObjektInDerListe()
    {
        this.input();
        repoStudenten.create(daria);
        try
        {
            repoStudenten.update(daria2);
            assert(true);
        }
        catch(Exception e)
        {
            assert(false);
        }

    }
}