package game;

import entity.Creature;
import entity.Entity;

import java.util.HashMap;

public class SimulationMap {
    private final HashMap<Coordinates, Creature> entities = new HashMap<>();
    private final HashMap<Coordinates, Entity> staticEntities = new HashMap<>();
    public final Integer height;
    public final Integer width;

    public SimulationMap(Integer height, Integer width) {
        this.height = height;
        this.width = width;
    }

    public void setEntity(Coordinates coordinates, Creature creature) {
        creature.setCoordinates(coordinates);
        entities.put(coordinates, creature);
    }

    public void setStaticEntities(Coordinates coordinates, Entity entity) {
        entity.setCoordinates(coordinates);
        staticEntities.put(coordinates, entity);
    }

    public HashMap<Coordinates, Creature> getEntities() {
        return entities;
    }

    public HashMap<Coordinates, Entity> getStaticEntities() { return staticEntities; }

    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }
}