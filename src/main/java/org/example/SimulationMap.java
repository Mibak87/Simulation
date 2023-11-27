package org.example;

import org.example.creatures.Creature;
import org.example.creatures.Herbivore;
import org.example.creatures.Predator;
import org.example.statics.Grass;

import java.util.HashMap;

public class SimulationMap {
    private HashMap<Coordinates,Entity> map;
    private int width;
    private int height;
    private int countHerbivore;
    private int countPredator;
    private int countGrass;
    private int countRock;
    private int countTree;

    public SimulationMap(int width, int height) {
        this.width = width;
        this.height = height;
        int cellCount = width * height;
        countGrass = (int) (cellCount * 0.05);
        countRock = (int) (cellCount * 0.05);
        countTree = (int) (cellCount * 0.05);
        countHerbivore = (int) (cellCount * 0.02);
        countPredator = (int) (cellCount * 0.02);
        HashMap<Coordinates,Entity> map = new HashMap<>();
    }

    public HashMap<Coordinates, Entity> getMap() {
        return map;
    }

    public void setMap(HashMap<Coordinates, Entity> map) {
        this.map = map;
    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getCountHerbivore() {
        return countHerbivore;
    }

    public int getCountPredator() {
        return countPredator;
    }

    public int getCountGrass() {
        return countGrass;
    }

    public int getCountRock() {
        return countRock;
    }

    public int getCountTree() {
        return countTree;
    }

    public Coordinates findNearestEntity(Creature creature) {
        if (creature instanceof Herbivore) {
            return findGrass((Herbivore) creature);
        } else {
            return findHerbivore((Predator) creature);
        }
    }

    private Coordinates findGrass(Herbivore herbivore) {
        Coordinates grassCoordinates = new Coordinates(0,0);
        int minPathLength = findPathLength(new Coordinates(1,1),new Coordinates(width,height));
        for (Coordinates coordinates: map.keySet()) {
            if (map.get(coordinates) instanceof Grass) {
                int pathLength = findPathLength(herbivore.getCoordinates(),coordinates);
                if (pathLength < minPathLength) {
                    minPathLength = pathLength;
                    grassCoordinates = coordinates;
                }
            }
        }
        return grassCoordinates;
    }

    private Coordinates findHerbivore(Predator predator) {
        Coordinates herbivoreCoordinates = new Coordinates(0,0);
        int minPathLength = findPathLength(new Coordinates(1,1),new Coordinates(width,height));
        for (Coordinates coordinates: map.keySet()) {
            if (map.get(coordinates) instanceof Herbivore) {
                int pathLength = findPathLength(predator.getCoordinates(),coordinates);
                if (pathLength < minPathLength) {
                    minPathLength = pathLength;
                    herbivoreCoordinates = coordinates;
                }
            }
        }
        return herbivoreCoordinates;
    }

    public int findPathLength(Coordinates coordinates1, Coordinates coordinates2) {
        int deltaX = Math.abs(coordinates1.getX() - coordinates2.getX());
        int deltaY = Math.abs(coordinates1.getY() - coordinates2.getY());
        return (int) Math.sqrt(deltaY * deltaY + deltaX * deltaX);
    }

    public void addToMap(Entity entity) {
        Coordinates coordinates = entity.getCoordinates();
        if (entity != null && !map.containsKey(coordinates)) {
            map.put(coordinates,entity);
        }
    }

    @Override
    public String toString() {
        return "Map{" +
                "map=" + map +
                '}';
    }
}
