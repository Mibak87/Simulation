package org.example;


import org.example.creatures.Herbivore;
import org.example.creatures.Predator;
import org.example.staticentity.Grass;
import org.example.staticentity.Rock;
import org.example.staticentity.Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Simulation {
    private Map map;
    private int moveCounter = 0;
    private Render render;
    private Actions actions;
    private int countHerbivore = 1;
    private int countPredator = 1;
    private int countGrass = 3;
    private int countRock = 3;
    private int countTree = 3;

    public void nextTurn() {
        moveCounter++;
    }

    public void startSimulation() {
        map = new Map(10,10);
        HashMap<Coordinates,Entity> newMap = map.getMap();
        if (newMap == null) {
            newMap = new HashMap<>();
        }
        //Creation grass entity
        for (int i = 1; i <= countGrass; i++) {
            Grass grass = new Grass(generateCoordinates());
            newMap.put(grass.getCoordinates(),grass);
            map.setMap(newMap);
        }
        //Creation rock entity
        for (int i = 1; i <= countRock; i++) {
            Rock rock = new Rock(generateCoordinates());
            newMap.put(rock.getCoordinates(),rock);
            map.setMap(newMap);
        }
        //Creation tree entity
        for (int i = 1; i <= countTree; i++) {
            Tree tree = new Tree(generateCoordinates());
            newMap.put(tree.getCoordinates(),tree);
            map.setMap(newMap);
        }
        //Creation herbivore entity
        for (int i = 1; i <= countHerbivore; i++) {
            Herbivore herbivore = new Herbivore(2,2, generateCoordinates());
            newMap.put(herbivore.getCoordinates(),herbivore);
            map.setMap(newMap);
        }
        //Creation predator entity
        for (int i = 1; i <= countPredator; i++) {
            Predator predator = new Predator(3,2,1, generateCoordinates());
            newMap.put(predator.getCoordinates(),predator);
            map.setMap(newMap);
        }
        System.out.println(map.toString());
    }

    public void pauseSimulation() {

    }

    private Coordinates generateCoordinates() {
        int x = (int) (Math.random() * map.getWidth());
        int y = (int) (Math.random() * map.getHeight());
        Coordinates coordinates = new Coordinates(x, y);
        while (!checkCoordinates(coordinates)) {
            x = (int) (Math.random() * map.getWidth());
            y = (int) (Math.random() * map.getHeight());
            coordinates = new Coordinates(x, y);
        }
        return coordinates;
    }

    private boolean checkCoordinates(Coordinates coordinates) {
        HashMap<Coordinates,Entity> tempMap = map.getMap();
        if (tempMap != null && tempMap.containsKey(coordinates)) {
            return false;
        } else {
            return true;
        }
        /*Set<Grass> grasses = map.getGrasses();
        Set<Rock> rocks = map.getRocks();
        Set<Tree> trees = map.getTrees();
        Set<Predator> predators = map.getPredators();
        Set<Herbivore> herbivores = map.getHerbivores();
        if (grasses != null) {
            for (Grass grass : grasses) {
                if (coordinates.equals(grass.getCoordinates())) {
                    return false;
                }
            }
        }
        if (rocks != null) {
            for (Rock rock : rocks) {
                if (coordinates.equals(rock.getCoordinates())) {
                    return false;
                }
            }
        }
        if (trees != null) {
            for (Tree tree : trees) {
                if (coordinates.equals(tree.getCoordinates())) {
                    return false;
                }
            }
        }
        if (predators != null) {
            for (Predator predator : predators) {
                if (coordinates.equals(predator.getCoordinates())) {
                    return false;
                }
            }
        }
        if (herbivores != null) {
            for (Herbivore herbivore : herbivores) {
                if (coordinates.equals(herbivore.getCoordinates())) {
                    return false;
                }
            }
        }
        return true;
         */
    }

    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        simulation.startSimulation();
    }
}