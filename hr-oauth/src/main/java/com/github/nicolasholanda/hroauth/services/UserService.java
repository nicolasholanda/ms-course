package com.github.nicolasholanda.hroauth.services;

import com.github.nicolasholanda.hroauth.entities.User;
import com.github.nicolasholanda.hroauth.feignclients.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email) {
        return Optional.ofNullable(userFeignClient.search(email).getBody())
                .orElseThrow(() -> new IllegalArgumentException("Email not found"));
    }
}
