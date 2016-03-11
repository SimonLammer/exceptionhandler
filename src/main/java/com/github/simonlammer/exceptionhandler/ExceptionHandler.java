package com.github.simonlammer.exceptionhandler;

import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExceptionHandler {
	private static final Logger logger = Logger.getLogger(ExceptionHandler.class.getName());

	public static void logOccuringExceptions(DubiousProcedure procedure) {
		logOccuringExceptions(null, (String) null, procedure, null);
	}

	public static void logOccuringExceptions(DubiousProcedure procedure, Consumer<Exception> additionalExceptionHandler) {
		logOccuringExceptions(null, (String) null, procedure, additionalExceptionHandler);
	}

	public static void logOccuringExceptions(String message, DubiousProcedure procedure) {
		logOccuringExceptions(null, message, procedure, null);
	}

	public static void logOccuringExceptions(String message, DubiousProcedure procedure, Consumer<Exception> additionalExceptionHandler) {
		logOccuringExceptions(null, message, procedure, additionalExceptionHandler);
	}

	public static void logOccuringExceptions(Level level, DubiousProcedure procedure) {
		logOccuringExceptions(level, (String) null, procedure, null);
	}

	public static void logOccuringExceptions(Level level, DubiousProcedure procedure, Consumer<Exception> additionalExceptionHandler) {
		logOccuringExceptions(level, (String) null, procedure, additionalExceptionHandler);
	}

	public static void logOccuringExceptions(Level level, String message, DubiousProcedure procedure) {
		logOccuringExceptions(level, message, procedure, null);
	}

	public static void logOccuringExceptions(Level level, String message, DubiousProcedure procedure, Consumer<Exception> additionalExceptionHandler) {
		try {
			procedure.apply();
		} catch (Exception ex) {
			handleException(ex, level, message, additionalExceptionHandler);
		}
	}

	public static <T> T logOccuringExceptions(DubiousFunction<T> function) {
		return logOccuringExceptions(null, null, function, null, null);
	}

	public static <T> T logOccuringExceptions(DubiousFunction<T> function, Consumer<Exception> additionalExceptionHandler) {
		return logOccuringExceptions(null, null, function, null, additionalExceptionHandler);
	}

	public static <T> T logOccuringExceptions(DubiousFunction<T> function, T defaultReturnValue) {
		return logOccuringExceptions(null, null, function, defaultReturnValue, null);
	}

	public static <T> T logOccuringExceptions(DubiousFunction<T> function, T defaultReturnValue, Consumer<Exception> additionalExceptionHandler) {
		return logOccuringExceptions(null, null, function, defaultReturnValue, additionalExceptionHandler);
	}

	public static <T> T logOccuringExceptions(String message, DubiousFunction<T> function) {
		return logOccuringExceptions(null, message, function, null, null);
	}

	public static <T> T logOccuringExceptions(String message, DubiousFunction<T> function, Consumer<Exception> additionalExceptionHandler) {
		return logOccuringExceptions(null, message, function, null, additionalExceptionHandler);
	}

	public static <T> T logOccuringExceptions(String message, DubiousFunction<T> function, T defaultReturnValue) {
		return logOccuringExceptions(null, message, function, defaultReturnValue, null);
	}

	public static <T> T logOccuringExceptions(String message, DubiousFunction<T> function, T defaultReturnValue, Consumer<Exception> additionalExceptionHandler) {
		return logOccuringExceptions(null, message, function, defaultReturnValue, additionalExceptionHandler);
	}

	public static <T> T logOccuringExceptions(Level level, DubiousFunction<T> function) {
		return logOccuringExceptions(level, null, function, null, null);
	}

	public static <T> T logOccuringExceptions(Level level, DubiousFunction<T> function, Consumer<Exception> additionalExceptionHandler) {
		return logOccuringExceptions(level, null, function, null, additionalExceptionHandler);
	}

	public static <T> T logOccuringExceptions(Level level, DubiousFunction<T> function, T defaultReturnValue) {
		return logOccuringExceptions(level, null, function, defaultReturnValue, null);
	}

	public static <T> T logOccuringExceptions(Level level, DubiousFunction<T> function, T defaultReturnValue, Consumer<Exception> additionalExceptionHandler) {
		return logOccuringExceptions(level, null, function, defaultReturnValue, additionalExceptionHandler);
	}

	public static <T> T logOccuringExceptions(Level level, String message, DubiousFunction<T> function) {
		return logOccuringExceptions(level, message, function, null, null);
	}

	public static <T> T logOccuringExceptions(Level level, String message, DubiousFunction<T> function, Consumer<Exception> additionalExceptionHandler) {
		return logOccuringExceptions(level, message, function, null, additionalExceptionHandler);
	}

	public static <T> T logOccuringExceptions(Level level, String message, DubiousFunction<T> function, T defaultReturnValue) {
		return logOccuringExceptions(level, message, function, defaultReturnValue, null);
	}

	public static <T> T logOccuringExceptions(Level level, String message, DubiousFunction<T> function, T defaultReturnValue, Consumer<Exception> additionalExceptionHandler) {
		try {
			return function.apply();
		} catch (Exception ex) {
			handleException(ex, level, message, additionalExceptionHandler);
			return defaultReturnValue;
		}
	}

	private static void handleException(Exception ex, Level level, String message, Consumer<Exception> additionalExceptionHandler) {
		if (level == null) {
			level = Level.SEVERE;
		}
		if (message == null) {
			message = ex.getMessage();
		}
		logger.log(level, message, ex);
		if (additionalExceptionHandler != null) {
			additionalExceptionHandler.accept(ex);
		}
	}
}
