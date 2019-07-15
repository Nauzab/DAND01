package com.example.demo.model;

import java.text.ParseException;
import java.util.Collection;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Table(name = "GroupTable")
@Entity
public class Group {
	public Group(/*@NotNull*/ double distance, Marathon marathon) {
		super();
		this.distance = distance;
		this.marathon = marathon;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="ID_g")
	private int id_g;
	
	
	//@NotNull
	@Column(name ="Distance")
	private double distance;
	
	@ManyToOne
	@JoinColumn(name="ID_mar")
	private Marathon marathon;


	@OneToMany(mappedBy = "group")
	private Collection<Registration> registration;
	
	public Group() {}
	
	public Group(double distance) {
		super();
		 setDistance(distance);
	}

	public int getId_g() {
		return id_g;
	}

	public double getDistance() {
		
		return distance;
	}

	public void setDistance(double distance) {
		if(distance == 5.0 || distance == 10.0 || distance == 21.0975 || distance == 42.195)
		this.distance = distance;
		else
			this.distance = 5.0;
	}
	
	public Marathon getMarathon() {
		return marathon;
	}

	
}