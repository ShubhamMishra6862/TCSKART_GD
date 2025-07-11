package org.tcskart.user_microservice.entity;


import org.antlr.v4.runtime.misc.NotNull;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
   @Column(unique = true,nullable = false)
	private String username;
	private String name;
    @Column(nullable = false)
	private String phone;
    @Column(nullable = false)
	private String address;
    @Column(nullable = false)
	private String password;
    @Column(nullable = false)
	private String role;
  
	
}
