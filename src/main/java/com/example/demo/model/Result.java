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

	private Random random;
	
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

	public void generetaResult(double distance) {
			random = null;
			final int millisInDay = 24+60*60*100;
			Time time;
			int m;
			
		if(distance == 5.0 ) {
			 m = random.nextInt(7) + 20;
			time = new Time((long)random.nextInt(millisInDay) -m*60*60*100) ;
			
				setValue(time);
		}
		else if (distance == 10.0) {
			m = random.nextInt(8) + 16;
			time = new Time((long)random.nextInt(millisInDay) -m*60*60*100) ;
			setValue(time);
		}
		else if(distance == 21.0975) {
			m = random.nextInt(10) + 6;
			time = new Time((long)random.nextInt(millisInDay) -m*60*60*100) ;
		}
		else if(distance == 42.195) {
			time = new Time((long)random.nextInt(millisInDay));
			setValue(time);;
		}
	
		
	}
	
	
}
