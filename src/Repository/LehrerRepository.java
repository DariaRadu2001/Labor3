package Repository;
import Model.Lehrer;

public class LehrerRepository extends InMemoryRepository<Lehrer>{


    public LehrerRepository() {
        super();
    }

    /**
     * ich andere die Attribute eines Lehrers, wenn die Liste leer ist oder der Lehrer nicht in der Liste ist → Exception
     * @param obj, der Lehrer, den ich andern will
     * @return der neue Lehrer
     * @throws IndexOutOfBoundsException
     */
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

