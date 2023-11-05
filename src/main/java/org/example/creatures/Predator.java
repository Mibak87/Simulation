package org.example.creatures;

import org.example.Coordinates;
import org.example.creatures.Creature;

public class Predator extends Creature {
    private final int attackPower;

    public Predator(int velocity, int life, int attackPower, Coordinates coordinates) {
        super(velocity,life,coordinates);
        this.attackPower = attackPower;
    }
    @Override
    public void makeMove() {

    }
}
