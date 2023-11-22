package org.example.actions;

import org.example.Coordinates;
import org.example.Entity;
import org.example.SimulationMap;
import org.example.creatures.Herbivore;
import org.example.creatures.Predator;
import org.example.statics.Grass;

import java.util.*;

public class TurnAction {

    public void turnAction(SimulationMap simulationMap) {
        HashMap<Coordinates, Entity> mapEntity = new HashMap<>(simulationMap.getMap());
        HashMap<Coordinates, Entity> mapAfterMoving = new HashMap<>(simulationMap.getMap());
        for (Coordinates coordinates : mapEntity.keySet()) {
            Entity entity = mapEntity.get(coordinates);
            if (entity instanceof Herbivore) {
                Herbivore herbivore = (Herbivore) entity;
                if (herbivore.getLife() > 0) {
                    Coordinates newHerbivoreCoordinates = herbivore.makeMove(simulationMap);
                    if (mapEntity.containsKey(newHerbivoreCoordinates)) {
                        if (mapEntity.get(newHerbivoreCoordinates) instanceof Grass) {
                            if (herbivore.getLife() < herbivore.getMaxLife()) {
                                herbivore.setLife(herbivore.getLife() + 1);
                            }
                            herbivore.setCoordinates(newHerbivoreCoordinates);
                            mapAfterMoving.put(newHerbivoreCoordinates, herbivore);
                            mapAfterMoving.remove(coordinates);
                            System.out.println("Herbivore is moving from " + coordinates.toString() + " to " + newHerbivoreCoordinates.toString());
                            System.out.println("Herbivore eat of the Grass");
                        } else {
                            herbivore.setCoordinates(coordinates);
                        }
                    } else {
                        herbivore.setCoordinates(newHerbivoreCoordinates);
                        mapAfterMoving.put(newHerbivoreCoordinates, herbivore);
                        mapAfterMoving.remove(coordinates);
                        System.out.println("Herbivore is moving from " + coordinates.toString() + " to " + newHerbivoreCoordinates.toString());
                    }
                }
            } else if (entity instanceof Predator) {
                Predator predator = (Predator) entity;
                Coordinates newPredatorCoordinates = predator.makeMove(simulationMap);
                if (mapEntity.containsKey(newPredatorCoordinates)) {
                    if (mapEntity.get(newPredatorCoordinates) instanceof Herbivore) {
                        Herbivore attackedHerbivore = (Herbivore) mapEntity.get(newPredatorCoordinates);
                        if (attackedHerbivore.getLife() <= predator.getAttackPower()) {
                            predator.setCoordinates(newPredatorCoordinates);
                            mapAfterMoving.put(newPredatorCoordinates,predator);
                            mapAfterMoving.remove(coordinates);
                            System.out.println("Predator is moving from " + coordinates.toString() + " to " + newPredatorCoordinates.toString());
                            System.out.println("Predator kill of the Herbivore");
                        } else {
                            predator.setCoordinates(coordinates);
                            attackedHerbivore.setLife(attackedHerbivore.getLife() - predator.getAttackPower());
                            mapAfterMoving.put(newPredatorCoordinates,attackedHerbivore);
                            System.out.println("Predator attack of the Herbivore");
                        }
                    } else {
                        predator.setCoordinates(coordinates);
                    }
                } else {
                    predator.setCoordinates(newPredatorCoordinates);
                    mapAfterMoving.put(newPredatorCoordinates, predator);
                    mapAfterMoving.remove(coordinates);
                    System.out.println("Predator is moving from " + coordinates.toString() + " to " + newPredatorCoordinates.toString());
                }
            }

        }
        simulationMap.setMap(mapAfterMoving);
    }
}
