package edu.neumont;

import edu.neumont.coordinate.*;
import edu.neumont.coordinate.randomforecaster.*;
import edu.neumont.coordinate.randomgenerator.LinearRandomGenerator;
import edu.neumont.coordinate.randomgenerator.MiddleSquareishRandomGenerator;
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
//        rs.add(new JavaLCG(seed));
//        rs.add(new MSLCG(seed));
//        rs.add(new Random(seed));
//        rs.add(new NumericalRecipiesLCG(seed));


//        for (int i = 0; i < 5; i++) {
//            System.out.println();
//            for (Random r : rs) {
//                int ii = r.nextInt();
//                System.out.println("" + ii + '\t' + Integer.toBinaryString(ii));
//
//                double dd = r.nextDouble();
//                System.out.println("" + dd + '\t' + Double.toHexString(dd));
//            }
//        }
        LinearRandomGenerator g = new LinearRandomGenerator(1);
        BlakeForecaster forecaster = new BlakeForecaster();



        for (int i = 0; i < 5; i++) {
            Coordinate coord = new Coordinate(g.nextInt(),g.nextInt());

            forecaster.seePrevious(coord);
//            Coordinate coordinate = generator.getNextCoordinate();
//            Coordinate predication = forecaster.getNextPrediction();
//            System.out.println(coordinate + " " + predication);
//            forecaster.seePrevious(coordinate);
        }
        System.out.println(forecaster);
    }
}
