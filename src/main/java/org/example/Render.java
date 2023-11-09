package org.example;

import org.example.creatures.Herbivore;
import org.example.creatures.Predator;
import org.example.staticentity.Grass;
import org.example.staticentity.Rock;
import org.example.staticentity.Tree;

public class Render {
    public void mapUpdate(Map map) {
        for (int i = 1; i <= map.getHeight(); i++) {
            for (int j = 1; j <= map.getWidth(); j++) {
                Coordinates currentCoordinates = new Coordinates(i,j);
                if (map.getMap().containsKey(currentCoordinates)) {
                    Entity entity = map.getMap().get(currentCoordinates);
                    if (entity instanceof Grass) {
                        System.out.print("G");
                    }
                    if (entity instanceof Rock) {
                        System.out.print("R");
                    }
                    if (entity instanceof Tree) {
                        System.out.print("T");
                    }
                    if (entity instanceof Herbivore) {
                        System.out.print("H");
                    }
                    if (entity instanceof Predator) {
                        System.out.print("P");
                    }
                } else {
                    System.out.print("O");
                }
            }
            System.out.println();
        }
    }
}
