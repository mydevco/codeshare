package com.mydevco.lambda.common;

import org.apache.commons.math3.stat.regression.SimpleRegression;

//Runnable using lambda

public class Lambda2 {

    public static void main(String[] args) {
        double[][] data = {{1, 3}, {2, 5}, {3, 7}, {4, 14}, {5, 11}};
        SimpleRegression regression = new SimpleRegression();
        regression.addData(data);

        new Thread(() -> System.out.println("Interepts : " + regression.getIntercept())).start();

        new Thread(() -> System.out.println("Slope : " + regression.getSlope())).start();

        new Thread(() -> System.out.println("Standard Error : " + regression.getSlopeStdErr())).start();

    }
}
