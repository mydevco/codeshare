package com.mydevco.lambda.strategypattern;

public class TradeLambda {

    private final BrokerageFeeCalculator calculationStrategy;

    public TradeLambda(BrokerageFeeCalculator calculationStrategy) {
        super();
        this.calculationStrategy = calculationStrategy;
    }

    public double calculateFee(double amount, int quanity) {
        return calculationStrategy.calculate(amount, quanity);
    }

    public static void main(String[] args) {
        //lambda way
        
        //Bonds
        TradeLambda trading1 = new TradeLambda((x, y) -> (y * 5.00) + (x * 0.002));
        System.out.println("Bonds trading commision : " + trading1.calculateFee(10000.00, 200));

        //ETF
        TradeLambda trading2 = new TradeLambda((x, y) -> x * 0.01);
        System.out.println("ETF trading commision : " + trading2.calculateFee(100000.00, 100));

        //Common Stock
        TradeLambda trading3 = new TradeLambda((x, y) -> y * 5.00);
        System.out.println("Common Stock trading commision : " + trading3.calculateFee(50000.00, 100));

    }

}
