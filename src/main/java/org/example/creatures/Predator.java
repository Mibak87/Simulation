package org.example.creatures;

import org.example.Coordinates;
import org.example.SimulationMap;

import java.util.ArrayList;

public class Predator extends Creature {
    private final int attackPower;

    public Predator(int velocity, int life, int attackPower, Coordinates coordinates) {
        super(velocity,life,coordinates);
        this.attackPower = attackPower;
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
                Coordinates newCoordinates = path.get(0);
                Herbivore herbivore = (Herbivore) simulationMap.getMap().get(newCoordinates);
                if (herbivore.getLife() <= attackPower) {
                    simulationMap.removeFromMap(this);
                    coordinates = newCoordinates;
                } else {
                    herbivore.setLife(herbivore.getLife() - attackPower);
                    simulationMap.addToMap(herbivore);
                }
            }
            simulationMap.addToMap(this);
        }
    }

    @Override
    public String toString() {
        return "Predator{" +
                "x=" + coordinates.getX() +
                " y=" + coordinates.getY() +
                '}';
    }
}
