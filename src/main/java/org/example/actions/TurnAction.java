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
        HashMap<Coordinates, Entity> mapEntity = simulationMap.getMap();
        Set<Coordinates> removedKeys = new HashSet<>();
        Iterator<Map.Entry<Coordinates, Entity>> iterator = mapEntity.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Coordinates, Entity> entry = iterator.next();
                Coordinates coordinates = entry.getKey();
                Entity entity = entry.getValue();
                if (removedKeys.contains(coordinates)) {
                    iterator.remove();
                    //mapEntity.remove(coordinates);
                } else {
                    if (entity instanceof Herbivore) {
                        Herbivore herbivore = (Herbivore) entity;
                        herbivore.makeMove(simulationMap);
                        Coordinates newHerbivoreCoordinates = herbivore.getCoordinates();
                        if (mapEntity.containsKey(newHerbivoreCoordinates)) {
                            if (mapEntity.get(newHerbivoreCoordinates) instanceof Grass) {
                                if (herbivore.getLife() < herbivore.getMaxLife()) {
                                    herbivore.setLife(herbivore.getLife() + 1);
                                }
                                removedKeys.add(newHerbivoreCoordinates);
                                mapEntity.put(newHerbivoreCoordinates,herbivore);
                            } else {
                                herbivore.setCoordinates(coordinates);
                            }
                        } else {
                            mapEntity.put(newHerbivoreCoordinates,herbivore);
                        }
                        //mapEntity = map.getMap();
                    } else if(entity instanceof Predator) {
                        Predator predator = (Predator) entity;
                        predator.makeMove(simulationMap);
                        Coordinates newPredatorCoordinates = predator.getCoordinates();
                        if (mapEntity.containsKey(newPredatorCoordinates)) {
                            if (mapEntity.get(newPredatorCoordinates) instanceof Herbivore) {
                                Herbivore attackedHerbivore = (Herbivore) mapEntity.get(newPredatorCoordinates);
                                if (attackedHerbivore.getLife() <= predator.getAttackPower()) {
                                    removedKeys.add(newPredatorCoordinates);
                                    mapEntity.put(newPredatorCoordinates,predator);
                                } else {
                                    predator.setCoordinates(coordinates);
                                    attackedHerbivore.setLife(attackedHerbivore.getLife() - predator.getAttackPower());
                                }
                            } else {
                                predator.setCoordinates(coordinates);
                            }
                        } else {
                            mapEntity.put(newPredatorCoordinates,predator);
                        }
                    }
                }
            }
        simulationMap.setMap(mapEntity);
    }
}
