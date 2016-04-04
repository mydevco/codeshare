package com.mydevco.lambda.common;

import java.security.SecureRandom;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

/**
 * Readymade random streams added in java.util.Random/SecureRandowm classes
 */
public class Random {

    public static void main(String[] args) {

        SecureRandom random = new SecureRandom();

        // roll a die 1,000,000 times and summarize the results
        System.out.printf("%-6s%s%n", "Face", "Frequency");
        random.ints(6_000_000, 1, 7) //created infinite stream
                .boxed() //important otherwise collect wont work on these streams
                .collect(Collectors.groupingBy(Function.identity(),
                                Collectors.counting()))
                .forEach((face, frequency)
                        -> System.out.printf("%-6d%d%n", face, frequency));
    }
}
