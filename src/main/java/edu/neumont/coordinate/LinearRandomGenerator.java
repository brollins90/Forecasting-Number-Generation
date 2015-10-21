package edu.neumont.coordinate;

public class LinearRandomGenerator implements Generator {

    private int next = 0;

    public Coordinate getNextCoordinate() {

        next++;
        if (next > 1000) next = 0;
        return new Coordinate(next, next);
    }
}
