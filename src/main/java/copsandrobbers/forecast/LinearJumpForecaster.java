package copsandrobbers.forecast;

import copsandrobbers.Coordinate;
import copsandrobbers.Forecaster;

import java.util.LinkedList;

public class LinearJumpForecaster implements Forecaster {

    private LinkedList<Integer> list = new LinkedList<>();

    public Coordinate getNextPrediction() {
        int previousJump = (list.size() > 2) ? list.get(0) - list.get(1) : 1;

        int x = list.get(0) + previousJump;
        int y = x + previousJump;

        return new Coordinate(x, y);
    }

    public void seePrevious(Coordinate coordinate) {
        list.add(0,coordinate.getX());
        list.add(0,coordinate.getY());
    }
}
