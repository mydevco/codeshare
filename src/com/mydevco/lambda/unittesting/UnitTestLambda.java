package com.mydevco.lambda.unittesting;

import java.util.Arrays;
import static java.util.Arrays.asList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Test;

public class UnitTestLambda {

    public static List<String> cleanUpperSort(List<String> words) {
        return words.stream()
                .map(string -> string.toUpperCase()).filter(s -> s.length() < 3).sorted()
                .collect(Collectors.toList());

    }

    @Test
    public void testCleanUpperSort() {
        List<String> input = Arrays.asList("abc", "xyz", "boston", "no");
        List<String> result = cleanUpperSort(input);
        Assert.assertEquals(asList("ABC", "BOSTON", "XYZ"), result);
    }
    
    public static List<String> cleanReverseSort(List<String> words) {
        return words.stream()
                .map(UnitTestLambda::reverse).filter(s -> s.length() < 3).sorted()
                .collect(Collectors.toList());

    }
    
    public static String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    @Test
    public void testReverse() {
        String input = "rats";
        Assert.assertEquals("star", reverse(input));
    }

}
