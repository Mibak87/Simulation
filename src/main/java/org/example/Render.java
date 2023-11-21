package org.example;

import org.example.creatures.Herbivore;
import org.example.creatures.Predator;
import org.example.statics.Grass;
import org.example.statics.Rock;
import org.example.statics.Tree;

public class Render {
    public void mapUpdate(SimulationMap simulationMap) {
        for (int i = 0; i < simulationMap.getHeight(); i++) {
            for (int j = 0; j < simulationMap.getWidth(); j++) {
                Coordinates currentCoordinates = new Coordinates(i,j);
                if (simulationMap.getMap().containsKey(currentCoordinates)) {
                    Entity entity = simulationMap.getMap().get(currentCoordinates);
                    if (entity instanceof Grass) {
                        System.out.print("\uD83C\uDF40");
                    }
                    if (entity instanceof Rock) {
                        System.out.print("⬛");
                    }
                    if (entity instanceof Tree) {
                        System.out.print("\uD83C\uDF33");
                    }
                    if (entity instanceof Herbivore) {
                        System.out.print("\uD83D\uDC2E");
                    }
                    if (entity instanceof Predator) {
                        System.out.print("\uD83D\uDC3A");
                    }
                } else {
                    System.out.print("⬜");
                }
            }
            System.out.println();
        }
        System.out.println(simulationMap.toString());
    }
}
