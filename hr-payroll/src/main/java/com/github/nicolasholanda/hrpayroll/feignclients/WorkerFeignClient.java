package com.github.nicolasholanda.hrpayroll.feignclients;

import com.github.nicolasholanda.hrpayroll.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(name = "hr-worker", path = "/workers")
public interface WorkerFeignClient {

    @GetMapping
    ResponseEntity<List<Worker>> findAll();

    @GetMapping("{id}")
    ResponseEntity<Worker> findById(@PathVariable("id") Long id);
}
