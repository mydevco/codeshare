package com.mydevco.lambda.common;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Quiz {
    
    public static void main(String[] args) {
     
//        LongStream.iterate(10, l -> l %2).distinct().limit(10)
//         .forEach(System.out::println);

        List<Integer> list = IntStream.of(100,300,500,600,700,800).boxed().collect(Collectors.toList());
        list.forEach(p->System.out.println(p));
    }
    
}
