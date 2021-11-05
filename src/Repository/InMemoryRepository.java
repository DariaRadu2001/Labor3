package Repository;

import java.util.ArrayList;
import java.util.List;

public abstract class InMemoryRepository<T> implements ICrudRepository<T> {


    protected List<T> repoList;

    /**
     * ich erstelle ein leeres ArrayList fur dem Repo
     */
    public InMemoryRepository() {
        this.repoList = new ArrayList<>();

    }

    /**
     * Ich lege ein Objekt in dem Repo hinzu. Wenn das Objekt in der Liste ist → Exception
     * @param obj
     * @return das Objekt das ich in dem repoListe hinzugefügt habe
     * @throws IllegalArgumentException
     */
    @Override
    public T create(T obj) throws IllegalArgumentException {
        if(repoList.contains(obj))
            throw new IllegalArgumentException("Das Object ist in der Liste.");

        this.repoList.add(obj);
        return obj;
    }

    /**
     * ich gebe die RepoListe zurück, wenn die Liste leer ist → Exception
     * @return die repoListe
     * @throws IndexOutOfBoundsException
     */
    @Override
    public List<T> getAll() {
        if(repoList.isEmpty())
            throw new IndexOutOfBoundsException("Die Liste ist leer");
        return this.repoList;
    }

    /**
     * ich lösche ein Objekt aus der RepoListe, wenn das Objekt nicht existiert oder nicht in der Liste ist → Exception
     * @param obj, das gelöschtes Objekt
     * @throws IllegalAccessException
     */
    @Override
    public void delete(T obj) throws IllegalAccessException {

        if(repoList.isEmpty())
            throw new IndexOutOfBoundsException("Die Liste ist leer");

        if(repoList.contains(obj))
            this.repoList.remove(obj);
        else
            throw new IllegalAccessException("Das Objekt existiert nicht.");
    }

}
