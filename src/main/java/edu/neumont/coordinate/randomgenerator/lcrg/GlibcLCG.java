package edu.neumont.coordinate.randomgenerator.lcrg;

public class GlibcLCG extends LinearCongruentialRandomGenerator {

    public GlibcLCG(long seed) {
        super(seed, 30, 0);
        modulus = 2_147_483_647L;
        multiplier = 1_103_515_245L;
        increment = 12_345L;

//         = 16; // bits 47..16
    }
}
