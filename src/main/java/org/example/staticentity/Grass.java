package org.example.staticentity;

import org.example.Coordinates;
import org.example.Entity;

public class Grass extends Entity {
    private Coordinates coordinates;

    public Grass(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
