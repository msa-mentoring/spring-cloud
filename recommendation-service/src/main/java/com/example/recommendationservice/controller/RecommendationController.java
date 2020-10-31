package com.example.recommendationservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class RecommendationController {

    @Value("${contents.name}")
    private String contentsName;

    @GetMapping("/")
    public String getContents(){
        return contentsName;
    }
}
