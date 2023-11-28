package com.api.hotel.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;

	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;

	@Column(name = "disabled", columnDefinition = "TINYINT(1)")
	private Boolean disabled;
	
	@Column(name = "locked", columnDefinition = "TINYINT(1)")
	private Boolean locked;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Role> roles;

}
