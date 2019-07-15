package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "Registration")
@Entity
public class Registration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="ID_reg")
	private int id_reg;

	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "ID_g")
	 private Group group;
	 
	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "ID_r")
	 private Runner runner;
	 
	 @OneToOne(mappedBy = "registration")
	    private Result result;
	 
	public Registration() {
		super();
	}

	public int getId_reg() {
		return id_reg;
	}

	
}