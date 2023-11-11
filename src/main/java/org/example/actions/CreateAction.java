package org.example.actions;

import org.example.Coordinates;
import org.example.Entity;
import org.example.Map;
import org.example.Simulation;
import org.example.creatures.Herbivore;
import org.example.creatures.Predator;
import org.example.staticentity.Grass;
import org.example.staticentity.Rock;
import org.example.staticentity.Tree;

import java.util.HashMap;

public class CreateAction {
    private Map map;

    public CreateAction(Map map) {
        this.map = map;
    }

    public void initAction() {
        HashMap<Coordinates, Entity> newMap = map.getMap();
        if (newMap == null) {
            newMap = new HashMap<>();
        }
        //Creation grass entity
        for (int i = 1; i <= Simulation.countGrass; i++) {
            Grass grass = new Grass(generateCoordinates());
            newMap.put(grass.getCoordinates(),grass);
            map.setMap(newMap);
        }
        //Creation rock entity
        for (int i = 1; i <= Simulation.countRock; i++) {
            Rock rock = new Rock(generateCoordinates());
            newMap.put(rock.getCoordinates(),rock);
            map.setMap(newMap);
        }
        //Creation tree entity
        for (int i = 1; i <= Simulation.countTree; i++) {
            Tree tree = new Tree(generateCoordinates());
            newMap.put(tree.getCoordinates(),tree);
            map.setMap(newMap);
        }
        //Creation herbivore entity
        for (int i = 1; i <= Simulation.countHerbivore; i++) {
            Herbivore herbivore = new Herbivore(2,2, generateCoordinates());
            newMap.put(herbivore.getCoordinates(),herbivore);
            map.setMap(newMap);
        }
        //Creation predator entity
        for (int i = 1; i <= Simulation.countPredator; i++) {
            Predator predator = new Predator(3,2,1, generateCoordinates());
            newMap.put(predator.getCoordinates(),predator);
            map.setMap(newMap);
        }
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
    }
}
