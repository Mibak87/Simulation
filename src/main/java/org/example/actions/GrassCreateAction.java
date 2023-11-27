package org.example.actions;

import org.example.SimulationMap;
import org.example.statics.Grass;

public class GrassCreateAction {
    public void grassCreate(SimulationMap simulationMap) {
        CreateAction createAction = new CreateAction(simulationMap);
        Grass grass = new Grass(createAction.generateCoordinates());
        simulationMap.addToMap(grass);
    }
}
