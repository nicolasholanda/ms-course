package com.github.nicolasholanda.hrpayroll.resources;

import com.github.nicolasholanda.hrpayroll.entities.Payment;
import com.github.nicolasholanda.hrpayroll.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    @Autowired
    private PaymentService service;

    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable("workerId") Long workerId,
                                              @PathVariable("days") Integer days) {
        return ok(service.getPayment(workerId, days));
    }
}
