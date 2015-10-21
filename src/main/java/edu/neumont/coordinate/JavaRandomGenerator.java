package edu.neumont.coordinate;

import java.util.Random;

public class JavaRandomGenerator implements Generator {

    private Random random;

    public JavaRandomGenerator() {
        random = new Random();
    }

    public Coordinate getNextCoordinate() {

        int x = random.nextInt(1000);
        int y = random.nextInt(1000);

        return new Coordinate(x, y);
    }
}
