package com.example.restclient.springrestclientexamples.Service;

import com.example.restclient.api.domain.User;
import reactor.core.publisher.Flux;

import java.util.List;

public interface ApiService {
    List<User> getUser(Integer limit);
    Flux<User> getUser(Flux<Integer> limit);
}
