package com.example.restclient.springrestclientexamples.Service;

import com.example.restclient.api.domain.User;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiServiceImplTest {
    @Autowired
    ApiService apiService;

    @Test
    public void testGetUsers() throws Exception {
        List<User> apiUser=apiService.getUser(3);
        assertEquals(3,apiUser.size());
    }

    @BeforeEach
    void setUp() {
    }
}