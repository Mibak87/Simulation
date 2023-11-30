package org.example.creatures;

import org.example.Coordinates;
import org.example.Entity;
import org.example.SimulationMap;

import java.util.ArrayList;
import java.util.HashMap;

public class Herbivore extends Creature {
    private final int maxLife = 2;
    public Herbivore(int velocity, int life, Coordinates coordinates) {
        super(velocity,life,coordinates);
    }

    public int getMaxLife() {
        return maxLife;
    }

    @Override
    public Coordinates makeMove(SimulationMap simulationMap) {
        ArrayList<Coordinates> path = simulationMap.findPath(coordinates);
        if (path.size() >= velocity) {
            return path.get(path.size() - velocity);
        } else {
            return path.get(path.size() - 1);
        }
    }

    @Override
    public String toString() {
        return "Herbivore{" +
                "x=" + coordinates.getX() +
                " y=" + coordinates.getY() +
                '}';
    }
}
