package org.example.creatures;

import org.example.Coordinates;
import org.example.Entity;

public abstract class Creature extends Entity {
    protected final int velocity;
    protected int life;
    protected Coordinates coordinates;

    public Creature(int velocity, int life, Coordinates coordinates) {
        this.velocity = velocity;
        this.life = life;
        this.coordinates = coordinates;
    }

    public abstract void makeMove();
}
