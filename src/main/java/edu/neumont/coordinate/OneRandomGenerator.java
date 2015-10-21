package edu.neumont.coordinate;

public class OneRandomGenerator implements Generator {

    public Coordinate getNextCoordinate() {

        return new Coordinate(1, 1);
    }
}
