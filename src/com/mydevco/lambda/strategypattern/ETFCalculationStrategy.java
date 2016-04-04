package com.mydevco.lambda.strategypattern;


public class ETFCalculationStrategy implements BrokerageFeeCalculator {

    public ETFCalculationStrategy() {
        super();
    }

    @Override
    public double calculate(double amount, int numTransactions) {
        return amount * 0.01;
    }

}
