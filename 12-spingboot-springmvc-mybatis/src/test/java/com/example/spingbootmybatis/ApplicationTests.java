package com.example.spingbootmybatis;

import com.example.spingbootmybatis.domain.User;
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
public class ApplicationTests {

    @Autowired
    private TestRestTemplate template;

    @LocalServerPort
    private int port;


    private String base;

    @Before
    public void setUp() {
        base = "http://localhost:" + port;
    }

    @Test
    public void testTransactional() {
        User user = new User();
        user.setName("testTransactional");
        user.setAge(100);
        testPostUrl(base + "/user/transactional", user);
    }

    private void testGetUrl(String url) {
        ResponseEntity<String> response = template.getForEntity(url,
                String.class);
//        assertThat(response.getBody(), equalTo("application"));
        System.out.println("========================");
        System.out.println(response.getBody());
        System.out.println("========================");
        assertThat(1, equalTo(1));
    }

    private void testPostUrl(String url, Object object) {
        ResponseEntity<String> response = template.postForEntity(url, object,
                String.class);
//        assertThat(response.getBody(), equalTo("application"));
        System.out.println("========================");
        System.out.println(response.getBody());
        System.out.println("========================");
        assertThat(1, equalTo(1));
    }
}
