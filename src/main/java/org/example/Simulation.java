package org.example;


import org.example.actions.CreateAction;
import org.example.actions.TurnAction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
            System.out.println("Print 'e' to stop Simulation.");
        }
    }

    public void startSimulation() {
        simulationMap = new SimulationMap(15,15);
        createAction = new CreateAction(simulationMap);
        createAction.initAction();
        System.out.println(moveCounter);
        render.mapUpdate(simulationMap);
    }

    public void stopSimulation() {
        simulationMap.setStop(false);
        System.out.println("Stop of Simulation");
    }

    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                    String str = reader.readLine();
                    if (str.equals("e")) {
                        simulation.stopSimulation();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread threadDaemon = new Thread(task);
        threadDaemon.setDaemon(true);
        threadDaemon.start();
        simulation.startSimulation();
        simulation.nextTurn();
    }
}