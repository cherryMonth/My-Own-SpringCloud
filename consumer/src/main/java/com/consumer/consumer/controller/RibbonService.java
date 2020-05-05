package com.consumer.consumer.controller;

import com.consumer.consumer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class RibbonService {

    @Autowired
    private RestTemplate restTemplate;

    public User findById(Long id){
        return this.restTemplate.getForObject("http://spring-cloud-producer/users/" + id, User.class);
    }
}
