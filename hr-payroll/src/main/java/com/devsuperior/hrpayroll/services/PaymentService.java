package com.devsuperior.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;
import com.devsuperior.hrpayroll.feignClients.WorkerFeignClient;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaymentService {

	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(long workerId, int days) {
		Worker worker = this.workerFeignClient.findById(workerId).getBody();
		return Payment.builder().name(worker.getName()).dailyIncome(worker.getDailyIncome()).days(days).build();
	}

}
