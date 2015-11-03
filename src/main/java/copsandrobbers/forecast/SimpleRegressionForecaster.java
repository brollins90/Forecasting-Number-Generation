package copsandrobbers.forecast;

import org.apache.commons.math3.stat.regression.SimpleRegression;

import copsandrobbers.Coordinate;
import copsandrobbers.Forecaster;

public class SimpleRegressionForecaster implements Forecaster {

	private SimpleRegression xRegression;
	private SimpleRegression yRegression;
	private int time;
	
	public SimpleRegressionForecaster() {
		xRegression = new SimpleRegression();
		yRegression = new SimpleRegression();
		time = 0;
	}
	
	@Override
	public Coordinate getNextPrediction() {
		int xPredict = (int)xRegression.predict(time);
		int yPredict = (int)yRegression.predict(time);
		return new Coordinate(xPredict, yPredict);
	}

	@Override
	public void seePrevious(Coordinate coordinate) {
		xRegression.addData(time, coordinate.getX());
		yRegression.addData(time, coordinate.getY());
		time++;
	}

}
