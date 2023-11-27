package org.example.statics;

import org.example.Coordinates;
import org.example.Entity;

public class Grass extends Entity {

    public Grass(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Grass{" +
                "x=" + coordinates.getX() +
                " y=" + coordinates.getY() +
                '}';
    }
}
