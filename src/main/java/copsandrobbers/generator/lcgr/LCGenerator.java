package copsandrobbers.generator.lcgr;

import copsandrobbers.Coordinate;
import copsandrobbers.Generator;

import java.util.Random;

public class LCGenerator extends Random implements Generator {

    // more at https://en.wikipedia.org/wiki/Linear_congruential_generator
    protected long modulus = 2147483647;
    protected long multiplier = 16807;
    protected long increment = 78125;
    protected long seed = 12345;

    public Coordinate getNextCoordinate() {
        return new Coordinate(nextInt(), nextInt());
    }

    @Override
    protected int next(int bits) {
        seed = (multiplier * seed + increment) % modulus;
        return (int) seed;
    }
}
