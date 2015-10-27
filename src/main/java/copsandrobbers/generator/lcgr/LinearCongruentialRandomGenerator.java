package copsandrobbers.generator.lcgr;

import copsandrobbers.Coordinate;
import copsandrobbers.Generator;

import java.util.Random;

public abstract class LinearCongruentialRandomGenerator extends Random implements Generator {

    // more at https://en.wikipedia.org/wiki/Linear_congruential_generator
    protected long modulus = (long) Math.pow(2, 48);
    protected long multiplier = 0x5DEECE66DL;
    protected long increment = 11;
    protected long oldSeed;

    protected int leftBit;
    protected int rightBit;
    protected long mask;

    public LinearCongruentialRandomGenerator(long seed, int leftBit, int rightBit) {
        this.leftBit = leftBit;
        this.rightBit = rightBit;
        mask = (1L << (leftBit + 1)) - 1;
        setSeed(seed);
    }

    public void setSeed(long seed) {
        oldSeed = (seed ^ multiplier) & mask;
    }

    public Coordinate getNextCoordinate() {
        return new Coordinate(nextInt(1000), nextInt(1000));
    }

    @Override
    protected int next(int bits) {
        long nextSeed = (multiplier * oldSeed + increment) % modulus;
        oldSeed = nextSeed;

        long tempLong = nextSeed;
        tempLong = tempLong & mask; // drops bits on the left

        return (int)(tempLong >>> ((leftBit + 1) - bits));
    }
}
