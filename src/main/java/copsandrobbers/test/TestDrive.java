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
		generators.put("Constant", new ConstantGenerator());
		generators.put("Java", new JavaRandomGenerator(seed));
		generators.put("ERG", new ExponentRandomGenerator(seed));
		generators.put("LRG", new LinearRandomGenerator(seed));
		generators.put("MSRG", new MiddleSquareishRandomGenerator(seed));
		generators.put("ORG", new OneRandomGenerator());
		generators.put("TRG", new TimeRandomGenerator());
		
		for(String key : generators.keySet()){
			System.out.println(key + ": " + new EntropyCalculator(generators.get(key)).getEntropy());
		}
	}

}
