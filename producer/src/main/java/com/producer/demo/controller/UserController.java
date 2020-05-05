package com.producer.demo.controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import com.producer.demo.entity.User;
import com.producer.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author song
 */
@RequestMapping("/users")
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    // 服务注册
    private Registration registration;

    @Autowired
    // 服务发现客户端
    private DiscoveryClient discoveryClient;

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable Long id) {
        return this.userRepository.findById(id);
    }

    @GetMapping("/instance-info")
    public ServiceInstance showInfo(){
        List<ServiceInstance> list = this.discoveryClient.getInstances(registration.getServiceId());
        if (list != null && list.size() >0){
            return list.get(0);
        }
        else{
            return null;
        }
    }
}
