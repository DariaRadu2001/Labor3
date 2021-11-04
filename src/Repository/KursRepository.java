package Repository;

import Model.Kurs;

import java.util.Objects;

public class KursRepository extends InMemoryRepository<Kurs>{

    public KursRepository() {
        super();
    }

    @Override
    public String toString() {
        return "KursRepository{" +
                "repoList=" + repoList +
                '}';
    }

    /**
     * ich andere die Attribute eines Kurses, wenn die Liste leer ist oder der Kurs nicht in der Liste ist → Exception
     * @param obj, der Kurs, den ich andern will
     * @return der neue Kurs
     * @throws IndexOutOfBoundsException
     */
    @Override
    public Kurs update(Kurs obj) {

        if(repoList.isEmpty())
            throw  new IndexOutOfBoundsException("Die Liste ist leer");

        Kurs kursToUpdate = this.repoList.stream()
                .filter(kurs -> Objects.equals(kurs.getName(), obj.getName()))
                .findFirst()
                .orElseThrow();

        kursToUpdate.setLehrer(obj.getLehrer());
        kursToUpdate.setECTS(obj.getECTS());
        kursToUpdate.setMaximaleAnzahlStudenten(obj.getMaximaleAnzahlStudenten());
        kursToUpdate.setECTS(obj.getECTS());
        kursToUpdate.setListeStudenten(obj.getListeStudenten());

        return kursToUpdate;
    }
}
