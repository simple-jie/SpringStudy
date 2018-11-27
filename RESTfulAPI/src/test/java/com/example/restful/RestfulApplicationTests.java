package com.example.restful;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestfulApplicationTests {

    private MockMvc mvc;


    @Before
    public void setup() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void contextLoads() throws Exception {
        RequestBuilder request = null;

        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));

        request = post("/users/")
                .param("id", "1")
                .param("name", "Master")
                .param("age", "80");

        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("success"));

        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"id\":1,\"name\":\"Master\",\"age\":80}]"));


        request = put("/users/1")
                .param("age", "50")
                .param("name", "大神");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("success"));

        request = get("/users/1");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"name\":\"大神\",\"age\":50}"));

        request = delete("/users/1");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("success"));

        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }

}
