package com.mydevco.lambda.strategypattern;

public interface BrokerageFeeCalculator {

    public double calculate(double amount, int numTransactions);
}
