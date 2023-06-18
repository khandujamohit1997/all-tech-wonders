package com.khanduja.techwonders.configuration;

import com.khanduja.techwonders.TechWondersApplication;
import com.khanduja.techwonders.configuration.security.SecurityConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TechWondersApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AuthenticationTest {

    TestRestTemplate restTemplate;
    URL base;

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        restTemplate = new TestRestTemplate("user", "password");
        base = new URL("http://localhost:" + port);
    }

    @Test
    public void exampleTest() {
        String body = this.restTemplate.getForObject(base.toString(), String.class);
        assertEquals("Success", body);
    }
    @Test
    public void whenLoggedUserRequestsHomePage_ThenSuccess()
        throws IllegalStateException, IOException {
        ResponseEntity<String> response =
            restTemplate.getForEntity(base.toString(), String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void whenUserWithWrongCredentials_thenUnauthorizedPage()
        throws Exception {

        restTemplate = new TestRestTemplate("user", "wrongpassword");
        ResponseEntity<String> response =
            restTemplate.getForEntity(base.toString(), String.class);

        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
    }
}
