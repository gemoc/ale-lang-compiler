package org.eclipse.emf.ecoretools.ale.compiler.lib;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class LogService {
	public static void log(Object log) {
		Path path = Paths.get("/tmp/log.txt");

		try {
			Files.write(path, Arrays.asList(log.toString()), Charset.forName("UTF-8"), StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
