package com.mydevco.lambda.common;

// Counting word occurrences in a text file.
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;

/**
 * lambda with new Files api
 */
public class FileWordCount {
    
    

    public static void main(String[] args) throws IOException {
// Regex that matches one or more consecutive whitespace characters

        Pattern pattern = Pattern.compile("\\s+");

        // count occurrences of each word in a Stream<String> sorted by word
        Map<String, Long> wordCounts
                = Files.lines(Paths.get("C:\\java8\\LambdaPresentation\\data\\LambdaPresentation\\data\\MobyDick.txt")) //Util function returns stream of all the lines in a file
                .map(line -> line.replaceAll("(?!')\\p{P}", ""))
                .flatMap(line -> pattern.splitAsStream(line)) //Pattern got new method splitAsStream to split as CharSequence
                .collect(Collectors.groupingBy(String::toLowerCase,
                                TreeMap::new, Collectors.counting()));

        // display the words grouped by starting letter
        wordCounts.entrySet()
                .stream().filter(entry -> StringUtils.isNotBlank(entry.getKey()) && Character.isLetter(entry.getKey().trim().charAt(0)))
                .collect(Collectors.groupingBy(entry -> entry.getKey().trim().charAt(0),
                                TreeMap::new, Collectors.toList()
                        ))
                .forEach((letter, wordList)
                        -> {
                    System.out.printf("%n%C%n", letter);
                    wordList.stream().forEach(word -> System.out.printf(
                                    "%13s: %d%n", word.getKey(), word.getValue()));
                });
    }

}
