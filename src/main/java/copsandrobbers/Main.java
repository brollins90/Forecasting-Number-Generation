package copsandrobbers;

import copsandrobbers.forecast.GraphCountForecaster;
import copsandrobbers.forecast.LinearForecaster;
import copsandrobbers.generator.LinearRandomGenerator;
import copsandrobbers.generator.MiddleSquareishRandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // Phase 1 - Linear Progression
        Generator linearGenerator = new LinearRandomGenerator(5);
        Forecaster linearForecaster = new LinearForecaster();
        Coordinate linearCoord = linearGenerator.getNextCoordinate();

        System.out.println(linearCoord);
        for (int i = 0; i < 30; i++) {
            linearForecaster.seePrevious(linearCoord);
            Coordinate prediction = linearForecaster.getNextPrediction();
            linearCoord = linearGenerator.getNextCoordinate();

            String won = (linearCoord.getX() == prediction.getX() && linearCoord.getY() == prediction.getY())
                    ? "  WINNER" : "";
            System.out.println(linearCoord + " -->(" + prediction + ")" + won);
        }


//        Random g = new MiddleSquareishRandomGenerator(1);
//        GraphCountForecaster forecaster = new GraphCountForecaster();
//
//
//        Coordinate previous = new Coordinate(g.nextInt(), g.nextInt());
//
//        System.out.println(previous);
//
////        while (true) {
//        for (int i = 0; i < 50; i++) {
//            forecaster.seePrevious(previous);
//            Coordinate prediction = forecaster.getNextPrediction();
//            previous = new Coordinate(g.nextInt(), g.nextInt());
//
//            String won = (previous.getX() == prediction.getX() && previous.getY() == prediction.getY())
//                    ? "  WINNER" : "";
//            System.out.println(previous + " -->(" + prediction + ")" + won);
//        }

//        for (int i = 0; i < 10; i++) {
//            System.out.println(forecaster.getNextPrediction(i));
//        }
//        System.out.println(forecaster);
    }
}
