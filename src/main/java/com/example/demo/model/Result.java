package com.example.demo.model;

import java.sql.Time;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "Result")
@Entity
public class Result {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="ID_res")
	private int id_res;
	
	@Column(name ="Value")
	private Time value;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_reg")
    private Registration registration;
	public Result() {}
	
	public Result(Time value) {
		super();
		this.value = value;
	}

	public int getId_res() {
		return id_res;
	}


	public Time getValue() {
		return value;
	}

	public void setValue(Time value) {
		this.value = value;
	}

	public Time generetaResult(int count, double distance) {
	
		
		
		return value;
		
	}
	
	
}