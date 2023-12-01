package org.example;

import org.example.creatures.Creature;
import org.example.creatures.Herbivore;
import org.example.creatures.Predator;
import org.example.statics.Grass;

import java.util.ArrayDeque;
import java.util.ArrayList;
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

    private boolean stop;

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
        stop = true;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
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

    public void addToMap(Entity entity) {
        Coordinates coordinates = entity.getCoordinates();
        if (entity != null && !map.containsKey(coordinates)) {
            map.put(coordinates,entity);
        }
    }

    public void removeFromMap(Entity entity) {
        Coordinates coordinates = entity.getCoordinates();
        if (entity != null && map.containsKey(coordinates)) {
            map.remove(coordinates,entity);
        }
    }

    public ArrayList<Coordinates> findPath(Coordinates coordinates) {
        Coordinates endCell = null;
        ArrayDeque<Coordinates> queue = new ArrayDeque<>();
        ArrayList<Coordinates> visitedCell = new ArrayList<>();
        visitedCell.add(coordinates);
        coordinates.setPreviousCell(coordinates);
        Coordinates cell1 = new Coordinates(coordinates.getX() - 1, coordinates.getY());
        cell1.setPreviousCell(coordinates);
        queue.add(cell1);
        Coordinates cell2 = new Coordinates(coordinates.getX(), coordinates.getY() + 1);
        cell2.setPreviousCell(coordinates);
        queue.add(cell2);
        Coordinates cell3 = new Coordinates(coordinates.getX() + 1, coordinates.getY());
        cell3.setPreviousCell(coordinates);
        queue.add(cell3);
        Coordinates cell4 = new Coordinates(coordinates.getX(), coordinates.getY() - 1);
        cell4.setPreviousCell(coordinates);
        queue.add(cell4);
        while (!queue.isEmpty()) {
            Coordinates visitCell = queue.poll();
            visitedCell.add(visitCell);
            if (map.containsKey(visitCell)) {
                if (map.get(coordinates) instanceof Herbivore) {
                    if (map.get(visitCell) instanceof Grass) {
                        endCell = visitCell;
                        break;
                    }
                }
                if (map.get(coordinates) instanceof Predator) {
                    if (map.get(visitCell) instanceof Herbivore) {
                        endCell = visitCell;
                        break;
                    }
                }
            } else {
                Coordinates cellA = new Coordinates(visitCell.getX() - 1, visitCell.getY());
                cellA.setPreviousCell(visitCell);
                if (!visitedCell.contains(cellA) && cellA.getX() >= 0) {
                    queue.add(cellA);
                }
                Coordinates cellB = new Coordinates(visitCell.getX(), visitCell.getY() + 1);
                cellB.setPreviousCell(visitCell);
                if (!visitedCell.contains(cellB) && cellA.getY() <= height) {
                    queue.add(cellB);
                }
                Coordinates cellC = new Coordinates(visitCell.getX() + 1, visitCell.getY());
                cellC.setPreviousCell(visitCell);
                if (!visitedCell.contains(cellC) && cellA.getX() <= width) {
                    queue.add(cellC);
                }
                Coordinates cellD = new Coordinates(visitCell.getX(), visitCell.getY() - 1);
                cellD.setPreviousCell(visitCell);
                if (!visitedCell.contains(cellD) && cellA.getY() >= 0) {
                    queue.add(cellD);
                }
            }
        }
        if (endCell == null) {
            return null;
        } else {
            ArrayList<Coordinates> path = new ArrayList<>();
            path.add(endCell);
            Coordinates previous = endCell.getPreviousCell();
            while (previous != coordinates) {
                path.add(previous);
                previous = previous.getPreviousCell();
            }
            //path.add(previous);
            return path;
        }
    }

    @Override
    public String toString() {
        return "Map{" +
                "map=" + map +
                '}';
    }
}
