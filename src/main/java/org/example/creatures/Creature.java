package org.example.creatures;

import org.example.Coordinates;
import org.example.Entity;
import org.example.SimulationMap;

import java.util.HashMap;

public class Creature extends Entity {
    protected final int velocity;
    protected int life;
    protected Coordinates coordinates;

    public Creature(int velocity, int life, Coordinates coordinates) {
        this.velocity = velocity;
        this.life = life;
        this.coordinates = coordinates;
    }

    public int getVelocity() {
        return velocity;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }



    public Coordinates makeMove(SimulationMap simulationMap) {
        HashMap<Coordinates, Entity> currentMap = new HashMap<>(simulationMap.getMap());
        Coordinates coordinatesAfterMoving = new Coordinates(this.getCoordinates().getX(),this.getCoordinates().getY());
        for (int i = 1; i <= this.velocity; i++) {
            Coordinates entityCoordinate = simulationMap.findNearestEntity(this);
            int y = this.coordinates.getY();
            int x = this.coordinates.getX();
            Coordinates moveByY = new Coordinates(x,y);
            Coordinates moveByX = new Coordinates(x,y);
            if (entityCoordinate.getY() > y) {
                moveByY.setY(y + 1);
            } else if (entityCoordinate.getY() < y) {
                moveByY.setY(y - 1);
            }
            if (entityCoordinate.getX() > x) {
                moveByX.setX(x + 1);
            } else if (entityCoordinate.getX() < x) {
                moveByX.setX(x - 1);
            }
            if (simulationMap.findPathLength(moveByX, entityCoordinate) >= simulationMap.findPathLength(moveByY, entityCoordinate)) {
                if (!currentMap.containsKey(moveByY) || moveByY.equals(entityCoordinate)) {
                    coordinatesAfterMoving = moveByY;
                }
            } else {
                if (!currentMap.containsKey(moveByX) || moveByX.equals(entityCoordinate)) {
                    coordinatesAfterMoving = moveByX;
                }
            }
        }
        return coordinatesAfterMoving;
    }
}
