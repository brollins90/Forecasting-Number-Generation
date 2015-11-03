package copsandrobbers.generator;

import java.util.Random;

import copsandrobbers.Coordinate;
import copsandrobbers.Generator;

public class LinearishRandomGenerator extends Random implements Generator {

    private int next = 0;
    private int jumpMin;
    private int jumpDiff;
    private Random r;

    public LinearishRandomGenerator(long seed) {
        this(seed, 1, 1);
    }

    public LinearishRandomGenerator(long seed, int jumpMin, int jumpMax) {
        next = (int) seed;
        this.jumpMin = jumpMin;
        this.jumpDiff = jumpMax - jumpMin;
        r = new Random();
    }


    public Coordinate getNextCoordinate() {
        return new Coordinate(nextInt(1000), nextInt(1000));
    }

    @Override
    protected int next(int bits) {
        next += r.nextInt(jumpDiff) + jumpMin;
//        next%=(8);
        next%=((1 << bits) - 1);
        return next;
    }

}
