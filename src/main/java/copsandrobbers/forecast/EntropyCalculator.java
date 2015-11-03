package copsandrobbers.forecast;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import copsandrobbers.Coordinate;
import copsandrobbers.Generator;

public class EntropyCalculator {
	
	private static final int MAX = 1000;
	private int[][] randoms;
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
	public double getIndexEntropy(){
		HashMap<Integer, Integer> ifreqs = new HashMap<>();
		populateRandoms();
		double entropyTotal = 0;
		for(int j = 0; j < MAX; j++){
			for(int i = 0; i < MAX; i++){
				ifreqs.put(i, ifreqs.containsKey(randoms[i][j]) ? ifreqs.get(randoms[i][j]) + 1 : 1);
			}
			int N = ifreqs.values().stream().mapToInt(i -> i).sum();
			entropyTotal += ifreqs.values().stream().mapToDouble(i -> ((double)i/N * log2((double)i/N))).sum();
			ifreqs.clear();
		}
		return entropyTotal / randoms.length;
	}
	public BufferedImage makeImage() throws IOException{
		populateRandoms();
		byte[] bites = new byte[1000000];
		int i = 0;
		for(int[] row : randoms){
			for(int n : row){
				bites[i++] = (byte)(n % 256);
			}
		}
		return ImageIO.read(new ByteArrayInputStream(bites));
	}
	
	private static double log2(double n){
		return Math.log(n)/Math.log(2);
	}
	private void populateRandoms(){
		randoms = new int[MAX][MAX];
		for(int i = 0; i < randoms.length; i++){
			for(int j = 0; j < randoms[i].length; j++){
				Coordinate coord = gen.getNextCoordinate();
				randoms[i][j] = coord.getX();
			}
		}
	}
}
