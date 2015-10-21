package edu.neumont;

import edu.neumont.coordinate.*;

public class Main {

    public static void main(String[] args) {

        Generator generator = new LinearRandomGenerator();
        LinearForecaster forecaster = new LinearForecaster();

        for (int i = 0; i < 50; i++) {
            Coordinate coordinate = generator.getNextCoordinate();
            Coordinate predication = forecaster.getNextPrediction();
            System.out.println(coordinate + " " + predication);
            forecaster.seePrevious(coordinate);
        }
    }
}
