package copsandrobbers.generator;

import copsandrobbers.Coordinate;
import copsandrobbers.Generator;

import java.util.Random;

public class JavaRandomGenerator extends Random implements Generator {

    public JavaRandomGenerator(long seed) {
        super(seed);
    }

    public Coordinate getNextCoordinate() {
        return new Coordinate(nextInt(1000), nextInt(1000));
    }
    public Coordinate getNextCoordinate32Bits() {
        return new Coordinate(nextInt(), nextInt());
    }
}
