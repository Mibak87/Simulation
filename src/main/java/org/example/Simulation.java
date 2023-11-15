package org.example;


import org.example.actions.CreateAction;
import org.example.actions.TurnAction;

public class Simulation {
    private Map map;
    private int moveCounter = 0;
    private Render render;
    private CreateAction createAction;
    private TurnAction turnAction;
    public static int countHerbivore = 1;
    public static int countPredator = 1;
    public static int countGrass = 3;
    public static int countRock = 3;
    public static int countTree = 3;

    public void nextTurn() {
        moveCounter++;
        turnAction = new TurnAction(map);
    }

    public void startSimulation() {
        map = new Map(10,10);
        createAction = new CreateAction(map);
        createAction.initAction();
        //System.out.println(map.toString());
        render = new Render();
        render.mapUpdate(map);
    }

    public void pauseSimulation() {

    }



    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        simulation.startSimulation();
    }
}