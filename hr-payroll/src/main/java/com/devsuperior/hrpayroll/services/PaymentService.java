package com.devsuperior.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaymentService {

	private RestTemplate restTemplate;

	@Value("${http://localhost:8001}")
	private String workerHost;

	public Payment getPayment(long workerId, int days) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", String.valueOf(workerId));

		Worker worker = this.restTemplate.getForObject("workers/{id}", Worker.class, uriVariables);
		return Payment.builder().name(worker.getName()).dailyIncome(worker.getDailyIncome()).days(days).build();
	}

}
