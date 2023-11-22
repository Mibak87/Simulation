package org.example.creatures;

import org.example.Coordinates;
import org.example.Entity;
import org.example.SimulationMap;

import java.util.HashMap;

public class Predator extends Creature {
    private final int attackPower;

    public Predator(int velocity, int life, int attackPower, Coordinates coordinates) {
        super(velocity,life,coordinates);
        this.attackPower = attackPower;
    }

    public int getAttackPower() {
        return attackPower;
    }

    @Override
    public String toString() {
        return "Predator{" +
                "x=" + coordinates.getX() +
                " y=" + coordinates.getY() +
                '}';
    }

    @Override
    public Coordinates makeMove(SimulationMap simulationMap) {
        HashMap<Coordinates, Entity> currentMap = new HashMap<>(simulationMap.getMap());
        Coordinates coordinatesAfterMoving = new Coordinates(this.getCoordinates().getX(),this.getCoordinates().getY());
        for (int i = 1; i <= this.velocity; i++) {
            Coordinates herbivoreCoordinates = simulationMap.findNearestEntity(this);
            int y = this.coordinates.getY();
            int x = this.coordinates.getX();
            Coordinates moveByY = new Coordinates(x,y);
            Coordinates moveByX = new Coordinates(x,y);
            if (herbivoreCoordinates.getY() > y) {
                moveByY.setY(y + 1);
            } else if (herbivoreCoordinates.getY() < y) {
                moveByY.setY(y - 1);
            }
            if (herbivoreCoordinates.getX() > x) {
                moveByX.setX(x + 1);
            } else if (herbivoreCoordinates.getX() < x) {
                moveByX.setX(x - 1);
            }
            if (simulationMap.findPathLength(moveByX, herbivoreCoordinates) >= simulationMap.findPathLength(moveByY, herbivoreCoordinates)) {
                if (!currentMap.containsKey(moveByY) || moveByY.equals(herbivoreCoordinates)) {
                    coordinatesAfterMoving = moveByY;
                }
            } else {
                if (!currentMap.containsKey(moveByX) || moveByX.equals(herbivoreCoordinates)) {
                    coordinatesAfterMoving = moveByX;
                }
            }
            /*if (this.coordinates.equals(herbivoreCoordinates)) {
                Herbivore herbivore = (Herbivore) currentMap.get(herbivoreCoordinates);
                if (herbivore.life <= this.attackPower) {
                    currentMap.remove(new Coordinates(x, y), this);
                    currentMap.put(this.coordinates, this);
                } else {
                    herbivore.setLife(herbivore.life - this.attackPower);
                    currentMap.put(herbivoreCoordinates,herbivore);
                    this.setCoordinates(new Coordinates(x,y));
                }
            }
            map.setMap(currentMap);
             */
        }
        return coordinatesAfterMoving;
    }
}
