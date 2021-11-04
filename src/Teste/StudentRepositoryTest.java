package Teste;

import Model.Student;
import Repository.StudentRepository;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    @Test
    @Description("Soll Studenten in dem repoListe hinzulegen, wenn der Student in der Liste ist --> Exception.")
    void create() {

        Student ana = new Student("Ana","Pop",123);
        Student daria = new Student("Daria","Radu",423);
        Student mark = new Student("Mark","Jacobs",200);

        StudentRepository repoStudenten = new StudentRepository();

        repoStudenten.create(ana);
        repoStudenten.create(daria);
        repoStudenten.create(mark);

        assertEquals(3, repoStudenten.getAll().size());

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
    void getAll() {

        StudentRepository repoStudenten = new StudentRepository();

        try
        {
            repoStudenten.getAll();
        }
        catch (Exception e)
        {
            assert(true);
        }

        Student ana = new Student("Ana","Pop",123);
        Student daria = new Student("Daria","Radu",423);
        Student mark = new Student("Mark","Jacobs",200);

        repoStudenten.create(ana);
        repoStudenten.create(daria);
        repoStudenten.create(mark);
        assertEquals(3, repoStudenten.getAll().size());
        System.out.println("Test getAll:\n" + repoStudenten.getAll());

    }

    @Test
    @Description("Ich habe 2 Ausnahmen, wenn die Liste leer ist und wenn das Kurs nicht in der Liste ist")
    void delete() {

        StudentRepository repoStudenten = new StudentRepository();
        Student ana = new Student("Ana","Pop",123);
        Student daria = new Student("Daria","Radu",423);
        Student mark = new Student("Mark","Jacobs",200);

        repoStudenten.create(ana);
        repoStudenten.create(daria);

        assertEquals(2, repoStudenten.getAll().size());

        try
        {
            repoStudenten.delete(mark);
        }
        catch(Exception e)
        {
            assert(true);
        }

        try
        {
            repoStudenten.delete(ana);
        }
        catch(Exception e)
        {
            assert(false);
        }

        assertEquals(1, repoStudenten.getAll().size());

    }

    @Test
    @Description("Ich habe 2 Ausnahmen, wenn die Liste leer ist und wenn das Kurs nicht in der Liste ist")
    void update() {

        StudentRepository repoStudenten = new StudentRepository();
        Student daria = new Student("Daria","Radu",423);
        Student mark = new Student("Mark","Jacobs",400);
        Student daria2 = new Student("Dariana","Beckham",423);

        try
        {
            repoStudenten.update(mark);
        }
        catch(Exception e)
        {
            assert(true);
        }

        repoStudenten.create(daria);

        try
        {
            repoStudenten.update(mark);
        }
        catch(Exception e)
        {
            assert(true);
        }

        try
        {
            repoStudenten.update(daria2);
            assert(true);
        }
        catch(Exception e)
        {
            assert(false);
        }

        System.out.println("Test update:\n" + daria);


    }
}