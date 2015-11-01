package copsandrobbers.generator.lcgr;

public class LCGenerator extends LinearCongruentialRandomGenerator {

    public LCGenerator(long seed) {
        super(seed, 31, 0);
        modulus = 2147483647;
        multiplier = 16807;
        increment = 78125;
    }
}
