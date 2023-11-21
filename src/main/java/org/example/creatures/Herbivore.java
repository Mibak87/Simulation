package org.example.creatures;

import org.example.Coordinates;
import org.example.Entity;
import org.example.SimulationMap;

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
    public String toString() {
        return "Herbivore{" +
                "x=" + coordinates.getX() +
                " y=" + coordinates.getY() +
                '}';
    }

    @Override
    public Coordinates makeMove(SimulationMap simulationMap) {
        HashMap<Coordinates, Entity> currentMap = new HashMap<>(simulationMap.getMap());
        Coordinates coordinatesAfterMoving = new Coordinates(this.getCoordinates().getX(),this.getCoordinates().getY());
        for (int i = 1; i <= this.velocity; i++) {
            Coordinates grassCoordinates = simulationMap.findNearestEntity(this);
            int y = this.coordinates.getY();
            int x = this.coordinates.getX();
            Coordinates moveByY = new Coordinates(x,y);
            Coordinates moveByX = new Coordinates(x,y);
            if (grassCoordinates.getY() > y) {
                moveByY.setY(y + 1);
            } else if (grassCoordinates.getY() < y) {
                moveByY.setY(y - 1);
            }
            if (grassCoordinates.getX() > x) {
                moveByX.setX(x + 1);
            } else if (grassCoordinates.getX() < x) {
                moveByX.setX(x - 1);
            }
            if (simulationMap.findPathLength(moveByX, grassCoordinates) >= simulationMap.findPathLength(moveByY, grassCoordinates)) {
                if (!currentMap.containsKey(moveByY) || moveByY.equals(grassCoordinates)) {
                    coordinatesAfterMoving = moveByY;
                }
            } else {
                if (!currentMap.containsKey(moveByX) || moveByX.equals(grassCoordinates)) {
                    coordinatesAfterMoving = moveByX;
                }
            }
            /*if (this.coordinates.equals(grassCoordinates) & this.life < maxLife) {
                this.life++;
            }
            currentMap.remove(new Coordinates(x, y), this);
            currentMap.put(this.coordinates, this);
            map.setMap(currentMap);
             */
        }
        return coordinatesAfterMoving;
    }
}
