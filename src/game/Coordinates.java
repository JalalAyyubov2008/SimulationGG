package game;

import actions.CoordinatesShift;

public record Coordinates(Integer row, Integer column) {

    public Coordinates shift(CoordinatesShift shift) {
        return new Coordinates(row + shift.rowShift(), column + shift.columnShift());
    }

    public boolean canShift(CoordinatesShift shift, Integer height, Integer width) {
        int r = row + shift.rowShift();
        int c = column + shift.columnShift();

        return (r > 0 && r <= height) && (c > 0 && c <= width);
    }

}
