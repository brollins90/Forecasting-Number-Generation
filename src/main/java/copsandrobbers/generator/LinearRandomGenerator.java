package copsandrobbers.generator;

import copsandrobbers.Coordinate;
import copsandrobbers.Generator;

import java.util.Random;

public class LinearRandomGenerator extends Random implements Generator {

    private int next = 0;
    private int jump;

    public LinearRandomGenerator(long seed) {
        this(seed, 1);
    }

    public LinearRandomGenerator(long seed, int jump) {
        next = (int) seed;
        this.jump = jump;
    }


    public Coordinate getNextCoordinate() {
        return new Coordinate(nextInt(1000), nextInt(1000));
    }
    public Coordinate getNextCoordinate32Bits() {
        return new Coordinate(nextInt(), nextInt());
    }

    @Override
    protected int next(int bits) {
        next += jump;
//        next%=(8);
        next%=((1 << bits) - 1);
        return next;
    }
}
