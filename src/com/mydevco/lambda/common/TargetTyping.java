package com.mydevco.lambda.common;

public class TargetTyping {

    @FunctionalInterface
    public interface GreaterValue {

        double greater(double n1, double n2);
    }

    @FunctionalInterface
    public interface LongerString {

        String longer(String s1, String s2);
    }
    
    public static void print(LongerString longer) {
                String s1 = "pneumonoultramicroscopicsilicovolcanoconiosis";
                String s2 = "lambda";
                String s3 = longer.longer(s1,s2);
                System.out.print("Using a LongerString: " + s3);
    }
    
    public static void print(GreaterValue value) {
                double x = 300.45;
                double y = 100.45;
                double great = value.greater(x, y);
                System.out.print("Using a GreaterValue: " + great);
    }

    public static void main(String[] args) {
        // Creates an GreaterValue using a lambda expression
        GreaterValue gt = (x, y) -> x > y? x : y;

        // Creates a LongerString using a lambda expression
        LongerString ls = (x, y) -> x.length() > y.length()?x:y;
        

        // greater of double values
        double g1 = gt.greater(200.34, 100.34);

        // now with ints
        double g2 = gt.greater(200, 100);

        // Which string is longer
        String st = ls.longer("pneumonoultramicroscopicsilicovolcanoconiosis", "lambda");
        
        System.out.println("Greater of double = " + g1);
        System.out.println("Greater of ints = " + g2);
        System.out.println("Longer of strings = " + st);
        
        //resolve ambiguity in target typing by casting
        print((LongerString) (x,y) -> x.length() > y.length()?x:y);
    }

}
