package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Marathon")

public class Marathon {
	public Marathon(@NotNull String name, String place, Manager manager, java.sql.Date date) {
		super();
		this.name = name;
		this.place = place;
		this.manager = manager;
		this.date = date;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id_mar")
	
	private int id;
	
	private static int idCounter = 0;
	
	@NotNull
	@Column(name="Name")
	private String name;

	@NotNull
	@Column(name="Place")
	private String place;

	
	@ManyToOne
	@JoinColumn(name="ID_m")
	private Manager manager;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	@NotNull
	@Column(name="Date")
	private java.sql.Date date;
	
	public Marathon() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
