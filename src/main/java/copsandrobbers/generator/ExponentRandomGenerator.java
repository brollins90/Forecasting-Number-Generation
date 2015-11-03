package copsandrobbers.generator;

import copsandrobbers.Coordinate;
import copsandrobbers.Generator;

import java.util.Random;

public class ExponentRandomGenerator extends Random implements Generator {

    private long next = 0;
    private int exponent;

    public ExponentRandomGenerator(long seed){
        this(seed, 2);
    }

    public ExponentRandomGenerator(long seed, int exponent) {
        next = seed;
        this.exponent = exponent;
    }


    public Coordinate getNextCoordinate() {
        return new Coordinate(nextInt(1000), nextInt(1000));
    }
    public Coordinate getNextCoordinate32Bits() {
        return new Coordinate(nextInt(), nextInt());
    }

    @Override
    protected int next(int bits) {
        next = (long)Math.pow(next, exponent);
        long temp = next;
        temp%=((1 << bits) - 1);
        return (int) temp;
    }
}
