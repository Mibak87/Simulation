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
    private int herbivoreCount = 0;
    public void turnAction(SimulationMap simulationMap) {
        int cellCount = simulationMap.getHeight() * simulationMap.getWidth();
        if (simulationMap.getCountGrass() < (int) (cellCount * 0.05)) {
            GrassCreateAction.grassCreate(simulationMap);
        }
        if (simulationMap.getCountHerbivore() < (int) (cellCount * 0.02)) {
            HerbivoreCreateAction.herbivoreCreate(simulationMap);
        }
        HashMap<Coordinates, Entity> mapEntity = new HashMap<>(simulationMap.getMap());
        for (Coordinates coordinates : mapEntity.keySet()) {
            Entity entity = mapEntity.get(coordinates);
            if (entity instanceof Creature) {
                Creature creature = (Creature) entity;
                creature.makeMove(simulationMap);
                if (creature instanceof Herbivore) {
                    herbivoreCount++;
                }
            }
        }
        simulationMap.setCountHerbivore(herbivoreCount);
    }
}
