package com.mydevco.lambda.common;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class LambaLimitations {
    
    public static void appendAll(Iterable<String> values, Appendable out)
        throws IOException { // doesn't help with the error
        //values.forEach(s -> out.append(s)); // error: can't throw IOException here
                       // Consumer.accept(T) doesn't allow it
    }
    
    public static boolean containsNastyWord(Iterable<String> values) {
            values.forEach(s -> {
                if ("nasty".equals(s)) {
                    //return false;  //want to break
                }
            });
            
           
            return true;
    }
    
    public static  void main (String[] args) {
        
        String local = "local";
        List<String> strings = Arrays.asList("store", "pub", "station");
        strings.forEach(s -> {
            System.out.println(local + s);
            //local = local + s; //can not modify local variable
        });
        
        List<String> words = Arrays.asList("good", "awesome", "nasty");
        
        
    }
    
}
