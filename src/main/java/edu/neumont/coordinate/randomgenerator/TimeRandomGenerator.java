package edu.neumont.coordinate.randomgenerator;

import edu.neumont.coordinate.Coordinate;
import edu.neumont.coordinate.Generator;

import java.util.Random;

public class TimeRandomGenerator extends Random implements Generator {

    public Coordinate getNextCoordinate() {
        return new Coordinate(nextInt(1000), nextInt(1000));
    }

    @Override
    protected int next(int bits) {
        long now = System.nanoTime();
        long next = now % ((1 << bits) - 1);
        return (int) next;
    }
}
