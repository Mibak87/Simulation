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
                    herbivore.makeMove(map);
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
