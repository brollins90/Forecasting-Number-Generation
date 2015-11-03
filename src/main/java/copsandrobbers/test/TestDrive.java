package copsandrobbers.test;

import java.security.SecureRandom;
import java.util.HashMap;

import copsandrobbers.Generator;
import copsandrobbers.forecast.EntropyCalculator;
import copsandrobbers.generator.*;

public class TestDrive {

	public static void main(String[] args) {
		SecureRandom sr = new SecureRandom();
		long seed = sr.nextLong();
		HashMap<String, Generator> generators = new HashMap<>();
		generators.put("Java", new JavaRandomGenerator(seed));
		generators.put("Exponent", new ExponentRandomGenerator(seed));
		generators.put("Linear", new LinearRandomGenerator(seed));
		generators.put("Middle Squarish", new MiddleSquareishRandomGenerator(seed));
		generators.put("One", new OneRandomGenerator());
		generators.put("Time", new TimeRandomGenerator());
		
		for(String key : generators.keySet()){
			System.out.println(key + ": " + new EntropyCalculator(generators.get(key)).getEntropy());
			System.out.println(key + ": " + new EntropyCalculator(generators.get(key)).getIndexEntropy());
		}
	}

}
