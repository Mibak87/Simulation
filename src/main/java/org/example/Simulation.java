package org.example;


import org.example.actions.CreateAction;
import org.example.creatures.Herbivore;
import org.example.creatures.Predator;
import org.example.staticentity.Grass;
import org.example.staticentity.Rock;
import org.example.staticentity.Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Simulation {
    private Map map;
    private int moveCounter = 0;
    private Render render;
    private CreateAction createAction;
    public static int countHerbivore = 1;
    public static int countPredator = 1;
    public static int countGrass = 3;
    public static int countRock = 3;
    public static int countTree = 3;

    public void nextTurn() {
        moveCounter++;
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