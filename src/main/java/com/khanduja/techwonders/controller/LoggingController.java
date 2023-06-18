package com.khanduja.techwonders.controller;

import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logging/")
@Profile("test")
public class LoggingController {

    private static final Logger logger = LoggerFactory.getLogger(LoggingController.class);
    private static final org.apache.logging.log4j.Logger loggerNative = LogManager.getLogger(LoggingController.class);

    @Value("${message.logger}")
    private String message;

    @GetMapping
    public String logging() {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");

        return "Success";
    }


    @GetMapping("native")
    public String nativeLogging() {
        loggerNative.trace("This TRACE message has been printed by Log4j2 without passing through SLF4J");
        loggerNative.debug("This DEBUG message has been printed by Log4j2 without passing through SLF4J");
        loggerNative.info("This INFO message has been printed by Log4j2 without passing through SLF4J");
        loggerNative.warn("This WARN message been printed by Log4j2 without passing through SLF4J");
        loggerNative.error("This ERROR message been printed by Log4j2 without passing through SLF4J");
        loggerNative.fatal("This FATAL message been printed by Log4j2 without passing through SLF4J");
        return "Howdy! Check out the Logs to see the output printed directly through Log4j2...";
    }

    @GetMapping("tester")
    public String getDeveloperMessage() {
        return message;
    }
}
