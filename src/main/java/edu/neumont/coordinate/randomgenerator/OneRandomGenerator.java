package edu.neumont.coordinate.randomgenerator;

import edu.neumont.coordinate.Coordinate;
import edu.neumont.coordinate.Generator;

import java.util.Random;

public class OneRandomGenerator extends Random implements Generator {

    public Coordinate getNextCoordinate() {
        return new Coordinate(nextInt(1000), nextInt(1000));
    }

    @Override
    protected int next(int bits) {
        return 1;
    }
}
