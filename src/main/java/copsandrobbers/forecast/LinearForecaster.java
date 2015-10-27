package copsandrobbers.forecast;

import copsandrobbers.Coordinate;
import copsandrobbers.Forecaster;

public class LinearForecaster implements Forecaster {

    private int lastSeen;

    public Coordinate getNextPrediction() {
        return new Coordinate(lastSeen + 1, lastSeen + 2);
    }

    public void seePrevious(Coordinate coordinate) {
        lastSeen = coordinate.getY();
    }
}
