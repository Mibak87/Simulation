package org.example.staticentity;

import org.example.Coordinates;
import org.example.Entity;

public class Tree extends Entity {
    private Coordinates coordinates;

    public Tree(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
