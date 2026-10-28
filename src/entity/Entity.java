package entity;

import game.Coordinates;

public abstract class Entity {
    protected Coordinates coordinates;
    protected final String entitySign;

    public Entity(Coordinates coordinates, String entitySign) {
        this.coordinates = coordinates;
        this.entitySign = entitySign;
    }

    public String getEntitySign() {
        return entitySign;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}