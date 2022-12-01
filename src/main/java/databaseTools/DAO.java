package databaseTools;

import java.util.List;

public interface DAO<T> {
    T create(T entity);
    T read(long id);
    boolean delete(long id);
    List<T> getAll();
    boolean clear();
    boolean createMany(List<T> entities);
}
