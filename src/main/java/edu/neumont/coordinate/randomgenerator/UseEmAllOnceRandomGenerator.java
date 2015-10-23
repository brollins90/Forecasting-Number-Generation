package edu.neumont.coordinate.randomgenerator;

import edu.neumont.coordinate.Coordinate;
import edu.neumont.coordinate.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UseEmAllOnceRandomGenerator implements Generator {

    private Random generator;
    private List<Integer> numbers;

    public UseEmAllOnceRandomGenerator() {
        generator = new MiddleSquareishRandomGenerator();
        reset();
    }

    private void reset() {
        numbers = new ArrayList<Integer>(1000);

        for (int i = 0; i < 1000; i++) {
            numbers.add(i);
        }
    }

    public Coordinate getNextCoordinate() {
        return new Coordinate(next(), next());
    }

    private int next() {
        if (numbers.size() < 1) {
            reset();
        }
        int nextIndex = generator.nextInt(numbers.size());
        return numbers.remove(nextIndex);
    }
}
