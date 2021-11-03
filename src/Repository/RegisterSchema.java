package Repository;

import Model.Kurs;
import Model.Lehrer;
import Model.Student;

import java.util.*;

public class RegisterSchema {

    LehrerRepository lehrerRepo;
    KursRepository kursRepo;
    StudentRepository studentenRepo;

    public boolean register(Kurs kurs, Student student)
    {
        if(!kursRepo.repoList.contains(kurs))
            return false;

        if(student.getAngeschriebeneKurse().contains(kurs))
        {
            return false;
        }
        else
        {
            if((kurs.frei() && (student.notwendigeKredits() >= kurs.getEcts())))
            {
                student.enrolled(kurs);
                kurs.addStudent(student);
                return true;
            }
            else
                return false;
        }

    }

    public Map<Kurs, Integer> kurseFreiePlatzenUndAnzahl()
    {
        Map<Kurs, Integer> mapFreieKurse = new HashMap<>();
        for(Kurs kurs : kursRepo.repoList)
        {
            if(kurs.frei())
            {
                mapFreieKurse.put(kurs,kurs.anzahlFreienPlatze());
            }
        }
        return mapFreieKurse;
    }

    public List<Kurs> kurseFreiePlatzen()
    {
        List<Kurs> freieKurse = new ArrayList<>();
        for(Kurs kurs : kursRepo.repoList)
        {
            if(kurs.frei())
            {
                freieKurse.add(kurs);
            }
        }
        return freieKurse;
    }

    public List<Student> studentenAngemeldetBestimmtenKurs(Kurs kurs)
    {
        List<Student> studentenAngemeldet = new ArrayList<>();
        for(Student student : studentenRepo.repoList)
        {
            List<Kurs> kurseStudent = student.getAngeschriebeneKurse();
            for(Kurs course : kurseStudent)
            {
                if(Objects.equals(course.getName(), kurs.getName()))
                {
                    studentenAngemeldet.add(student);
                    break;
                }
            }
        }
        return studentenAngemeldet;
    }

    public List<Kurs> verfugbareKurse()
    {
        return kursRepo.getAll();
    }

    public void anmelden(Kurs kurs, Student student)
    {
        Scanner keyboard = new Scanner(System.in);
        while(!register(kurs,student))
        {
            System.out.println("Bitte wahlen sie ein anderes Kurs :");
            List<Kurs> freieKurse = kurseFreiePlatzen();
            for(Kurs kurse : freieKurse)
            {
                kurse.toString();
            }

            System.out.println("Name der Kurs Bitte: ");
            String nameKurs = keyboard.nextLine();

            try{
                Kurs finalKurs = kurs;
                kurs = kursRepo.repoList.stream()
                        .filter(kurs2 -> finalKurs.getName() == nameKurs)
                        .findFirst()
                        .orElseThrow();
            }
            catch (Exception e)
            {
                System.out.println("Sie haben den Name des Kurses falsch geschrieben. ");
            }
        }
    }

    public void loschenKurs(Lehrer lehrer, Kurs kurs)
    {
        lehrer.loschenKurs(kurs);
        for(Student student : studentenRepo.repoList)
        {
            if(student.getAngeschriebeneKurse().contains(kurs))
            {
                student.loschenKurs(kurs);
            }
        }
    }

    public void andernECTS(int ECTS, Kurs kurs)
    {
        if(kursRepo.repoList.contains(kurs))
        {
            int alteECTS = kurs.getEcts();
            Kurs updateKurs = kurs;
            updateKurs.setEcts(ECTS);
            kursRepo.update(updateKurs);

            for(Student student : studentenRepo.repoList)
            {
                if(student.getAngeschriebeneKurse().contains(updateKurs))
                {
                    int neueAnzahlKredits = student.getTotalKredits() + (ECTS-alteECTS);
                    Student updateStudent = student;
                    updateStudent.setTotalKredits(neueAnzahlKredits);
                    studentenRepo.update(updateStudent);
                }
            }

        }
    }

}
