package org.example;


import org.example.actions.CreateAction;
import org.example.actions.TurnAction;

public class Simulation {
    private SimulationMap simulationMap;
    private int moveCounter = 0;
    private Render render = new Render();
    private CreateAction createAction;
    private TurnAction turnAction;

    public void nextTurn() {
        while (simulationMap.isStop()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            moveCounter++;
            System.out.println(moveCounter);
            turnAction = new TurnAction();
            turnAction.turnAction(simulationMap);
            render.mapUpdate(simulationMap);
        }
    }

    public void startSimulation() {
        simulationMap = new SimulationMap(10,10);
        createAction = new CreateAction(simulationMap);
        createAction.initAction();
        System.out.println(moveCounter);
        render.mapUpdate(simulationMap);
    }

    public void pauseSimulation() {

    }



    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        simulation.startSimulation();
        simulation.nextTurn();
    }
}