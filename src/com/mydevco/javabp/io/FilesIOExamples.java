package com.mydevco.lambda.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesIOExamples {

	public static void main(String[] args) {

		// read input airport list file and create files starting with each
		// alphabet
		String inputFileURL = "data/airports.csv";
		String outputFileDir = "output";
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			   @Override
			   public void run() {
			    File outFile = new File(outputFileDir);
			    
			    if(outFile.exists()) {
				    Arrays.asList(outFile.listFiles()).stream().forEach(file -> {if(file.exists()) { file.delete();}});
				    try {
						Path path = Paths.get(outputFileDir);
						Files.deleteIfExists(path);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			   }
		});
		
		try {

			Files.createDirectory(Paths.get(outputFileDir));

			for (char ch = 'A'; ch <= 'Z'; ch++) {
				Files.createFile(getOutputFilePath(outputFileDir,
						String.valueOf(ch)));
			}
			

			Stream<String> lines = Files.lines(Paths.get(inputFileURL));
			lines.filter(line -> !(line.contains("AIRPORT CODE"))).forEach(
					line -> {
						try {

							Files.write(
									getOutputFilePath(outputFileDir,
											line.substring(0, 1)),
									(line + "\n").getBytes(),
									StandardOpenOption.APPEND);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					});

			lines.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//read contents of a local small file into string
		
		String foxCrowStory;
		try {
			foxCrowStory = new String(Files.readAllBytes(Paths.get("data/FoxCrow.txt")));
			System.out.println(foxCrowStory);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		//read contents of a remote small file into string
		try {
			String remoteString;
			URL url = new URL("http://textfiles.com/stories/7oldsamr.txt");
			URLConnection conn = url.openConnection();
			conn.setReadTimeout(10000);
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"))) {
				remoteString = reader.lines().collect(Collectors.joining("\n"));
			}
			
			System.out.println(remoteString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

	private static Path getOutputFilePath(String outputFileDir, String suffix) {
		return Paths.get(outputFileDir + "/Airports_" + suffix + ".csv");
	}

}
