package copsandrobbers.test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

import copsandrobbers.Coordinate;
import copsandrobbers.Generator;

public class RandomGeneratorMeanTester {
	private int xSize;
	private int ySize;
	private Generator random;
	
	public RandomGeneratorMeanTester(int xSize, int ySize, Generator random) {
		this.xSize = xSize;
		this.ySize = ySize;
		this.random = random;
	}
	
	private Coordinate getCenter() {
		return new Coordinate(xSize / 2, ySize / 2);
	}
	
	private Coordinate getMeanCoordinate(int totalRuns) {
		BigInteger xs = BigInteger.ZERO;
		BigInteger ys = BigInteger.ZERO;
		for(int i = 0; i < totalRuns; i++) {
			Coordinate coordinate = random.getNextCoordinate();
			xs = xs.add(BigInteger.valueOf(coordinate.getX()));
			ys = ys.add(BigInteger.valueOf(coordinate.getY()));
		}
		return new Coordinate(xs.divide(BigInteger.valueOf(totalRuns)).intValue(), ys.divide(BigInteger.valueOf(totalRuns)).intValue());
	}
	
	public double getMeanCloseness() {
		Coordinate center = this.getCenter();
		Coordinate mean = this.getMeanCoordinate(10000);
		double x = (double)center.getX() / (double)mean.getX();
		double y = (double)center.getY() / (double)mean.getY();
		return (x + y) / 2;
	}
}
