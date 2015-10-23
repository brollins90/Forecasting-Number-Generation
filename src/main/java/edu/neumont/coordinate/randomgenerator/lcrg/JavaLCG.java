package edu.neumont.coordinate.randomgenerator.lcrg;

public class JavaLCG extends LinearCongruentialRandomGenerator {

    public JavaLCG(long seed) {
        super(seed, 47, 16);
        modulus = 281_474_976_710_656L; // 2**48
        multiplier = 25_214_903_917L;
        increment = 11L;
    }
}
