package org.example.actions;

import org.example.Coordinates;
import org.example.Entity;
import org.example.SimulationMap;
import org.example.Simulation;
import org.example.creatures.Herbivore;
import org.example.creatures.Predator;
import org.example.statics.Grass;
import org.example.statics.Rock;
import org.example.statics.Tree;

import java.util.HashMap;

public class CreateAction {
    private SimulationMap simulationMap;

    public CreateAction(SimulationMap simulationMap) {
        this.simulationMap = simulationMap;
    }

    public void initAction() {
        //Creation grass entity
        for (int i = 1; i <= simulationMap.getCountGrass(); i++) {
            Grass grass = new Grass(generateCoordinates());
            simulationMap.addToMap(grass);
        }
        //Creation rock entity
        for (int i = 1; i <= simulationMap.getCountRock(); i++) {
            Rock rock = new Rock(generateCoordinates());
            simulationMap.addToMap(rock);
        }
        //Creation tree entity
        for (int i = 1; i <= simulationMap.getCountTree(); i++) {
            Tree tree = new Tree(generateCoordinates());
            simulationMap.addToMap(tree);
        }
        //Creation herbivore entity
        for (int i = 1; i <= simulationMap.getCountHerbivore(); i++) {
            Herbivore herbivore = new Herbivore(1,3,generateCoordinates());
            simulationMap.addToMap(herbivore);
        }
        //Creation predator entity
        for (int i = 1; i <= simulationMap.getCountPredator(); i++) {
            Predator predator = new Predator(2,2,1, generateCoordinates());
            simulationMap.addToMap(predator);
        }
    }

    public Coordinates generateCoordinates() {
        int x = (int) (Math.random() * simulationMap.getWidth());
        int y = (int) (Math.random() * simulationMap.getHeight());
        Coordinates coordinates = new Coordinates(x, y);
        while (!checkCoordinates(coordinates)) {
            x = (int) (Math.random() * simulationMap.getWidth());
            y = (int) (Math.random() * simulationMap.getHeight());
            coordinates = new Coordinates(x, y);
        }
        return coordinates;
    }

    private boolean checkCoordinates(Coordinates coordinates) {
        HashMap<Coordinates,Entity> tempMap = simulationMap.getMap();
        if (tempMap != null && tempMap.containsKey(coordinates)) {
            return false;
        } else {
            return true;
        }
    }
}
