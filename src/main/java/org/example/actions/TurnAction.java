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
                    herbivore.makeMove(simulationMap);
                    Coordinates newHerbivoreCoordinates = herbivore.getCoordinates();
                    if (mapEntity.containsKey(newHerbivoreCoordinates)) {
                        if (mapEntity.get(newHerbivoreCoordinates) instanceof Grass) {
                            if (herbivore.getLife() < herbivore.getMaxLife()) {
                                herbivore.setLife(herbivore.getLife() + 1);
                                //mapEntity.put(coordinates,herbivore);
                            }
                            mapAfterMoving.put(newHerbivoreCoordinates, herbivore);
                            mapAfterMoving.remove(coordinates);
                        } else {
                            herbivore.setCoordinates(coordinates);
                        }
                    } else {
                        mapAfterMoving.put(newHerbivoreCoordinates, herbivore);
                    }
                }
            } else if (entity instanceof Predator) {
                Predator predator = (Predator) entity;
                predator.makeMove(simulationMap);
                Coordinates newPredatorCoordinates = predator.getCoordinates();
                if (mapEntity.containsKey(newPredatorCoordinates)) {
                    if (mapEntity.get(newPredatorCoordinates) instanceof Herbivore) {
                        Herbivore attackedHerbivore = (Herbivore) mapEntity.get(newPredatorCoordinates);
                        if (attackedHerbivore.getLife() <= predator.getAttackPower()) {
                            mapAfterMoving.put(newPredatorCoordinates,predator);
                            mapAfterMoving.remove(coordinates);
                        } else {
                            predator.setCoordinates(coordinates);
                            attackedHerbivore.setLife(attackedHerbivore.getLife() - predator.getAttackPower());
                            mapAfterMoving.put(newPredatorCoordinates,attackedHerbivore);
                        }
                    } else {
                        predator.setCoordinates(coordinates);
                    }
                } else {
                    mapAfterMoving.put(newPredatorCoordinates, predator);
                }
            }

        }
        simulationMap.setMap(mapAfterMoving);
    }
}
