package com.devsuperior.hroauth.services;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.devsuperior.hroauth.entities.User;
import com.devsuperior.hroauth.feignclients.UserFeignClient;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserService {
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	private final UserFeignClient userFeignClient;
	
	public User findByEmail(String email) {
		User user = this.userFeignClient.findByEmail(email).getBody();
		
		if(Objects.isNull(user)) {
			logger.error("Email not found: "+ email);
			throw new IllegalArgumentException("Email not found");
		}
		logger.info("Email found: "+ email);
		return user;
	}

}
