package com.mydevco.lambda.strategypattern;

public class CommonStockCalculationStrategy implements BrokerageFeeCalculator {

    public CommonStockCalculationStrategy() {
        super();
    }

    @Override
    public double calculate(double amount, int numTransactions) {
        return numTransactions * 5.00; //flat fee of $5 per transaction
    }

}
