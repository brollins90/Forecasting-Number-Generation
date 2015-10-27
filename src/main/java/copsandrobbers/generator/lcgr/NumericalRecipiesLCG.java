package copsandrobbers.generator.lcgr;

public class NumericalRecipiesLCG extends LinearCongruentialRandomGenerator {

    public NumericalRecipiesLCG(long seed) {
        super(seed, 31, 0);
        modulus = 4_294_967_295L; // 2**32
        multiplier = 1_664_525L;
        increment = 1_013_904_223L;
    }

    // output bits... bits 30..16 in rand(), 30..0 in lrand()
}
