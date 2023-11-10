package repository;
import java.util.List;
public interface Repository<T> {
    void save(T entity);
    void remove(T entity);
    List<T> getAll();
    T getById(int id);
}
