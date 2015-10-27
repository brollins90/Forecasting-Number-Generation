package copsandrobbers.generator.lcgr;

public class MSLCG extends LinearCongruentialRandomGenerator {

    public MSLCG(long seed) {
        super(seed, 30, 16);
        modulus = 4_294_967_295L; // 2**32
        multiplier = 214_013L;
        increment = 2_531_011L;
    }
}
