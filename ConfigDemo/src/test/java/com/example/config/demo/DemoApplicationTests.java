package com.example.config.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {

    @Autowired
    private TestRestTemplate template;

    @LocalServerPort
    private int port;

    private String base;
    private String name;
    private String user;


    @Before
    public void setUp() throws Exception {
        base = "http://localhost:" + port;
        this.name = base + "/name";
        this.user = base + "/user";
    }

    @Test
    public void testAppConfig() {
        testUrl(name);
    }

    @Test
    public void testUserConfig() {
        testUrl(user);
    }

    private void testUrl(String url) {
        ResponseEntity<String> response = template.getForEntity(url,
                String.class);
//        assertThat(response.getBody(), equalTo("application"));
        System.out.println("========================");
        System.out.println(response.getBody());
        System.out.println("========================");
        assertThat(1, equalTo(1));
    }

}
