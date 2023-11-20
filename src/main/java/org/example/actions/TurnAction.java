package org.example.actions;

import org.example.Coordinates;
import org.example.Entity;
import org.example.Map;
import org.example.creatures.Herbivore;
import org.example.creatures.Predator;
import org.example.statics.Grass;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TurnAction {

    public void turnAction(Map map) {
        HashMap<Coordinates, Entity> mapEntity = map.getMap();
        Set<Coordinates> keys = mapEntity.keySet();
        Set<Coordinates> removedKeys = new HashSet<>();
        double randomNumber = Math.random();
        if (randomNumber < 0.5) {
            System.out.println("The Herbivore is moving");
            Iterator<Coordinates> it = keys.iterator();
            while (it.hasNext()) {
                Coordinates coordinates = it.next();
                if (removedKeys.contains(coordinates)) {
                    it.remove();
                    mapEntity.remove(coordinates);
                } else {
                    if (mapEntity.get(coordinates) instanceof Herbivore) {
                        Herbivore herbivore = (Herbivore) mapEntity.get(coordinates);
                        herbivore.makeMove(map);
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
                    }
                }
            }
        } else {
            System.out.println("The Predator is moving");
            Iterator<Coordinates> it = keys.iterator();
            while (it.hasNext()) {
                Coordinates coordinates = it.next();
                if (removedKeys.contains(coordinates)) {
                    it.remove();
                    mapEntity.remove(coordinates);
                } else {
                    if (mapEntity.get(coordinates) instanceof Predator) {
                        Predator predator = (Predator) mapEntity.get(coordinates);
                        predator.makeMove(map);
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
                        //mapEntity = map.getMap();
                    }
                }
            }
        }
        map.setMap(mapEntity);
    }
}
