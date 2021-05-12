package com.devsuperior.hroauth.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Include
	private Long id;

	private String name;

	private String email;

	private String password;

	Set<Role> roles = new HashSet<>();

}
