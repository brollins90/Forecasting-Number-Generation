package copsandrobbers;

public interface Forecaster {

    Coordinate getNextPrediction();
    void seePrevious(Coordinate coordinate);
}
