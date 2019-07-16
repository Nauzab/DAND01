package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Constraint;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name="Runner")
public class Runner {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_r")

	private int id_r;

	
	@Column(name="Name")
	@Size(min=2, max=55)
	private String name;
	
	@Column(name="Surname")
	@Size(min=2, max=55)
	private String surname;
	
	@Column(name="Sex")
	private String sex;
	
	
	@Column(name="Password")
	@Size(min=4, max=20)
	private String password;
	

	@Column(name ="Email")

	private String email;
	
	
	
	public Runner() {
		
	}
	
	public Runner(String name,String surname, String sex, String password,String email) {
	
		setName(name);
		setSurname(surname);
		setSex(sex);
		setPassword(password);
		setEmail(email);
	}


	
	public int getId_r() {

		return id_r;

	}
	public void setId_r(int Id_r) {
		this.id_r = Id_r;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Hello " + this.name + " " + this.surname + "!";
	}
	

	
}