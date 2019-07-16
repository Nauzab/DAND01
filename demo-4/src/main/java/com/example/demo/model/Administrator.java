package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Table(name = "Administrator")
@Entity
public class Administrator {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="ID_a")
	private int id_a;
	

	@Size(min = 2 , max = 10) 
	//allow only letters
	//@Pattern(regexp= "[a-zA-Z]+", message = "only letters allowed")
	@Column(name ="Name")
	private String name;
	

	//@Size(min = 2 , max = 20) 
	//allow only letters
	//@Pattern(regexp= "[a-zA-Z]+", message = "only letters allowed")
	@Column(name ="Surname")
	private String surname;
	
	//@NotEmpty
	//@NotNull
	@Size(min = 6 , max = 18, message = "Invalid password") 
	//allows only letters and digits
	//@Pattern(regexp= "^[a-zA-Z0-9]+$", message = "Invalid password")
	@Column(name ="Password")
	private String password;
	
	//@NotEmpty
	//@NotNull
	//wont allow non email adress
	//@Pattern(regexp= "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$", message = "Not valid email adress")
	@Column(name ="Email")
	private String email;
	
	
	public Administrator() {}
	
	public Administrator(String name, String surname, String password, String email) {
		super();
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.email = email;
	}

	public int getId_a() {
		return id_a;
	}

	public void setId_a( int id_a) {
		this.id_a = id_a;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null) {
			this.name = "";
		}
		else {
			this.name = name;
		}

		}
		

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		if (surname == null) {
			this.surname = "";
		}
		else {
			this.surname = surname;
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (password == null) {
			this.password = "";
		}
		else {
			this.password = password;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email == null) {
			this.email = "";
		}
		else {
			this.email = email;
		}
	}
	
	
	
	
	

}