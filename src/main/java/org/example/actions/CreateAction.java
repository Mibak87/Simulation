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
        HashMap<Coordinates, Entity> newMap = simulationMap.getMap();
        if (newMap == null) {
            newMap = new HashMap<>();
        }
        //Creation grass entity
        for (int i = 1; i <= Simulation.countGrass; i++) {
            Grass grass = new Grass(generateCoordinates());
            newMap.put(grass.getCoordinates(),grass);
            simulationMap.setMap(newMap);
        }
        //Creation rock entity
        for (int i = 1; i <= Simulation.countRock; i++) {
            Rock rock = new Rock(generateCoordinates());
            newMap.put(rock.getCoordinates(),rock);
            simulationMap.setMap(newMap);
        }
        //Creation tree entity
        for (int i = 1; i <= Simulation.countTree; i++) {
            Tree tree = new Tree(generateCoordinates());
            newMap.put(tree.getCoordinates(),tree);
            simulationMap.setMap(newMap);
        }
        //Creation herbivore entity
        for (int i = 1; i <= Simulation.countHerbivore; i++) {
            Herbivore herbivore = new Herbivore(1,2, generateCoordinates());
            newMap.put(herbivore.getCoordinates(),herbivore);
            simulationMap.setMap(newMap);
        }
        //Creation predator entity
        for (int i = 1; i <= Simulation.countPredator; i++) {
            Predator predator = new Predator(1,2,1, generateCoordinates());
            newMap.put(predator.getCoordinates(),predator);
            simulationMap.setMap(newMap);
        }
    }

    private Coordinates generateCoordinates() {
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
