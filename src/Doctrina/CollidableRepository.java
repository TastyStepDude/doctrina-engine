package Doctrina;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollidableRepository implements Iterable<StaticEntity> {
    private static CollidableRepository instance;

    private final List<StaticEntity> registeredEntities;

    public CollidableRepository() {
        registeredEntities = new ArrayList<>();
        // private constructor to prevent class creation
    }

    public static CollidableRepository getInstance() {
        if (instance == null) {
            return new CollidableRepository();
        }
        return instance;
    }

    public void registerStaticEntity(StaticEntity entity) {
        registeredEntities.add(entity);
    }

    public void unregisterStaticEntity(StaticEntity entity) {
        registeredEntities.remove(entity);
    }

    public void registerStaticEntities(Collection<StaticEntity> entities) {
        registeredEntities.addAll(entities);
    }

    public void unregisterStaticEntities(Collection<StaticEntity> entities) {
        registeredEntities.addAll(entities);
    }

    public int count() {
        return registeredEntities.size();
    }

    @Override
    public Iterator<StaticEntity> iterator() {
        return registeredEntities.iterator();
    }
}
