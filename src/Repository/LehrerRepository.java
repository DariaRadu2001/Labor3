package Repository;
import Model.Lehrer;

public class LehrerRepository extends InMemoryRepository<Lehrer>{


    public LehrerRepository() {
        super();
    }

    @Override
    public Lehrer update(Lehrer obj) {

        if(repoList.isEmpty())
            throw  new IndexOutOfBoundsException("Die Liste ist leer");

        Lehrer lehrerToUpdate = this.repoList.stream()
                .filter(lehrer -> lehrer.getID() == obj.getID())
                .findFirst()
                .orElseThrow();

        lehrerToUpdate.setNachname(obj.getNachname());
        lehrerToUpdate.setVorname(obj.getVorname());
        lehrerToUpdate.setKurse(obj.getKurse());

        return lehrerToUpdate;
    }

    @Override
    public String toString() {
        return "LehrerRepository{" +
                "repoList=" + repoList +
                '}';
    }


}

