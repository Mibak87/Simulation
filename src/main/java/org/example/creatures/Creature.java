package org.example.creatures;

import org.example.Coordinates;
import org.example.Entity;
import org.example.SimulationMap;

public abstract class Creature extends Entity {
    protected final int velocity;
    protected int life;
    protected Coordinates coordinates;

    public Creature(int velocity, int life, Coordinates coordinates) {
        this.velocity = velocity;
        this.life = life;
        this.coordinates = coordinates;
    }

    public int getVelocity() {
        return velocity;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }



    public abstract void makeMove(SimulationMap simulationMap);
}
