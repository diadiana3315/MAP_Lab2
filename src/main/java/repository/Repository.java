package repository;

import domain.AirlineCompany;
import domain.Identifiable;

import java.util.ArrayList;
import java.util.List;

public abstract class Repository<T extends Identifiable> {

    List<T> entities = new ArrayList<>();

    public void save(T entity) {
        entities.add(entity);
    }

    public void remove(T entity) {
        entities.remove(entity);
    }

    public void removeById(int id) {
        for (T entity : entities) {
            if (entity.getId() == id)
                entities.remove(entity);
        }
    }

    public List<T> getAll() {
        return entities;
    }

    public T getById(int entityId) {
        for (T entity : entities) {
            if (entityId == entity.getId())
                return entity;
        }
        return null;
    }
}
