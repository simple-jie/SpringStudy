package com.example.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private UserService userService;

    @Before
    public void setup() {
        userService.deleteAll();
    }

    @Test
    public void contextLoads() throws Exception {
        userService.create("名字1", "123456");
        Assert.assertEquals(userService.getUserCount().intValue(), 1);

        userService.deleteByName("名字1");
        Assert.assertEquals(userService.getUserCount().intValue(), 0);
    }

}
