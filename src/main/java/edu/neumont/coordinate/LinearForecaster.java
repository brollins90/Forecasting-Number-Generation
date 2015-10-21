package edu.neumont.coordinate;

public class LinearForecaster implements Forecaster {

    private int lastSeen;

    public Coordinate getNextPrediction() {
        return new Coordinate(lastSeen + 1, lastSeen + 1);
    }

    public void seePrevious(Coordinate coordinate) {
        lastSeen = coordinate.getX();
    }
}
