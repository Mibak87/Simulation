package org.example;

import org.example.creatures.Herbivore;
import org.example.creatures.Predator;
import org.example.staticentity.Grass;
import org.example.staticentity.Rock;
import org.example.staticentity.Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Map {
    private HashMap<Coordinates,Entity> map;
    private int width;
    private int height;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        HashMap<Coordinates,Entity> map = new HashMap<>();
    }

    public HashMap<Coordinates, Entity> getMap() {
        return map;
    }

    public void setMap(HashMap<Coordinates, Entity> map) {
        this.map = map;
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

    @Override
    public String toString() {
        return "Map{" +
                "map=" + map +
                '}';
    }
}
