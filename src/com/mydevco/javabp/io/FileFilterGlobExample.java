package com.mydevco.lambda.common;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileFilterGlobExample {

	public static void main(String[] args) {
		Path dir = Paths.get("data");
		try (DirectoryStream<Path> stream =
		     Files.newDirectoryStream(dir, "*.{csv,txt}")) {
		    for (Path entry: stream) {
		        System.out.println(entry.getFileName());
		    }
		} catch (IOException x) {
		    System.err.println(x);
		}

	}

}
