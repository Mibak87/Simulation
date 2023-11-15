package org.example.creatures;

import org.example.Coordinates;
import org.example.Map;
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
    public void makeMove(Map map) {
        Coordinates grassCoordinates = map.findNearestEntity(this);
        Coordinates moveByY = this.coordinates;
        Coordinates moveByX = this.coordinates;
        int y = this.coordinates.getY();
        int x = this.coordinates.getX();
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
        if (map.findPathLength(moveByX,grassCoordinates) >= map.findPathLength(moveByY,grassCoordinates)) {
            this.setCoordinates(moveByY);
        } else {
            this.setCoordinates(moveByX);
        }

    }
}
