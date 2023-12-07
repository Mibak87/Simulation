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
    public void makeMove(SimulationMap simulationMap) {
        ArrayList<Coordinates> path = simulationMap.findPath(coordinates);
        if (path == null) {
            simulationMap.setStop(false);
            System.out.println("There are no moves available!");
        } else {
            if (path.size() > velocity) {
                Coordinates newCoordinates = path.get(path.size() - velocity);
                simulationMap.removeFromMap(this);
                coordinates = newCoordinates;
            } else {
                simulationMap.removeFromMap(this);
                Coordinates newCoordinates = path.get(0);
                coordinates = newCoordinates;
                if (life < maxLife) {
                    life++;
                }
                simulationMap.setCountGrass(simulationMap.getCountGrass() - 1);
            }
            simulationMap.addToMap(this);
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
