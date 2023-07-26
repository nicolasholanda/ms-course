package com.github.nicolasholanda.hrworker.resources;

import com.github.nicolasholanda.hrworker.entities.Worker;
import com.github.nicolasholanda.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RefreshScope
@RestController
@RequestMapping("/workers")
public class WorkerResource {

    private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

    @Value("${test.config}")
    private String testConfig;

    @Autowired
    private Environment env;

    @Autowired
    private WorkerRepository repository;

    @GetMapping("/configs")
    public ResponseEntity<Void> getConfig() {
        logger.info("Config = " + testConfig);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        return ok(repository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Worker> findById(@PathVariable("id") Long id) {
        logger.info("Port = " + env.getProperty("local.server.port"));
        return ok(repository.findById(id).orElseGet(null));
    }
}
