package com.github.nicolasholanda.hrworker.repositories;

import com.github.nicolasholanda.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
