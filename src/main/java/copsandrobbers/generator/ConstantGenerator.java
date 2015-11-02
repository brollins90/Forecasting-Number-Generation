package copsandrobbers.generator;

import copsandrobbers.Coordinate;
import copsandrobbers.Generator;

public class ConstantGenerator implements Generator {

	@Override
	public Coordinate getNextCoordinate() {
		return new Coordinate(0, 0);
	}

	@Override
	public Coordinate getNextCoordinate32Bits() {
		return null;
	}

}
