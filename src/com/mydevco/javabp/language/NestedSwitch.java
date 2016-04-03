package com.mydevco.javabp.language;

public class NestedSwitch {

	private static final String BURLINGTON_S = "BURLINGTON";
	private static final String BOSTON_S = "BOSTON";
	private static final String NC_S = "NC";
	private static final String MA_S = "MA";
	
	private static enum STATE{MA, NC};
	
	private static enum TOWN{BURLINGTON, BOSTON};

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Usage: NestedSwitch <state> <town>");
			System.exit(1);
		}

		String state = args[0];
		String stateUpper = state.toUpperCase();
		STATE stateEnum = STATE.valueOf(state.toUpperCase());
		String town = args[1];
		String townUpper = town.toUpperCase();
		TOWN townEnum = TOWN.valueOf(town.toUpperCase());
		
		long start = System.nanoTime();
		switch (stateUpper) {
		case NC_S:
			System.out.println("Welcome to North Carolina!");
			break;
		case MA_S:
			System.out.println("Welcome to Massacusettes!");
			switch (townUpper) {
			case BOSTON_S:
				System.out.println("Capital Town");
				break;
			case BURLINGTON_S:
				System.out.println("Great Town");
				break;
			default:
				System.out.println("All town are great in MA");
			}
			break;

		}
		System.out.println("Time taken with nested String switch =" + (System.nanoTime() - start));

		start = System.nanoTime();
		if (stateUpper.equals(NC_S)) {
			System.out.println("Welcome to North Carolina!");

		} else if (stateUpper.equals(MA_S)) {
			System.out.println("Welcome to Massacusettes!");
			if (townUpper.equals(BOSTON_S)) {
				System.out.println("Capital Town");
			} else if (townUpper.equals(BURLINGTON_S)) {
				System.out.println("Great Town");
			} else {
				System.out.println("All town are great in MA");
			}
		}
		System.out.println("Time taken with nested if else=" + (System.nanoTime() - start));
		
		start = System.nanoTime();
		switch (stateEnum) {
		case NC:
			System.out.println("Welcome to North Carolina!");
			break;
		case MA:
			System.out.println("Welcome to Massacusettes!");
			switch (townEnum) {
			case BOSTON:
				System.out.println("Capital Town");
				break;
			case BURLINGTON:
				System.out.println("Great Town");
				break;
			default:
				System.out.println("All town are great in MA");
			}
			break;

		}
		System.out.println("Time taken with nested enum Switch=" + (System.nanoTime() - start));
		
		start = System.nanoTime();
		switch (stateEnum.ordinal()) {
		case 1:
			System.out.println("Welcome to North Carolina!");
			break;
		case 0:
			System.out.println("Welcome to Massacusettes!");
			switch (townEnum.ordinal()) {
			case 1:
				System.out.println("Capital Town");
				break;
			case 0:
				System.out.println("Great Town");
				break;
			default:
				System.out.println("All town are great in MA");
			}
			break;

		}
		System.out.println("Time taken with nested enum Switch=" + (System.nanoTime() - start));


	}

}
