package org.example.staticentity;

import org.example.Coordinates;
import org.example.Entity;

public class Rock extends Entity {
    private Coordinates coordinates;

    public Rock(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
