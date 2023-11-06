package org.example.creatures;

import org.example.Coordinates;
import org.example.creatures.Creature;

public class Herbivore extends Creature {
    public Herbivore(int velocity, int life, Coordinates coordinates) {
        super(velocity,life,coordinates);
    }

    @Override
    public String toString() {
        return "Herbivore{" +
                "x=" + coordinates.getX() +
                " y=" + coordinates.getY() +
                '}';
    }

    @Override
    public void makeMove() {

    }
}
