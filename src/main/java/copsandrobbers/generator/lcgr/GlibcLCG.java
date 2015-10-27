package copsandrobbers.generator.lcgr;

public class GlibcLCG extends LinearCongruentialRandomGenerator {

    public GlibcLCG(long seed) {
        super(seed, 30, 0);
        modulus = 2_147_483_647L; // 2**31
        multiplier = 1_103_515_245L;
        increment = 12_345L;
    }
}
