package com.mydevco.lambda.strategypattern;


public class BondsCalculationStrategy implements BrokerageFeeCalculator{
	

	public BondsCalculationStrategy() {
		super();
	}
	
	@Override
	public double calculate(double amount, int numTransactions) {
		return (numTransactions * 5.00) + (amount * 0.002); 
	}

}
