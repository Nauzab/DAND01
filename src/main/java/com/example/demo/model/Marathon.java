package com.example.demo.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Marathon")

public class Marathon {
	public Marathon(/*@NotNull*/ String name, String place, Manager manager, String date) throws ParseException {
		super();
		this.name = name;
		this.place = place;
		this.manager = manager;
		this.date = date;
		//setDate(date);
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id_mar")
	
	private int id;
	
	//@NotNull
	@Column(name="Name")
	private String name;

	//@NotNull
	@Column(name="Place")
	private String place;

	
	@ManyToOne
	@JoinColumn(name="ID_m")
	private Manager manager;
	
	@ManyToMany
	@JoinColumn(name="ID_g")
	Collection<Group>group;

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) throws ParseException {
		//SimpleDateFormat smlp =  new SimpleDateFormat("dd/MM/yyyy");
		//java.util.Date d1 = smlp.parse(date);
		this.date = date;
		
		
	}

	
	
	
	//@NotNull
	@Column(name="Date")
	//private java.sql.Date date;
	private String date;
	
	public Marathon() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
