package edu.neumont.coordinate.randomgenerator;

import edu.neumont.coordinate.Coordinate;
import edu.neumont.coordinate.Generator;

import java.util.Date;
import java.util.Random;

public class MiddleSquareishRandomGenerator extends Random implements Generator {

    private long seed;

    public MiddleSquareishRandomGenerator() {
        long now = new Date().getTime();
        seed = now % 1000;
    }

    public MiddleSquareishRandomGenerator(long seed) {
        this.seed = seed;
    }
    public Coordinate getNextCoordinate() {
        return new Coordinate(nextInt(1000), nextInt(1000));
    }

    @Override
    protected int next(int bits) {

        long seedSquared = seed * seed;
        String seedString = "" + seedSquared;

        while (seedString.length() < 8) {
            seedString = "0" + seedString;
        }

        seedString = seedString.replace('0','1');

        int mid = seedString.length() / 2;

        String number = seedString.substring(mid - 2, mid + 2);
        seed = Long.parseLong(number);

        long next = seed % ((1l << bits) - 1);
        return (int) next;
    }
}
