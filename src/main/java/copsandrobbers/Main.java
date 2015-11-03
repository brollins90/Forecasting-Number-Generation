package copsandrobbers;

import copsandrobbers.forecast.GraphCountForecaster;
import copsandrobbers.forecast.LinearForecaster;
import copsandrobbers.forecast.LinearJumpForecaster;
import copsandrobbers.forecast.SimpleRegressionForecaster;
import copsandrobbers.generator.LinearRandomGenerator;
import copsandrobbers.generator.LinearishRandomGenerator;
import copsandrobbers.generator.MiddleSquareishRandomGenerator;
import copsandrobbers.generator.lcgr.JavaLCG;
import copsandrobbers.forecast.LCGForecaster;
import copsandrobbers.forecast.LinearForecaster2;
import copsandrobbers.generator.ExponentRandomGenerator;
import copsandrobbers.generator.lcgr.LCGenerator;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // Phase 1 - Linear Progression
//        Generator linearGenerator = new ExponentRandomGenerator(2, 3);
//        Forecaster linearForecaster = new LinearForecaster2();
//        Coordinate linearCoord = linearGenerator.getNextCoordinate();
//
//        System.out.println(linearCoord);
//        for (int i = 0; i < 20; i++) {
//            linearForecaster.seePrevious(linearCoord);
//            Coordinate prediction = linearForecaster.getNextPrediction();
//            linearCoord = linearGenerator.getNextCoordinate();
//
//            String won = (linearCoord.getX() == prediction.getX() && linearCoord.getY() == prediction.getY())
//                    ? "  WINNER" : "";
//            System.out.println(linearCoord + " -->(" + prediction + ")" + won);
//        }
//        // Phase 2 - Simple Pattern
//        Generator simpleGenerator = new MiddleSquareishRandomGenerator(5);
//        Forecaster simpleForecaster = new GraphCountForecaster();
//        Coordinate simpleCoord = simpleGenerator.getNextCoordinate();
//
//        System.out.println(simpleCoord);
//        for (int i = 0; i < 50; i++) {
//            simpleForecaster.seePrevious(simpleCoord);
//            Coordinate prediction = simpleForecaster.getNextPrediction();
//            simpleCoord = simpleGenerator.getNextCoordinate();
//
//            String won = (simpleCoord.getX() == prediction.getX() && simpleCoord.getY() == prediction.getY())
//                    ? "  WINNER" : "";
//            System.out.println(simpleCoord + " -->(" + prediction + ")" + won);
//        }

        // Phase 3 - Complex Pattern
        Generator complexGenerator = new LCGenerator(12345);
        Forecaster complexForecaster = new LCGForecaster();
//        Coordinate complexCoord = complexGenerator.getNextCoordinate();
        Coordinate complexCoord = complexGenerator.getNextCoordinate32Bits();

        System.out.println(complexCoord);
        for (int i = 0; i < 50; i++) {
            complexForecaster.seePrevious(complexCoord);
            Coordinate prediction = complexForecaster.getNextPrediction();
//            complexCoord = complexGenerator.getNextCoordinate();
            complexCoord = complexGenerator.getNextCoordinate32Bits();

            String won = (complexCoord.getX() == prediction.getX() && complexCoord.getY() == prediction.getY())
                    ? "  WINNER" : "";
            System.out.println(complexCoord + " -->(" + prediction + ")" + won);
        }
    }
}
