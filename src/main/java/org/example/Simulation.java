package org.example;


import org.example.actions.CreateAction;
import org.example.actions.TurnAction;

public class Simulation {
    private SimulationMap simulationMap;
    private int moveCounter = 0;
    private Render render = new Render();
    private CreateAction createAction;
    private TurnAction turnAction;
    public static int countHerbivore = 1;
    public static int countPredator = 1;
    public static int countGrass = 3;
    public static int countRock = 3;
    public static int countTree = 3;

    public void nextTurn() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            moveCounter++;
            System.out.println(moveCounter);
            turnAction = new TurnAction();
            turnAction.turnAction(simulationMap);
            render.mapUpdate(simulationMap);
            System.out.println(simulationMap.toString());
        }
    }

    public void startSimulation() {
        simulationMap = new SimulationMap(10,10);
        createAction = new CreateAction(simulationMap);
        createAction.initAction();
        System.out.println(moveCounter);
        render.mapUpdate(simulationMap);
        System.out.println(simulationMap.toString());
    }

    public void pauseSimulation() {

    }



    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        simulation.startSimulation();
        simulation.nextTurn();
    }
}