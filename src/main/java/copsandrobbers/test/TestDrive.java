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
		
//		Corey's mean test for the random generators
//		System.out.println("the closer to 1 the number, the better the random generator is at spreading through the numbers. \n");
//		RandomGeneratorMeanTester rgmt = new RandomGeneratorMeanTester(1000, 1000, new TimeRandomGenerator());
//		System.out.println("TimeRandomGenerator randomness is: " + rgmt.getMeanCloseness());
//		
//		rgmt = new RandomGeneratorMeanTester(1000, 1000, new JavaRandomGenerator(6566));
//		System.out.println("Java's randomness is: " + rgmt.getMeanCloseness());
//		
//		rgmt = new RandomGeneratorMeanTester(1000, 1000, new LinearRandomGenerator(6566));
//		System.out.println("LinearRandomGenerator randomness is: " + rgmt.getMeanCloseness());
//		
//		rgmt = new RandomGeneratorMeanTester(1000, 1000, new MiddleSquareishRandomGenerator());
//		System.out.println("MiddleSquarishRandomGenerator randomness is: " + rgmt.getMeanCloseness());
//		
//		rgmt = new RandomGeneratorMeanTester(1000, 1000, new OneRandomGenerator());
//		System.out.println("OneRandomGenerator randomness is: " + rgmt.getMeanCloseness());
//		
//		rgmt = new RandomGeneratorMeanTester(1000, 1000, new ExponentRandomGenerator(6566));
//		System.out.println("ExponenetRandomGenerator randomness is: " + rgmt.getMeanCloseness());
	}

}
