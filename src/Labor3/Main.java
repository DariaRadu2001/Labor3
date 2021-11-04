package Labor3;

import Model.Kurs;
import Model.Lehrer;
import Model.Person;
import Model.Student;
import Repository.KursRepository;
import Repository.LehrerRepository;
import Repository.RegisterSchema;
import Repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Student ana = new Student("Ana","Pop",123);
        Student daria = new Student("Daria","Radu",423);
        Student mark = new Student("Mark","Jacobs",200);

        StudentRepository repoStudenten = new StudentRepository();
        repoStudenten.create(ana);
        repoStudenten.create(daria);
        repoStudenten.create(mark);

        Lehrer pop = new Lehrer("Marcel", "Pop",1);
        Lehrer dancu = new Lehrer("Ingrid","Dancu",2);
        Lehrer badiu = new Lehrer("Oana","Badiu",3);


        Kurs algebra = new Kurs("Algebra", pop, 1, 5);
        Kurs dataBase = new Kurs("Baze de date", dancu, 30, 26);
        Kurs map = new Kurs("Map", dancu, 100, 5);
        Kurs fp = new Kurs("fp", badiu, 35, 6);

        pop.addKurs(algebra);
        dancu.addKurs(dataBase);
        dancu.addKurs(map);
        badiu.addKurs(fp);

        LehrerRepository repoLehrer = new LehrerRepository();
        repoLehrer.create(pop);
        repoLehrer.create(dancu);
        repoLehrer.create(badiu);

        KursRepository repoKurse = new KursRepository();
        repoKurse.create(algebra);
        repoKurse.create(dataBase);
        repoKurse.create(map);
        repoKurse.create(fp);

        RegisterSchema registru = new RegisterSchema(repoLehrer, repoKurse, repoStudenten);

        registru.register(algebra, daria);
        registru.register(dataBase, daria);
        registru.register(map,daria);
        registru.register(fp,ana);
        registru.register(map,ana);

        daria.showKurse();

        System.out.println(registru.kurseFreiePlatzenUndAnzahl());
        System.out.println(registru.kurseFreiePlatzen());
        System.out.println("1 "+registru.studentenAngemeldetBestimmtenKurs(map));
        System.out.println("2 "+registru.studentenAngemeldetBestimmtenKurs(fp));
        System.out.println("3 "+registru.studentenAngemeldetBestimmtenKurs(dataBase));

        assert(!registru.loschenKurs(dancu, fp));
        registru.loschenKurs(dancu, map);
        daria.showKurse();
        System.out.println(daria.getTotalKredits());

        registru.andernECTS(10,algebra);
        System.out.println(algebra);
        System.out.println(daria.getTotalKredits());
    }
}
