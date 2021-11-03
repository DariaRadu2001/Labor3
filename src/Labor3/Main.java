package Labor3;

import Model.Kurs;
import Model.Lehrer;
import Model.Person;
import Model.Student;
import Repository.KursRepository;
import Repository.StudentRepository;

public class Main {

    public static void main(String[] args) {

        Student ana = new Student("Ana","Pop",123);
        Student daria = new Student("Daria","Radu",423);
        Student mark = new Student("Mark","Jacobs",200);

        StudentRepository repoStudenten = new StudentRepository();
        repoStudenten.create(ana);
        repoStudenten.create(daria);
        repoStudenten.create(mark);

        System.out.println(repoStudenten.toString());

        Person pop = new Person("Marcel", "Pop");
        Person dancu = new Person("Ingrid","Dancu");
        Person badiu = new Person("Oana","Badiu");
        Kurs algebra = new Kurs("Algebra", pop, 60, 5);
        Kurs dataBase = new Kurs("Baze de date", dancu, 30, 6);
        Kurs map = new Kurs("Map", dancu, 100, 5);
        Kurs fp = new Kurs("fp", badiu, 35, 6);

        KursRepository repoKurse = new KursRepository();
        repoKurse.create(algebra);
        repoKurse.create(dataBase);
        repoKurse.create(map);
        repoKurse.create(fp);

        System.out.println(repoKurse.toString());


    }
}
