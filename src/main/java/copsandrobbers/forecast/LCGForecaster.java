package copsandrobbers.forecast;

import copsandrobbers.Coordinate;
import copsandrobbers.Forecaster;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

// http://www.reteam.org/papers/e59.pdf

public class LCGForecaster implements Forecaster {

    private final int determinateOffset = 4;

    private int numbersSeenIndex = 0;
    private int determinateIndex = numbersSeenIndex - determinateOffset;
    private List<Long> numbersSeen = new ArrayList<>();
    private List<Long> determinates = new ArrayList<>();

    private boolean modulusFound, solved;
    private BigInteger modulus, seed, a, k;

    public Coordinate getNextPrediction() {

        long x = 1;
        long y = 2;
        if (solved) {
            x = (a.longValue() * numbersSeen.get(numbersSeenIndex - 1) + k.longValue()) % modulus.longValue();
            y = (a.longValue() * x + k.longValue()) % modulus.longValue();
        }
        return new Coordinate((int) x, (int) y);
    }

    public void seePrevious(Coordinate coordinate) {
        addNumberSeen(numbersSeenIndex++, coordinate.getX());
        addNumberSeen(numbersSeenIndex++, coordinate.getY());
    }

    private void addNumberSeen(int index, long number) {

//        System.out.println("Saw a " + number);
        numbersSeen.add(index, number);

        if (!solved) {

            determinateIndex = index - determinateOffset;
            if (determinateIndex >= 0) {
                determinates.add(determinateIndex,
                        calculateDeterminate(
                                numbersSeen.get(determinateIndex),
                                numbersSeen.get(determinateIndex + 1),
                                numbersSeen.get(determinateIndex + 2),
                                numbersSeen.get(determinateIndex + 3)));


//                for(Long i : determinates) {
//                    System.out.println(i);
//                }
            }

            if (!modulusFound && determinateIndex > 5) {
                modulus = calculateModulus();
                if (modulus != null && modulus != BigInteger.ZERO) {

                    int modulusIntValue = modulus.intValue();
                    boolean failed = false;

                    int i = (numbersSeenIndex > 100) ? numbersSeenIndex - 100 : 0;
//                    System.out.println("intval: " + modulusIntValue);
                    for (; i < numbersSeenIndex && !failed; i++) {
//                        System.out.println("i: " + numbersSeen.get(i));
                        if (modulusIntValue < numbersSeen.get(i)) {
                            failed = true;
                        }
                    }
                    if (!failed) {
                        modulusFound = true;
                    }
                }
            }

            if (!solved && numbersSeenIndex > 3) {
                solve();

                if (solved) {
                    System.out.println("The LCG function is: x[n] = ( " + a + " * x[n-1] + " + k + " ) % " + modulus);
                    seed = calculateSeed();
                    System.out.println("The seed was " + seed);
                }
            }
        }
    }

    private long calculateDeterminate(long val1, long val2, long val3, long val4) {
//        System.out.println("Calculating a determinate");
        return Math.abs(val1 * val3 - val1 * val4 + val2 * val3 - val2 * val2 + val2 * val4 - val3 * val3);
    }

    private BigInteger calculateModulus() {
//        System.out.println("Calculating modulus");

        List<BigInteger> tempGcd = new ArrayList<>();
        for (int i = 0; i < determinateIndex; i++) {
            tempGcd.add(i, BigInteger.valueOf(determinates.get(i)));
        }

        for (int k = 1; k < determinateIndex; k++) {
            for (int i = 0; i < determinateIndex - k; i++) {
                tempGcd.add(i, tempGcd.get(i).gcd(tempGcd.get(i + 1)));
            }
        }
        return factor(tempGcd.get(0));
    }

    private BigInteger factor(BigInteger value) {
//        System.out.println("Factoring");

        List<BigInteger> sprimes = new ArrayList<>();
        sprimes.add(BigInteger.valueOf(0x02));
        sprimes.add(BigInteger.valueOf(0x03));
        sprimes.add(BigInteger.valueOf(0x05));
        sprimes.add(BigInteger.valueOf(0x07));
        sprimes.add(BigInteger.valueOf(0x0B));
        sprimes.add(BigInteger.valueOf(0x0D));
        sprimes.add(BigInteger.valueOf(0x11));
        sprimes.add(BigInteger.valueOf(0x13));
        sprimes.add(BigInteger.valueOf(0x17));
        sprimes.add(BigInteger.valueOf(0x1D));
        sprimes.add(BigInteger.valueOf(0x1F));
        sprimes.add(BigInteger.valueOf(0x25));
        sprimes.add(BigInteger.valueOf(0x29));
        sprimes.add(BigInteger.valueOf(0x2B));
        sprimes.add(BigInteger.valueOf(0x2F));
        sprimes.add(BigInteger.valueOf(0x35));

        int counter = 0;
        while (counter < sprimes.size()) {
            if (value.mod(sprimes.get(counter)) == BigInteger.ZERO) value = value.divide(sprimes.get(counter));
            else counter++;
        }
        return value;
    }

    private BigInteger calculateSeed() {
//        System.out.println("Calculating seed");

        if (!solved) {
            return null;
        }

        BigInteger value = BigInteger.valueOf(numbersSeen.get(numbersSeenIndex - 1)).mod(modulus);
        BigInteger aInverse = a.modInverse(modulus);
        for (int i = numbersSeenIndex - 2; i >= 0; i--) {
            value = value.subtract(k).mod(modulus);
            value = value.multiply(aInverse).mod(modulus);
        }
        return value;
    }

    private void solve() {
//        System.out.println("Solving");

        if (solved || !modulusFound || numbersSeenIndex < 3) {
//            System.out.println("not trying to solve");
            return;
        }

        BigInteger val1 = BigInteger.valueOf(numbersSeen.get(0)).mod(modulus);
        BigInteger val2 = BigInteger.valueOf(numbersSeen.get(1)).mod(modulus);
        BigInteger val3 = BigInteger.valueOf(numbersSeen.get(2)).mod(modulus);

        BigInteger top = val2.subtract(val3).mod(modulus);
        BigInteger bottom = val1.subtract(val2).mod(modulus);
        a = top.multiply(bottom.modInverse(modulus)).mod(modulus);
        k = val2.subtract(a.multiply(val1).mod(modulus)).mod(modulus);

//        System.out.println("a: " + a + ", k: " + k);
        if (a != null && k != null) {
            solved = true;
        }
    }
}
