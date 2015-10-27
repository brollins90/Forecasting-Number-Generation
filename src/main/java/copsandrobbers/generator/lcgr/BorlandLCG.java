package copsandrobbers.generator.lcgr;

public class BorlandLCG extends LinearCongruentialRandomGenerator {

    public BorlandLCG(long seed) {
        super(seed, 30, 16);
        modulus = 4_294_967_295L; // 2**32
        multiplier = 22_695_477L;
        increment = 1L;
    }

    // output bits... bits 30..16 in rand(), 30..0 in lrand()
}
