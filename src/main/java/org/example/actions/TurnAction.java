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
    private Map map;

    public TurnAction(Map map) {
        this.map = map;
    }

    public void turnAction() {
        HashMap<Coordinates, Entity> mapEntity = map.getMap();
        Set<Coordinates> keys = mapEntity.keySet();
        Set<Coordinates> removedKeys = new HashSet<>();
        double randomNumber = Math.random();
        if (randomNumber < 0.5) {
            Iterator<Coordinates> it = keys.iterator();
            while (it.hasNext()) {
                Coordinates coordinates = it.next();
                if (mapEntity.get(coordinates) instanceof Herbivore) {
                    Herbivore herbivore = (Herbivore) mapEntity.get(coordinates);
                    herbivore.makeMove(map);
                    Coordinates newHerbivoreCoordinates = herbivore.getCoordinates();
                    if (mapEntity.containsKey(newHerbivoreCoordinates)) {
                        if (mapEntity.get(newHerbivoreCoordinates) instanceof Grass) {
                            if (herbivore.getLife() < herbivore.getMaxLife()) {
                                herbivore.setLife(herbivore.getLife() + 1);
                            }
                            it.remove();
                        } else {
                            herbivore.setCoordinates(coordinates);
                        }
                    }
                    mapEntity = map.getMap();
                }
            }
        } else {
            for (Coordinates coordinates: mapEntity.keySet()) {
                if (mapEntity.get(coordinates) instanceof Predator) {
                    Predator predator = (Predator) mapEntity.get(coordinates);
                    predator.makeMove(map);
                    mapEntity = map.getMap();
                }
            }
        }
    }
}
