package copsandrobbers.generator;

import copsandrobbers.Coordinate;
import copsandrobbers.Generator;

import java.util.Random;

public class OneRandomGenerator extends Random implements Generator {

    public Coordinate getNextCoordinate() {
        return new Coordinate(nextInt(1000), nextInt(1000));
    }
    public Coordinate getNextCoordinate32Bits() {
        return new Coordinate(nextInt(), nextInt());
    }

    @Override
    protected int next(int bits) {
        return 1;
    }
}
