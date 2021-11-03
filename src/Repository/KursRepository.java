package Repository;

import Model.Kurs;

import java.util.Objects;

public class KursRepository extends InMemoryRepository<Kurs>{

    public KursRepository() {
        super();
    }

    @Override
    public Kurs update(Kurs obj) {
        Kurs kursToUpdate = this.repoList.stream()
                .filter(kurs -> Objects.equals(kurs.getName(), obj.getName()))
                .findFirst()
                .orElseThrow();

        kursToUpdate.setLehrer(obj.getLehrer());
        kursToUpdate.setEcts(obj.getEcts());
        kursToUpdate.setMaximaleAnzahlStudenten(obj.getMaximaleAnzahlStudenten());
        kursToUpdate.setEcts(obj.getEcts());
        kursToUpdate.setListeStudenten(obj.getListeStudenten());

        return kursToUpdate;
    }
}
