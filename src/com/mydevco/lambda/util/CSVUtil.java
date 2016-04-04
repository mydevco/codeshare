/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mydevco.lambda.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.IOUtils;

public class CSVUtil {

    /**
     * Return array of strings for each column data for a given file. If file
     * has a header then first row array would have header names
     * There would as many rows and the number of columns in outer array. The size of each second level array would be the number of lines.
     * @param path
     * @return
     * @throws IOException
     */
    public static String[][] parseCSV(String path) throws IOException {
        CSVParser parser = CSVParser.parse(new File(path), Charset.defaultCharset(), CSVFormat.DEFAULT);
        List<CSVRecord> records = parser.getRecords();

        if (records.isEmpty()) {
            return new String[0][0];
        }

        int lines = records.size();

        String[][] data = new String[lines][];

        int i = 0;

        for (CSVRecord csvRecord : records) {
            int columns = csvRecord.size();
            String[] line = new String[columns];
            for (int x = 0; x < columns; x++) {
                line[x] = csvRecord.get(x);
            }

            data[i] = line;
            i++;
        }

        return data;
    }
    
    /**
     * Parse the CSV file and return two dimensional array in transposed format
     * There would as many rows and the number of columns in outer array. The size of each second level array would be the number of lines.
     * If file has a header then first value of each row would be header name
     * @param path
     * @return
     * @throws IOException 
     */
    
    public static String[][] transposeCSV(String path) throws IOException {
        CSVParser parser = CSVParser.parse(new File(path), Charset.defaultCharset(), CSVFormat.DEFAULT);
        List<CSVRecord> records = parser.getRecords();

        if (records.isEmpty()) {
            return new String[0][0];
        }

        int lines = records.size();
        int numberOfColumns = records.get(0).size();

        String[][] data = new String[numberOfColumns][lines];
        
        //initialize all column arrays
        for (int x = 0; x < numberOfColumns; x++) {
                data[x] = new String[lines];
        }

        int i = 0;

        for (CSVRecord csvRecord : records) {
            int columns = csvRecord.size();
            for (int x = 0; x < columns; x++) {
                data[x][i] = csvRecord.get(x);
            }
            i++;
        }

        return data;
    }    

    /**
     * Read a particular column (starting from 0) as list of string from a given
     * file.
     *
     * @param path
     * @param columnNumber
     * @return
     * @throws IOException
     */
    public static List<String> readAsList(String path, int columnNumber) throws IOException {

        File file = new File(path);
        InputStream is = new FileInputStream(file);
        List<String> rows = IOUtils.readLines(is);

        List<String> returnData = new ArrayList<>();

        rows.stream().map((row) -> row.split(",")).forEach((rowData) -> {
            returnData.add(rowData[columnNumber]);
        });

        return returnData;
    }

    /**
     * Read two columns as map from a csv file
     *
     * @param path
     * @param columnNumber
     * @return
     * @throws IOException
     */
    public static Map<String, String> readAsMap(String path, int keyColumn, int valueColumn) throws IOException {

        File file = new File(path);
        InputStream is = new FileInputStream(file);
        List<String> rows = IOUtils.readLines(is);

        Map<String, String> returnData = new HashMap<>();

        rows.stream().map((row) -> row.split(",")).forEach((rowData) -> {
            returnData.put(rowData[keyColumn], rowData[valueColumn]);
        });

        return returnData;
    }

}
