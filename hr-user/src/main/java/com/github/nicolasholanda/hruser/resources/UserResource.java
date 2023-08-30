package com.github.nicolasholanda.hruser.resources;

import com.github.nicolasholanda.hruser.entities.User;
import com.github.nicolasholanda.hruser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserRepository repository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id) {
        User user = repository.findById(id).get();
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> search(@RequestParam("email") String email) {
        User user = repository.findByEmail(email);
        return ResponseEntity.ok(user);
    }
}
