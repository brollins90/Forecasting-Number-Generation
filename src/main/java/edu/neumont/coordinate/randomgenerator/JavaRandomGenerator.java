package edu.neumont.coordinate.randomgenerator;

import edu.neumont.coordinate.Coordinate;
import edu.neumont.coordinate.Generator;

import java.util.Random;

public class JavaRandomGenerator extends Random implements Generator {

    public Coordinate getNextCoordinate() {
        return new Coordinate(nextInt(1000), nextInt(1000));
    }
}
