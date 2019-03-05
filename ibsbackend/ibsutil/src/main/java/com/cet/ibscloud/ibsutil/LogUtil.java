package com.cet.ibscloud.ibsutil;

import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class LogUtil {

	private static ConcurrentHashMap<Class<?>, org.slf4j.Logger> map = new ConcurrentHashMap();

	public static void info(Class<?> clazz, String msg) {
		Logger logger = null;
		if (map.containsKey(clazz)) {
			logger = (Logger) map.get(clazz);
		} else {
			logger = (Logger) LoggerFactory.getLogger(clazz);
			map.put(clazz, logger);
		}
		if (logger != null) {
			logger.info(msg);
		}
	}
	
	public static void debug(Class<?> clazz, String msg) {
		Logger logger = null;
		if (map.containsKey(clazz)) {
			logger = (Logger) map.get(clazz);
		} else {
			logger = (Logger) LoggerFactory.getLogger(clazz);
			map.put(clazz, logger);
		}
		if (logger != null) {
			logger.debug(msg);
		}
	}
	
	public static void error(Class<?> clazz, String msg) {
		Logger logger = null;
		if (map.containsKey(clazz)) {
			logger = (Logger) map.get(clazz);
		} else {
			logger = (Logger) LoggerFactory.getLogger(clazz);
			map.put(clazz, logger);
		}
		if (logger != null) {
			logger.error(msg);
		}
	}
}
