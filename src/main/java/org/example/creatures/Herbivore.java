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
        System.out.println(path);
        if (path == null) {
            simulationMap.setStop(false);
            System.out.println("There are no moves available!");
        } else {
            if (path.size() > velocity) {
                Coordinates newCoordinates = path.get(path.size() - velocity);
                System.out.println("Herbivore is moving from " + coordinates.toString() + " to " + newCoordinates.toString());
                simulationMap.removeFromMap(this);
                coordinates = newCoordinates;
            } else {
                simulationMap.removeFromMap(this);
                Coordinates newCoordinates = path.get(path.size() - 1);
                coordinates = newCoordinates;
                if (life < maxLife) {
                    life++;
                }
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
