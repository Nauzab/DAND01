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
	 
	 @OneToOne
	 @JoinColumn(name = "ID_res")//(mappedBy = "registration")
	    private Result result;
	 
	public Registration() {
		super();
	}
	
	

	public Registration( Group group, Runner runner, Result result) {
		super();
			this.group = group;
		this.runner = runner;
		this.result = result;
	}



	public int getId_reg() {
		return id_reg;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Runner getRunner() {
		return runner;
	}

	public void setRunner(Runner runner) {
		this.runner = runner;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}
	
	

	
}