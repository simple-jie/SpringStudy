package com.example.demo;

import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setup() {
        userRepository.deleteAll();
    }

    @Test
    public void contextLoads() {
        userRepository.save(new User(
                0,
                "测试1",
                "123456",
                null,
                null,
                null
        ));

        Assert.assertEquals(userRepository.count(), 1L);
        User user = userRepository.findUserByUserName("测试1");
        Assert.assertEquals(
                user.getPassword(),
                "123456"
        );
        System.out.println("+++++++++++++++++测试1");
        System.out.println("User:" + user.toString());
        System.out.println("User:" + user.getUserName().equals("测试1"));
        System.out.println("+++++++++++++++++");

    }

}
