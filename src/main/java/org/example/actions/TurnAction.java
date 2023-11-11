package org.example.actions;

import org.example.Coordinates;
import org.example.Entity;
import org.example.Map;
import org.example.creatures.Herbivore;
import org.example.creatures.Predator;

import java.util.HashMap;

public class TurnAction {
    private Map map;

    public TurnAction(Map map) {
        this.map = map;
    }

    public void turnAction() {
        HashMap<Coordinates, Entity> mapEntity = map.getMap();
        double randomNumber = Math.random();
        if (randomNumber < 0.5) {
            for (Coordinates coordinates: mapEntity.keySet()) {
                if (mapEntity.get(coordinates) instanceof Herbivore) {
                    Herbivore herbivore = (Herbivore) mapEntity.get(coordinates);
                    mapEntity.remove(coordinates);
                    herbivore.makeMove();
                    if (mapEntity.containsKey(herbivore.getCoordinates())) {
                        mapEntity.put(herbivore.getCoordinates(),herbivore);
                    }
                }
            }
        } else {
            for (Coordinates coordinates: mapEntity.keySet()) {
                if (mapEntity.get(coordinates) instanceof Predator) {
                    Predator predator = (Predator) mapEntity.get(coordinates);
                    predator.makeMove();
                    Coordinates newCoordinates = predator.getCoordinates();
                    if (mapEntity.containsKey(newCoordinates)) {
                        Herbivore herbivore = (Herbivore) mapEntity.get(newCoordinates);
                        int herbivoreLife = herbivore.getLife() - predator.getAttackPower();
                        if (isHerbivoreDie(herbivoreLife)) {
                            mapEntity.remove(coordinates);
                            mapEntity.put(newCoordinates,predator);
                        } else {
                            herbivore.setLife(herbivoreLife);
                            mapEntity.put(newCoordinates,herbivore);
                            mapEntity.put(coordinates,predator);
                        }
                    } else {
                        mapEntity.put(newCoordinates,predator);
                    }
                }
            }
        }
    }

    private boolean isHerbivoreDie(int herbivoreLife) {

        if (herbivoreLife <= 0) {
            return true;
        } else {
            return false;
        }
    }
}
