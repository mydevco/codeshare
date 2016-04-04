package com.mydevco.lambda.common;

import java.util.stream.Stream;

/**
 *
 * Streams are evaluated lazily
 */
public class LambdaLazyEvaluation {

    public static void main(String[] args) {
        Stream.iterate(5.0, p -> p * 2)
                .peek(e -> System.out.println("Fetching " + e)) // peek is a good tool for debugging
                .limit(5).toArray();
                //.findAny();
    }

}
