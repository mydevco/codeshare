package com.mydevco.lambda.strategypattern;


public class Trade {
	
	private final BrokerageFeeCalculator calculationStrategy;
	
	public Trade(BrokerageFeeCalculator calculationStrategy) {
		super();
		this.calculationStrategy = calculationStrategy;
	}

	public double calculateFee(double amount, int quanity){
		return calculationStrategy.calculate(amount, quanity);
	}
	
	
	public static void main(String[] args) {
		
		// old way
		Trade trading1 = new Trade(new BondsCalculationStrategy());
		System.out.println("Bonds trading commision : " + trading1.calculateFee(10000.00, 200));
		
		Trade trading2 = new Trade(new ETFCalculationStrategy());
		System.out.println("ETF trading commision : " + trading2.calculateFee(100000.00, 100));
		
		Trade trading3 = new Trade(new CommonStockCalculationStrategy());
		System.out.println("Common Stock trading commision : " + trading3.calculateFee(50000.00, 100));

	}

}
