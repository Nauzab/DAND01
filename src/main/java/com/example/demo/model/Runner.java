package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="Runner")
public class Runner {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_r")
	private int ID_r;
	
	@Column(name="Name")
	@Size(min=2, max=55)
	private String name;
	
	@Column(name="Surname")
	@Size(min=2, max=55)
	private String surname;
	
	@Column(name="Sex")
	@Size(min=2,max=10)
	private String sex;
	
	@Column(name="Password")
	@Size(min=4, max=20)
	private String password;
	
	@Column(name ="E-mail")
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


	
	public int getID_r() {
		return ID_r;
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
		return "Runner [name=" + name + ", surname=" + surname + ", sex=" + sex + ", password=" + password + ", email="
				+ email + "]";
	}
	

	
}
