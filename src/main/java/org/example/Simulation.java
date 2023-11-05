package org.example;


public class Simulation {
    private Map map;
    private int moveCounter;
    private Render render;
    private Actions actions;

    public void nextTurn() {

    }

    public void startSimulation() {
        map = new Map(10,10);

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