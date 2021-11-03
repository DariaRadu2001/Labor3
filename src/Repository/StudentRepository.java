package Repository;

import Model.Kurs;
import Person.Student;

import java.util.Objects;

public class StudentRepository extends InMemoryRepository<Student> {

    public StudentRepository() {
        super();
    }

    @Override
    public Student update(Student obj) {
        Student studentToUpdate = this.repoList.stream()
                .filter(student -> student.getStudentID() == obj.getStudentID())
                .findFirst()
                .orElseThrow();

        studentToUpdate.setNachname(obj.getNachname());
        studentToUpdate.setVorname(obj.getNachname());
        studentToUpdate.setTotalKredits(obj.getTotalKredits());
        studentToUpdate.setAngeschriebeneKurse(obj.getAngeschriebeneKurse());

        return studentToUpdate;
    }
}
