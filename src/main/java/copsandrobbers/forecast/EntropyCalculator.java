package copsandrobbers.forecast;

import java.util.HashMap;

import copsandrobbers.Coordinate;
import copsandrobbers.Generator;

public class EntropyCalculator {
	
	private static final int MAX = 1000;
	private int[][] randoms = new int[MAX][MAX];
	private Generator gen;
	
	public EntropyCalculator(Generator gen){
		this.gen = gen;
	}
	
	public double getEntropy(){
		HashMap<Integer, Integer> freqs = new HashMap<>();
		populateRandoms();
		for(int[] row : randoms){
			for(int i : row){
				freqs.put(i, freqs.containsKey(i) ? freqs.get(i) + 1 : 1);
			}
		}
		int N = freqs.values().stream().mapToInt(i -> i).sum();
		double sum = freqs.values().stream().mapToDouble(i -> ((double)i/N * log2((double)i/N))).sum();
		return sum;
	}
	
	private static double log2(double n){
		return Math.log(n)/Math.log(2);
	}
	private void populateRandoms(){
		for(int i = 0; i < randoms.length; i++){
				for(int j = 0; j < randoms[i].length; j++){
				Coordinate coord = gen.getNextCoordinate();
				randoms[i][j] = coord.getX();
			}
		}
	}
}
