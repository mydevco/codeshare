package com.mydevco.javabp.language;

public class NestedSwitch {

	private static final String BURLINGTON = "BURLINGTON";
	private static final String BOSTON = "BOSTON";
	private static final String NC = "NC";
	private static final String MA = "MA";

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Usage: NestedSwitch <state> <town>");
			System.exit(1);
		}

		String state = args[0];
		String stateUpper = state.toUpperCase();
		String town = args[1];
		String townUpper = town.toUpperCase();
		long start = System.nanoTime();
		switch (stateUpper) {
		case NC:
			System.out.println("Welcome to North Carolina!");
			break;
		case MA:
			System.out.println("Welcome to Massacusettes!");
			switch (townUpper) {
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
		System.out.println("Time taken =" + (System.nanoTime() - start));

		start = System.nanoTime();
		if (stateUpper.equals(NC)) {
			System.out.println("Welcome to North Carolina!");

		} else if (stateUpper.equals(MA)) {
			System.out.println("Welcome to Massacusettes!");
			if (townUpper.equals(BOSTON)) {
				System.out.println("Capital Town");
			} else if (townUpper.equals(BURLINGTON)) {
				System.out.println("Great Town");
			} else {
				System.out.println("All town are great in MA");
			}
		}
		System.out.println("Time taken =" + (System.nanoTime() - start));

	}

}
