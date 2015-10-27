package copsandrobbers.generator.lcgr;

public class C99LCG extends LinearCongruentialRandomGenerator {

    public C99LCG(long seed) {
        super(seed, 30, 16);
        modulus = 4_294_967_295L; // 2**32
        multiplier = 1_103_515_245L;
        increment = 12_345L;
    }
}
