package com.khanduja.techwonders.concepts;

import com.khanduja.techwonders.TechWondersApplication;
import com.khanduja.techwonders.concepts.retry.RetryServiceBean;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = RetryServiceBean.class)
public class RetryServiceTest {

    @Autowired
    private RetryServiceBean retryServiceBean;

    @Test
    void retryTest() {
        try {
            int maxAttempts = 3;
            assertEquals("Success", retryServiceBean.callRemoteService(maxAttempts));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void recoverTest() {
        try {
            int maxAttempts = 5;
            assertEquals("Fallback value", retryServiceBean.callRemoteService(maxAttempts));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
