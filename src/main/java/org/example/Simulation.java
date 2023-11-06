package org.example;


import org.example.creatures.Herbivore;
import org.example.creatures.Predator;
import org.example.staticentity.Grass;
import org.example.staticentity.Rock;
import org.example.staticentity.Tree;

import java.util.Set;

public class Simulation {
    private Map map;
    private int moveCounter = 0;
    private Render render;
    private Actions actions;
    private int countHerbivore = 1;
    private int countPredator = 1;
    private int countGrass = 3;
    private int countRock = 3;
    private int countTree = 3;

    public void nextTurn() {
        moveCounter++;
    }

    public void startSimulation() {
        map = new Map(10,10);
        //Creation grass entity
        for (int i = 1; i <= countGrass; i++) {
            Grass grass = new Grass(generateCoordinates());
            Set<Grass> grasses = map.getGrasses();
            grasses.add(grass);
            map.setGrasses(grasses);
        }
        //Creation rock entity
        for (int i = 1; i <= countRock; i++) {
            Rock rock = new Rock(generateCoordinates());
            Set<Rock> rocks = map.getRocks();
            rocks.add(rock);
            map.setRocks(rocks);
        }
        //Creation tree entity
        for (int i = 1; i <= countTree; i++) {
            Tree tree = new Tree(generateCoordinates());
            Set<Tree> trees = map.getTrees();
            trees.add(tree);
            map.setTrees(trees);
        }
        //Creation herbivore entity
        for (int i = 1; i <= countHerbivore; i++) {
            Herbivore herbivore = new Herbivore(2,2, generateCoordinates());
            Set<Herbivore> herbivores = map.getHerbivores();
            herbivores.add(herbivore);
            map.setHerbivores(herbivores);
        }
        //Creation predator entity
        for (int i = 1; i <= countPredator; i++) {
            Predator predator = new Predator(3,2,1, generateCoordinates());
            Set<Predator> predators = map.getPredators();
            predators.add(predator);
            map.setPredators(predators);
        }
    }

    public void pauseSimulation() {

    }

    private Coordinates generateCoordinates() {
        int x = (int) (Math.random() * map.getWidth());
        int y = (int) (Math.random() * map.getHeight());
        Coordinates coordinates = new Coordinates(x, y);
        while (!checkCoordinates(coordinates)) {
            x = (int) (Math.random() * map.getWidth());
            y = (int) (Math.random() * map.getHeight());
            coordinates = new Coordinates(x, y);
        }
        return coordinates;
    }

    private boolean checkCoordinates(Coordinates coordinates) {

        return true;
    }

    public static void main(String[] args) {

    }
}