package com.example.restclient.springrestclientexamples.Service;

import com.example.restclient.api.domain.User;
import com.example.restclient.api.domain.UserData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;

import java.util.List;
@Service
public class ApiServiceImpl implements ApiService{

    private RestTemplate restTemplate;
    private final String api_url;

    public ApiServiceImpl(RestTemplate restTemplate,@Value("${api.url}") String api_url) {
        this.restTemplate = restTemplate;
        this.api_url = api_url;
    }

    @Override
    public List<User> getUser(Integer limit) {
        UriComponentsBuilder uriComponentsBuilder=UriComponentsBuilder
                .fromUriString(api_url)
                .queryParam("limit",limit);
        UserData userData=restTemplate.getForObject(uriComponentsBuilder.toUriString(),UserData.class);
        return userData.getData();
    }

    @Override
    public Flux<User> getUser(Flux<Integer> limit) {

        return WebClient
                .create(api_url)
                .get()
                .uri(uriBuilder -> uriBuilder.queryParam("limit",limit.blockFirst()).build())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(clientResponse -> clientResponse.bodyToMono(UserData.class))
                .flatMapIterable(UserData::getData);
    }


}
