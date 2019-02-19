package com.example.tododemo.logger;

import java.io.File;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogFactory {

	public static Logger getLogger(String className) {
		try {
		Logger logger = Logger.getLogger(className);
		File logFile = new File(className + ".log");
		if (!logFile.exists()) {
			logFile.createNewFile();
		}
		FileHandler fileHandler = new FileHandler(logFile.getName(), true);
		logger.addHandler(fileHandler);
		SimpleFormatter formatter = new SimpleFormatter();
		fileHandler.setFormatter(formatter);
		return logger;
		} catch (Exception e) {
			return Logger.getLogger("default");
		}
	}
}
