package Repository;

import Model.Kurs;
import Model.Lehrer;
import Model.Student;

import java.util.*;

public class RegisterSchema {

    private LehrerRepository lehrerRepo;
    private KursRepository kursRepo;
    private StudentRepository studentenRepo;

    public RegisterSchema(LehrerRepository lehrerRepo, KursRepository kursRepo, StudentRepository studentenRepo) {
        this.lehrerRepo = lehrerRepo;
        this.kursRepo = kursRepo;
        this.studentenRepo = studentenRepo;
    }

    /**
     * Methode, indem ein Student sich fur einen Kurs anmelden kann. Er kann bei dem Kurs teilnehmen, wenn er nicht uber 30 Kredite hat
     * und noch Platze bei dem Kurs sind
     * @param kurs, wo er sich anmelden will
     * @param student, der Student der sich fur einen Kurs anmeldet
     * @return true, wenn er sic bei dem Kurs angemeldet hat/ false, wenn er nicht teilnehmen kann
     */
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
            if((kurs.frei() && (student.notwendigeKredits() >= kurs.getECTS())))
            {
                student.enrolled(kurs);
                kurs.addStudent(student);

                return true;
            }
            else
                return false;
        }

    }

    /**
     * Ich untersuche, welche Kurse noch freien Platzen haben
     * @return ein Map der als Key den Kurs und als Value die Anzahl den freien Platze hat
     */
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

    /**
     * Ich schaue, welche Kurse noch frei sind
     * @return eine Liste mit freien Kursen
     */
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

    /**
     * ich sehe, welche Studenten zu einem Kurs angemeldet sind
     * @param kurs, fur welcher wir sehen, welche Studenten angemeldet sind
     * @return eine Liste von Studenten, die fur einen bestimmten Kurs angemeldet sind
     */
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

    /**
     * ich sehe alle Kurse aus dem repoKurse
     * @return Liste mit allen verfügbaren Kurse
     */
    public List<Kurs> verfugbareKurse()
    {
        return kursRepo.getAll();
    }

    /**
     * Anwendung, wo sich der Student fur einen Kurs anmelden kann
     * @param kurs, der Kurs, wo der Student sich anmeldet
     * @param student, der sich fur einen Kurs anmelden will
     */
    public void anmelden(Kurs kurs, Student student)
    {
        Scanner keyboard = new Scanner(System.in);
        while(!register(kurs,student))
        {
            System.out.println("Bitte wahlen sie ein anderes Kurs :");
            List<Kurs> freieKurse = kurseFreiePlatzen();
            for(Kurs kurse : freieKurse)
            {
                System.out.println(kurse);
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

    /**
     * ein Lehrer löscht einen Kurs, wenn der Lehrer den Kurs nicht unterrichtet, dann kann er ihn nicht löschen
     * @param lehrer, wer den Kurs löscht
     * @param kurs, den gelöscht wird
     * @return true, wenn man den Kurs gelöscht hat/ false, wenn man ihn nicht löschen kann
     */
    public boolean loschenKurs(Lehrer lehrer, Kurs kurs)
    {
        if(!lehrer.getKurse().contains(kurs))
            return false;
            //throw new IllegalArgumentException("Der Lehrer unterrichtet den Kurs nicht.");
        lehrer.loschenKurs(kurs);
        for(Student student : studentenRepo.repoList)
        {
            if(student.getAngeschriebeneKurse().contains(kurs))
            {
                student.loschenKurs(kurs);
            }
        }
        return true;
    }

    /**
     * Ich andere die ECTS zu einem bestimmten Kurs.
     * Ich andere der Anzahl den Krediten der Studenten, die bei dem Kurs teilnehmen
     * @param ECTS, neue ECTS
     * @param kurs, bei dem die ECTS andern will
     */
    public void andernECTS(int ECTS, Kurs kurs)
    {
        if(kursRepo.repoList.contains(kurs))
        {
            int alteECTS = kurs.getECTS();
            Kurs updateKurs = kurs;
            updateKurs.setECTS(ECTS);
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
