package com.example.restclient.springrestclientexamples.Service;

import com.example.restclient.api.domain.User;

import java.util.List;

public interface ApiService {
    List<User> getUser(Integer limit);
}
