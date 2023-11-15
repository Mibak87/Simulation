package org.example.creatures;

import org.example.Coordinates;
import org.example.Map;
import org.example.creatures.Creature;

public class Predator extends Creature {
    private final int attackPower;

    public Predator(int velocity, int life, int attackPower, Coordinates coordinates) {
        super(velocity,life,coordinates);
        this.attackPower = attackPower;
    }

    public int getAttackPower() {
        return attackPower;
    }

    @Override
    public String toString() {
        return "Predator{" +
                "x=" + coordinates.getX() +
                " y=" + coordinates.getY() +
                '}';
    }

    @Override
    public void makeMove(Map map) {

    }
}
