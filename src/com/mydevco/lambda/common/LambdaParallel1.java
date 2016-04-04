package com.mydevco.lambda.common;

import java.io.IOException;
import java.time.Clock;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mydevco.lambda.util.CSVUtil;
import com.mydevco.lambda.util.FAAUtil;

/**
 *
 * @author gkmek_000
 */
public class LambdaParallel1 {
    
    private static final Log Log = LogFactory.getLog(LambdaParallel1.class);
    
    public static void main(String[] args) {
        
        //parallel stream example 1
        try {
            
            long start = System.nanoTime();
            Map<String, String> airports = CSVUtil.readAsMap("C:\\java8\\LambdaPresentation\\data\\airports.csv", 0, 1);
            airports.keySet().parallelStream().forEach(p -> { //now try with parallelStream
                System.out.println("Airport Code : " + p);
                System.out.println("Airport Name : " + airports.get(p));
                System.out.println("Is Delay : " + FAAUtil.contactFAA(p).isIsDelay());
            });
            System.out.println(" Time Taken : " + ((System.nanoTime() - start)/1000000000) + " Seconds");
            
        } catch (IOException ex) {
            Log.error(ex);
        }
    }
}
