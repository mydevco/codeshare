package com.mydevco.lambda.common;

import java.io.IOException;

import static java.util.Comparator.comparing;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mydevco.lambda.model.Airport;
import com.mydevco.lambda.util.CSVUtil;
import com.mydevco.lambda.util.FAAUtil;

public class LambdaParallel2 {

    private static final Log Log = LogFactory.getLog(LambdaParallel2.class);

    public static void main(String[] args) {

        try {

            long start = System.nanoTime();
            List<String> codes = CSVUtil.readAsList("C:\\java8\\LambdaPresentation\\data\\airports.csv", 0);

            Function<String, Airport> aiportFunction = new Function<String, Airport>() {
                public Airport apply(String code) {
                    return FAAUtil.contactFAA(code);
                }
            };

            //Using collectors to map codes into airport map
            List<Airport> airports = codes.parallelStream().map(aiportFunction).collect(Collectors.<Airport>toList()); //try parallel

            System.out.println("\n\nAirports  <<<<<<<<<<<<<<<");
            airports.forEach(p -> {
                if (StringUtils.isNotEmpty(p.getName())) {
                    System.out.println(p.toString());
                }
            }
            );
            
            List<String> coldAirports
                    = airports.stream().filter(a -> a.getTemperatue() < 40) //try parallel
                    .sorted(comparing(Airport::getTemperatue).reversed())
                    .map(a -> a.getCode())
                    .collect(Collectors.<String>toList());
            System.out.println("\n\nCold Airports sorted with airport code <<<<<<<<<<<<<<<");
            coldAirports.forEach(p -> System.out.println(p.toString()));

            System.out.println(" Time Taken : " + ((System.nanoTime() - start)) + " Nano Seconds");

        } catch (IOException ex) {
            Log.error(ex);
        }

    }
}
