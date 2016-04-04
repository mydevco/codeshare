package com.mydevco.lambda.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mydevco.lambda.model.Baby;

public class BabyNamesParserUtil {

    public static List<Baby> getBabyNames(int year) {

        List<Baby> babies = new ArrayList<>();

        try {
            String[][] data = CSVUtil.parseCSV("C:\\java8\\LambdaPresentation\\data\\babies\\yob" + year + ".txt");

            for (String[] row : data) {
                babies.add(new Baby(row[0], row[1], Integer.parseInt(row[2])));
            }
        } catch (IOException ex) {
            Logger.getLogger(BabyNamesParserUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return babies;

    }

}
