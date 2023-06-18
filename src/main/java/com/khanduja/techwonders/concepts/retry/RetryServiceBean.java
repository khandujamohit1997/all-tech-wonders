package com.khanduja.techwonders.concepts.retry;

import com.khanduja.techwonders.controller.LoggingController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@EnableRetry
@PropertySource("classpath:retryConfig.properties")
public class RetryServiceBean {

    private final AtomicInteger counter = new AtomicInteger(0);
    private static final Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @Retryable(retryFor = IOException.class, maxAttemptsExpression = "${retry.maxAttempts}",
        backoff = @Backoff(delayExpression = "${retry.maxDelay}"))
    public String callRemoteService(int maxAttempts) throws IOException {
        int attempt = counter.incrementAndGet();
        logger.info("Attempt: {} to call remote service.", attempt);
        if (attempt < maxAttempts) {
            throw new IOException("Simulated network error");
        }
        return "Success";
    }

    @Recover
    public String handleException(Exception e) {
        logger.info("All retries failed, handling the exception", e);
        return "Fallback value";
    }
}
