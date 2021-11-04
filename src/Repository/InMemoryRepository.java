package Repository;

import java.util.ArrayList;
import java.util.List;

public abstract class InMemoryRepository<T> implements ICrudRepository<T> {


    protected List<T> repoList;

    public InMemoryRepository() {
        this.repoList = new ArrayList<>();

    }

    @Override
    public T create(T obj) {
        if(repoList.contains(obj))
            throw new IllegalArgumentException("Das Object ist in der Liste.");

        this.repoList.add(obj);
        return obj;
    }

    @Override
    public List<T> getAll() {
        if(repoList.isEmpty())
            throw new IndexOutOfBoundsException("Die Liste ist leer");
        return this.repoList;
    }

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
