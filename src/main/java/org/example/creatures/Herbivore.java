package org.example.creatures;

import org.example.Coordinates;
import org.example.Entity;
import org.example.Map;
import org.example.creatures.Creature;

import java.util.HashMap;

public class Herbivore extends Creature {
    private final int maxLife = 2;
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
        HashMap<Coordinates, Entity> currentMap = map.getMap();
        for (int i = 1; i <= this.velocity; i++) {
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
            if (map.findPathLength(moveByX, grassCoordinates) >= map.findPathLength(moveByY, grassCoordinates)) {
                if (!currentMap.containsKey(moveByY) && moveByY.equals(grassCoordinates)) {
                    this.setCoordinates(moveByY);
                }
            } else {
                if (!currentMap.containsKey(moveByX) && moveByX.equals(grassCoordinates)) {
                    this.setCoordinates(moveByX);
                }
            }
            if (this.coordinates.equals(grassCoordinates) & this.life < maxLife) {
                this.life++;
            }
            currentMap.remove(new Coordinates(x, y), this);
            currentMap.put(this.coordinates, this);
            map.setMap(currentMap);
        }
    }
}
