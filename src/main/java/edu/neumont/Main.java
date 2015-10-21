package edu.neumont;

import edu.neumont.coordinate.Generator;
import edu.neumont.coordinate.JavaRandomGenerator;

public class Main {

    public static void main(String[] args) {

        Generator generator = new JavaRandomGenerator();

        for (int i = 0; i < 50; i++) {
            System.out.println(generator.getNextCoordinate());
        }
    }
}
