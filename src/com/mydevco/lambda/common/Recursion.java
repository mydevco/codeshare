package com.mydevco.lambda.common;
import java.util.function.LongFunction;
public class Recursion {
    

    
       public static void main(String[] args) {
               long start = System.nanoTime();
                LongFunction<Long> fib = Recursion::fibonacci;

                for(long x = 0; x< 100; x++) {
                    System.out.println(" " + fib.apply(x) + " ");
                }
                
                System.out.println("Time taken : " + ((System.nanoTime() - start) / 1000000000) + " seconds");
        }

        public static Long fibonacci(long n) {
                if (n == 0) {
                     return 0L;
                }

                if (n == 1) {
                      return 1L;
                }
                else {
                        return fibonacci(n-1) + fibonacci(n-2);
                }
        }
}
