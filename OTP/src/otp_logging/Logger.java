package otp_logging;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Singleton logging class, used by the FileLoader class
 */
public class Logger {

	private static Logger logger = null;

	private Logger() {
	}

	public static Logger getInstance() {
		if (logger == null) {
			logger = new Logger();
		}
		return logger;
	}

	public void logErrors(List<String> errors) {

		try {
			FileWriter fileWriter = new FileWriter("application.log");

			for (String data : errors) {
				StringBuilder line = new StringBuilder();
				line.append(data);
				line.append("\n");
				fileWriter.write(line.toString());
			}
			fileWriter.close();
		} 
		catch (IOException e) {

		}
	}
}
