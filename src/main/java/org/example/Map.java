package org.example;

import org.example.creatures.Herbivore;
import org.example.creatures.Predator;
import org.example.staticentity.Grass;
import org.example.staticentity.Rock;
import org.example.staticentity.Tree;

import java.util.HashSet;

public class Map {
    private HashSet<Herbivore> herbivores;
    private HashSet<Predator> predators;
    private HashSet<Grass> grasses;
    private HashSet<Rock> rocks;
    private HashSet<Tree> trees;
    private int width;
    private int height;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public HashSet<Herbivore> getHerbivores() {
        return herbivores;
    }

    public HashSet<Predator> getPredators() {
        return predators;
    }

    public HashSet<Grass> getGrasses() {
        return grasses;
    }

    public HashSet<Rock> getRocks() {
        return rocks;
    }

    public HashSet<Tree> getTrees() {
        return trees;
    }

    public void setHerbivores(HashSet<Herbivore> herbivores) {
        this.herbivores = herbivores;
    }

    public void setPredators(HashSet<Predator> predators) {
        this.predators = predators;
    }

    public void setGrasses(HashSet<Grass> grasses) {
        this.grasses = grasses;
    }

    public void setRocks(HashSet<Rock> rocks) {
        this.rocks = rocks;
    }

    public void setTrees(HashSet<Tree> trees) {
        this.trees = trees;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
