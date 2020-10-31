package com.example.netflixservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NetflixController {

    private static final String API_GATEWAY = "http://localhost:9999/api/%s";

    private final RestTemplate restTemplate;

    public NetflixController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("")
    public String getMain(){
        String users = restTemplate.getForObject(String.format(API_GATEWAY, "users"), String.class);
        String contents = restTemplate.getForObject(String.format(API_GATEWAY, "recommendations"), String.class);

        return String.format("\"%s\" 님에게 추천드리는 컨텐츠는 \"%s\" 입니다.", users, contents);
    }


}
