package com.devsuperior.hrpayroll.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/payments")
@AllArgsConstructor
public class PaymentResource {
	
	private PaymentService service;
	
	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days){
		Payment obj = this.service.getPayment(workerId, days);
		return ResponseEntity.ok().body(obj);
	}
	
	public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days){
		Payment obj = Payment.builder().name("Bran").dailyIncome(200.0).days(15).build();
		return ResponseEntity.ok().body(obj);
	}


}
