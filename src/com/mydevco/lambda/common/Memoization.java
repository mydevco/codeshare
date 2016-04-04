package com.mydevco.lambda.common;

import java.util.HashMap;
import java.util.Map;
import java.util.function.LongFunction;

public class Memoization {

    private static Map<Long, Long> memo = new HashMap<>();

    static {
        memo.put(0L, 0L); //fibonacci(0)
        memo.put(1L, 1L); //fibonacci(1)
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        LongFunction<Long> fib = Memoization::fibonacci;

        for (long x = 0; x < 42; x++) {
            System.out.println(" " + fib.apply(x) + " ");
        }

        System.out.println("Time taken : " + ((System.nanoTime() - start) / 1000000) + " milliseconds");
    }

    

    public static Long fibonacci(long x) {
        return memo.computeIfAbsent(x, n -> Math.addExact(fibonacci(n - 1),
                fibonacci(n - 2)));
    }

}
