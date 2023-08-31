package com.github.nicolasholanda.hroauth.services;

import com.github.nicolasholanda.hroauth.entities.User;
import com.github.nicolasholanda.hroauth.feignclients.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email) {
        return Optional.ofNullable(userFeignClient.search(email).getBody())
                .orElseThrow(() -> new UsernameNotFoundException("Email not found"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.findByEmail(username);
    }
}
