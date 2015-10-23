package edu.neumont;

import edu.neumont.coordinate.*;
import edu.neumont.coordinate.randomforecaster.*;
import edu.neumont.coordinate.randomgenerator.lcrg.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int seed = 40628285;
        List<Random> rs = new ArrayList<>();

//        rs.add(new AnsiCLCG(seed));
//        rs.add(new BorlandLCG(seed));
//        rs.add(new BorlandLrandLCG(seed));
//        rs.add(new C99LCG(seed));
//        rs.add(new GlibcLCG(seed));
        rs.add(new JavaLCG(seed));
//        rs.add(new MSLCG(seed));
        rs.add(new Random(seed));
//        rs.add(new NumericalRecipiesLCG(seed));


        for (int i = 0; i < 5; i++) {
            System.out.println();
            for (Random r : rs) {
                int ii = r.nextInt();
                System.out.println("" + ii + '\t' + Integer.toBinaryString(ii));

                double dd = r.nextDouble();
                System.out.println("" + dd + '\t' + Double.toHexString(dd));
            }
        }
//        LinearForecaster forecaster = new LinearForecaster();
//
//        System.out.println(Integer.toBinaryString(r.nextInt()));
//        System.out.println(Integer.toBinaryString(g.nextInt()));

//        System.out.println(a);
//        for (int i = 0; i < 2; i++) {
//            System.out.println(r.nextInt() + " " + g.nextInt());
////            Coordinate coordinate = generator.getNextCoordinate();
////            Coordinate predication = forecaster.getNextPrediction();
////            System.out.println(coordinate + " " + predication);
////            forecaster.seePrevious(coordinate);
//        }
    }
}
