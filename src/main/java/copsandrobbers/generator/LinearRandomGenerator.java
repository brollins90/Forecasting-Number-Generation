package copsandrobbers.generator;

import copsandrobbers.Coordinate;
import copsandrobbers.Generator;

import java.util.Random;

public class LinearRandomGenerator extends Random implements Generator {

    private int next = 0;

    public LinearRandomGenerator(long seed) {
        next = (int) seed;
    }


    public Coordinate getNextCoordinate() {
        return new Coordinate(nextInt(1000), nextInt(1000));
    }

    @Override
    protected int next(int bits) {
        next++;
        next%=(7);
//        next%=((1 << bits) - 1);
        return next;
    }
}
