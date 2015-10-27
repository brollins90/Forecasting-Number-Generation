package copsandrobbers.generator;

import copsandrobbers.Coordinate;
import copsandrobbers.Generator;

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
