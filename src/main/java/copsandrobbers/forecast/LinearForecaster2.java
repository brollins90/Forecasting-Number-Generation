package copsandrobbers.forecast;

import copsandrobbers.Coordinate;
import copsandrobbers.Forecaster;

import java.util.LinkedList;

public class LinearForecaster2 implements Forecaster {

    private LinkedList<Integer> integerList = new LinkedList<>();
    private LinkedList<Integer> changeList = new LinkedList<>();
    private Pattern pattern = Pattern.IDONTKNOW;
    private long mathyStuffGoesHere = 0;

    public Coordinate getNextPrediction() {

        int x;
        int y;
        int previous;
        switch (pattern) {
            case CUBED:
                previous = (integerList.size() > 0) ? integerList.get(0) : 1;
                x = previous * previous * previous;
                y = x * x * x;
                break;
            case SQUARED:
                previous = (integerList.size() > 0) ? integerList.get(0) : 1;
                x = previous * previous;
                y = x * x;
                break;
            default:

                int previousJump = (integerList.size() > 2) ? integerList.get(0) - integerList.get(1) : 1;

                x = integerList.get(0) + previousJump;
                y = x + previousJump;


        }
        return new Coordinate(x, y);
    }

    public void seePrevious(Coordinate coordinate) {
        int first = coordinate.getX();
        int second = coordinate.getY();

        analyze(first);
        analyze(second);
    }

    private void analyze(int value) {

        int prev = (integerList.size() > 0) ? integerList.peekFirst() : value;
        integerList.add(0, value);
//
//        int firstChange = first - prev;
//        int secondChange = second - first;
//
//        changeList.add(0, firstChange);
//        changeList.add(0, secondChange);
//
//        System.out.println(prev + ", " + first + ", " + second);
//        System.out.println(firstChange + " " + secondChange);
//
//        if (firstChange == secondChange) {
//            System.out.println("change has been constant for at least two");
//        }
//
//        if (secondChange - firstChange == 1) {
//            System.out.println("second is 1 larger that first");
//        }
//        if (firstChange - secondChange == 1) {
//            System.out.println("first is 1 larger that second");
//        }


        // Cubing numbers
        if (Math.cbrt(value) == prev) {
            System.out.println("Cubed");
            pattern = Pattern.CUBED;
        }

        // Squaring Numbers
        if (Math.sqrt(value) == prev) {
            System.out.println("Squared");
            pattern = Pattern.SQUARED;
        }

        // Fib
        ////  0 1 1 2 3 5 8 13 21 34 55
        ///--  1 0 1 1 2 3 5 8 13   21
        if (changeList.size() > 6) {
            if (changeList.get(0) == 13
                    && changeList.get(1) == 8
                    && changeList.get(2) == 5
                    && changeList.get(3) == 3
                    && changeList.get(4) == 2
                    && changeList.get(5) == 1
                    && changeList.get(6) == 1) {
                System.out.println("Fib");
            }
        }

        // Increase by 1
        /////  1 2 3 4 5
        //---   1 1 1 1 1
        if (changeList.size() > 2) {
            int at0 = changeList.get(0);
            if (at0 == changeList.get(1)
                    && at0 == changeList.get(1)
                    && at0 == changeList.get(2)) {
                System.out.println("constant increase");
            }
        }

        /////  5  10  15  20  25
        ///--   5   5   5   5
//        if (changeList.size() > 2) {
//        if (changeList.get(0) == 1
//                && changeList.get(1) == 1
//                && changeList.get(2) == 1) {
//            System.out.println("Increase by 1");
//        }
//        }

        // skip by increasing number of spaces
        /////  1 3 6 10 15 21 28
        ///---  2 3 4  5 6  7
//        if (changeList.get(0) == 13
//                && changeList.get(1) == 8
//                && changeList.get(2) == 5
//                && changeList.get(3) == 3
//                && changeList.get(4) == 2
//                && changeList.get(5) == 1
//                && changeList.get(6) == 1) {
//            System.out.println("Fib");
//        }

        //// 1 2 4 8 16 32 64
        ///-- 1 2 4 8 16 32

    }
}
