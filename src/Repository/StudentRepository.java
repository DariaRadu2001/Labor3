package Repository;

import Model.Student;

public class StudentRepository extends InMemoryRepository<Student> {

    public StudentRepository() {
        super();
    }

    /**
     * ich andere die Attribute eines Studenten, wenn die Liste leer ist oder der Student nicht in der Liste ist → Exception
     * @param obj, der Student, den ich andern will
     * @return der neue Student
     * @throws IndexOutOfBoundsException
     */
    @Override
    public Student update(Student obj) {

        if(repoList.isEmpty())
            throw  new IndexOutOfBoundsException("Die Liste ist leer");

        Student studentToUpdate = this.repoList.stream()
                .filter(student -> student.getStudentID() == obj.getStudentID())
                .findFirst()
                .orElseThrow();

        studentToUpdate.setNachname(obj.getNachname());
        studentToUpdate.setVorname(obj.getVorname());
        studentToUpdate.setTotalKredits(obj.getTotalKredits());
        studentToUpdate.setAngeschriebeneKurse(obj.getAngeschriebeneKurse());

        return studentToUpdate;
    }

    @Override
    public String toString() {
        return "StudentRepository{" +
                "repoList=" + repoList +
                '}';
    }
}
