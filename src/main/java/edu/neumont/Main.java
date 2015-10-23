package edu.neumont;

import edu.neumont.coordinate.*;
import edu.neumont.coordinate.randomforecaster.*;
import edu.neumont.coordinate.randomgenerator.*;

public class Main {

    public static void main(String[] args) {

        Generator generator = new UseEmAllOnceRandomGenerator();
        LinearForecaster forecaster = new LinearForecaster();

        for (int i = 0; i < 50; i++) {
            Coordinate coordinate = generator.getNextCoordinate();
            Coordinate predication = forecaster.getNextPrediction();
            System.out.println(coordinate + " " + predication);
            forecaster.seePrevious(coordinate);
        }
    }
}
