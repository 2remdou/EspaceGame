package com.oc;

import org.apache.logging.log4j.LogManager;

public class Logger {
    private static org.apache.logging.log4j.Logger logger = LogManager.getLogger();

    public static void error(String message){
        logger.error(message);
    }
    public static void info(String message){
        logger.info(message);
    }
    public static void debug(String message){
        logger.debug(message);
    }
}
