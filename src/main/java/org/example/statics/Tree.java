package org.example.statics;

import org.example.Coordinates;
import org.example.Entity;

public class Tree extends Entity {

    public Tree(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "x=" + coordinates.getX() +
                " y=" + coordinates.getY() +
                '}';
    }
}
