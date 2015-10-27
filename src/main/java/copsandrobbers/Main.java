package copsandrobbers;

import copsandrobbers.forecast.GraphCountForecaster;
import copsandrobbers.generator.MiddleSquareishRandomGenerator;

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
        Random g = new MiddleSquareishRandomGenerator(1);
        GraphCountForecaster forecaster = new GraphCountForecaster();


        Coordinate previous = new Coordinate(g.nextInt(), g.nextInt());

        System.out.println(previous);

//        while (true) {
        for (int i = 0; i < 50; i++) {
            forecaster.seePrevious(previous);
            Coordinate prediction = forecaster.getNextPrediction();
            previous = new Coordinate(g.nextInt(), g.nextInt());

            String won = (previous.getX() == prediction.getX() && previous.getY() == prediction.getY())
                    ? "  WINNER" : "";
            System.out.println(previous + " -->(" + prediction + ")" + won);
        }

//        for (int i = 0; i < 10; i++) {
//            System.out.println(forecaster.getNextPrediction(i));
//        }
//        System.out.println(forecaster);
    }
}
