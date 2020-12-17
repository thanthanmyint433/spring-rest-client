package com.example.restclient.springrestclientexamples.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class UserControllerTest {
    @Autowired
    ApplicationContext applicationContext;
    WebTestClient webTestClient;
    public void setUp() throws Exception{
        webTestClient=WebTestClient.bindToApplicationContext(applicationContext).build();
    }

    @Test
    void index() {
        webTestClient.get().uri("/").exchange().expectStatus().isOk();
    }

    @Test
    void formPost() {
        MultiValueMap<String,String > formData=new LinkedMultiValueMap<>();
        formData.add("limit","3");
        webTestClient.post().uri("users")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData(formData))
                .exchange()
                .expectStatus().isOk();

    }
}