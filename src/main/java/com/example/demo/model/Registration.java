package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Registration")
@Entity
public class Registration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="ID_reg")
	private int id_reg;

	
	public Registration() {
		super();
	}

	public int getId_reg() {
		return id_reg;
	}

	
}
