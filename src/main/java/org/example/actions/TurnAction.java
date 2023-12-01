package org.example.actions;

import org.example.Coordinates;
import org.example.Entity;
import org.example.SimulationMap;
import org.example.creatures.Creature;
import org.example.creatures.Herbivore;
import org.example.creatures.Predator;
import org.example.statics.Grass;

import java.util.*;

public class TurnAction {

    public void turnAction(SimulationMap simulationMap) {
        HashMap<Coordinates, Entity> mapEntity = new HashMap<>(simulationMap.getMap());
        for (Coordinates coordinates : mapEntity.keySet()) {
            Entity entity = mapEntity.get(coordinates);
            if (entity instanceof Creature) {
                Creature creature = (Creature) entity;
                creature.makeMove(simulationMap);
            }
        }
    }
}
