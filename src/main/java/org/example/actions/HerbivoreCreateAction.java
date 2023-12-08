package org.example.actions;

import org.example.SimulationMap;
import org.example.creatures.Herbivore;

public class HerbivoreCreateAction {
    public static void herbivoreCreate(SimulationMap simulationMap) {
        CreateAction createAction = new CreateAction(simulationMap);
        Herbivore herbivore = new Herbivore(1,3,createAction.generateCoordinates());
        simulationMap.addToMap(herbivore);
        simulationMap.setCountHerbivore(simulationMap.getCountHerbivore() + 1);
    }
}
