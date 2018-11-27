package com.example.property;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertyApplicationTests {


    @Autowired
    private SimpleProperty property;

    @Test
    public void contextLoads() {

        System.out.println();
        System.out.println();
        System.out.println("===================================");
        System.out.println(property.getDescription());

        System.out.println(property.getRandomInt10to20());
        System.out.println(property.getRandomValue());
        System.out.println(property.getRandomInt());

        System.out.println("===================================");
        System.out.println();
        System.out.println();

        Assert.assertEquals(property.getName(), "揭兴波");
    }

}
