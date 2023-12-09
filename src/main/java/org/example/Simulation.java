package org.example;


import org.example.actions.CreateAction;
import org.example.actions.TurnAction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Simulation {
    private SimulationMap simulationMap;
    private int moveCounter = 0;
    private final Render render = new Render();

    public void nextTurn() {
        while (simulationMap.isStop()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            moveCounter++;
            System.out.println(moveCounter);
            TurnAction turnAction = new TurnAction();
            turnAction.turnAction(simulationMap);
            render.mapUpdate(simulationMap);
        }
    }

    public void startSimulation() {
        simulationMap = new SimulationMap(15,15);
        CreateAction createAction = new CreateAction(simulationMap);
        createAction.initAction();
        System.out.println(moveCounter);
        render.mapUpdate(simulationMap);
    }

    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        simulation.startSimulation();
        simulation.nextTurn();
    }
}