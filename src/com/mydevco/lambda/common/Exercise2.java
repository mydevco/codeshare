package com.mydevco.lambda.common;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mydevco.lambda.model.Baby;
import com.mydevco.lambda.util.BabyNamesParserUtil;

public class Exercise2 {

    public static List<Baby> filterBabies (List<Baby> babies, List<Predicate<Baby>> predicates) {
        Predicate<Baby> compositePredicate = predicates.stream().reduce(p -> true, Predicate::and);
        return babies.stream().
                filter( compositePredicate ).
                    sorted(Comparator.comparing(Baby::getName)).
                        collect(Collectors.<Baby>toList());
    }
    
    public static List<Baby> filterBabies (Stream<Baby> babyStream, List<Predicate<Baby>> predicates) {
        Predicate<Baby> compositePredicate = predicates.stream().reduce(p -> true, Predicate::and);
        return babyStream.parallel().
                filter( compositePredicate ).
                    sorted(Comparator.comparing(Baby::getName)).
                        collect(Collectors.<Baby>toList());
    }

    public static void main(String[] args) {

        List<Baby> babies = BabyNamesParserUtil.getBabyNames(2013);
        
        List<Baby> filtered = filterBabies(babies, Arrays.asList(
                p -> p.getGender().equalsIgnoreCase("F"),
                p -> p.getOccurance() > 5000,
                p -> p.getName().startsWith("S")));
        
        filtered.forEach(b -> System.out.println(b.toString()));
        
        
        
        
        
        ///flat map to mix different year results
        Stream<List<Baby>> babyListStream = Stream.of(BabyNamesParserUtil.getBabyNames(2013),
                BabyNamesParserUtil.getBabyNames(2012),
                BabyNamesParserUtil.getBabyNames(2011),
                BabyNamesParserUtil.getBabyNames(2010));
        
        //flat stream
        Stream<Baby> babyStream = babyListStream.flatMap((babyList) -> babyList.stream());
        
        List<Baby> filtered1 = filterBabies(babyStream, Arrays.asList(
                p -> p.getGender().equalsIgnoreCase("F"),
                p -> p.getOccurance() > 5000,
                p -> p.getName().startsWith("S")));
        
        System.out.println("\n\nBetween 2010 to 2013");
        filtered1.forEach(b -> System.out.println(b.toString()));
    }

}
