package com.login.service.loginservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.login.service.loginservice.annotations.ValidPassword;

import java.util.Set;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Setter
	@Getter
	@Column(name = "username", nullable = false)
	@Size(min = 7)
	private String username;

	@Setter
	@Getter
	@Column(name = "password", nullable = false)
	@ValidPassword
	private String password;

	@Setter
	@Getter
	@Transient
	private String confrimPassword;

	@Setter
	@Getter
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "roles_id"))
	private Set<Role> roles;

}
