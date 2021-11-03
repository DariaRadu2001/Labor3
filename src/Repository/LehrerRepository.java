package Repository;
import Person.Lehrer;
import Person.Student;

import java.util.List;

public class LehrerRepository extends InMemoryRepository<Lehrer>{


    public LehrerRepository() {
        super();
    }

    @Override
    public Lehrer update(Lehrer obj) {
        Lehrer lehrerToUpdate = this.repoList.stream()
                .filter(lehrer -> lehrer.getID() == obj.getID())
                .findFirst()
                .orElseThrow();

        lehrerToUpdate.setNachname(obj.getNachname());
        lehrerToUpdate.setVorname(obj.getNachname());
        lehrerToUpdate.setKurse(obj.getKurse());

        return lehrerToUpdate;
    }
}

