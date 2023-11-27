package org.example.statics;

import org.example.Coordinates;
import org.example.Entity;

public class Rock extends Entity {

    public Rock(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Rock{" +
                "x=" + coordinates.getX() +
                " y=" + coordinates.getY() +
                '}';
    }
}
