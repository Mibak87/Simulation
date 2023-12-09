package org.example;

import java.util.Objects;

public class Coordinates {
    private final int x;
    private final int y;

    private Coordinates previousCell;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates getPreviousCell() {
        return previousCell;
    }

    public void setPreviousCell(Coordinates previousCell) {
        this.previousCell = previousCell;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
