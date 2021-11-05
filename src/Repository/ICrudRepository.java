package Repository;

import java.util.List;

public interface ICrudRepository<T> {

    /**
     * ich lege ein Objekt der Typ T in der RepoListe
     * @param obj, das Objekt die ich hinlege
     * @return das Objekt
     */
    T create(T obj);

    /**
     * ich gebe alle Elementen aus der REpoListe
     * @return eine Liste mit Elementen der Typ T
     */
    List<T> getAll();

    /**
     * Ich verändere einige Attribute eines Objektes
     * @param obj, das Objekt mit dem ich switch erledigen will
     * @return das alte Objet mit den neuen Attributen
     */
    T update(T obj);

    /**
     * aus der RepoListe ein Objekt löschen
     * @param obj, das Objekt, das ich löschen will
     * @throws IllegalAccessException
     */
    void delete(T obj) throws IllegalAccessException;
}
