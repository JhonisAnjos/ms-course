package com.devsuperior.hrpayroll.entities;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Worker implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Include
	private Long id;
	
	private String name;
	
	private Double dailyIncome;

}
