package org.example;

import org.example.creatures.Herbivore;
import org.example.creatures.Predator;
import org.example.staticentity.Grass;
import org.example.staticentity.Rock;
import org.example.staticentity.Tree;

import java.util.HashSet;
import java.util.Set;

public class Map {
    private Set<Herbivore> herbivores;
    private Set<Predator> predators;
    private Set<Grass> grasses;
    private Set<Rock> rocks;
    private Set<Tree> trees;
    private int width;
    private int height;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        Set<Herbivore> herbivores = new HashSet<>();
        Set<Predator> predators = new HashSet<>();
        Set<Grass> grasses = new HashSet<>();
        Set<Rock> rocks = new HashSet<>();
        Set<Tree> trees = new HashSet<>();
    }

    public Set<Herbivore> getHerbivores() {
        return herbivores;
    }

    public Set<Predator> getPredators() {
        return predators;
    }

    public Set<Grass> getGrasses() {
        return grasses;
    }

    public Set<Rock> getRocks() {
        return rocks;
    }

    public Set<Tree> getTrees() {
        return trees;
    }

    public void setHerbivores(Set<Herbivore> herbivores) {
        this.herbivores = herbivores;
    }

    public void setPredators(Set<Predator> predators) {
        this.predators = predators;
    }

    public void setGrasses(Set<Grass> grasses) {
        this.grasses = grasses;
    }

    public void setRocks(Set<Rock> rocks) {
        this.rocks = rocks;
    }

    public void setTrees(Set<Tree> trees) {
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
