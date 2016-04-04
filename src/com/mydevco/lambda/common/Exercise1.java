package com.mydevco.lambda.common;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.mydevco.lambda.model.Baby;
import com.mydevco.lambda.util.BabyNamesParserUtil;

public class Exercise1 {

    public static void main(String[] args) {

        List<Baby> babies = BabyNamesParserUtil.getBabyNames(2000);

        List<Baby> filtered = babies.stream().filter(
                p -> p.getGender().equalsIgnoreCase("F")).sorted(Comparator.comparing(Baby::getOccurance).reversed())
                .limit(10).collect(Collectors.<Baby>toList());

        System.out.println("Top 10 female baby names >>>>>>");
        filtered.forEach(b -> System.out.println(b.toString()));

        List<Baby> mfiltered = babies.stream().filter(
                p -> p.getGender().equalsIgnoreCase("M")).sorted(Comparator.comparing(Baby::getOccurance).reversed())
                .limit(10).collect(Collectors.<Baby>toList());

        System.out.println("\n\nTop 10 male baby names >>>>>>");
        mfiltered.forEach(b -> System.out.println(b.toString()));

    }

}
