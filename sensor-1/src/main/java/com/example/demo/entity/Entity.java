package com.example.demo.entity;

//import org.hibernate.annotations.Table;

import jakarta.persistence.Id;

@jakarta.persistence.Entity
@jakarta.persistence.Table(name="ultrasonic")
public class Entity {
	
	@Id
	private Integer id;
	
	private int distance_in_inch;
	private int distance_in_cm;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getDistance_in_inch() {
		return distance_in_inch;
	}
	public void setDistance_in_inch(int distance_in_inch) {
		this.distance_in_inch = distance_in_inch;
	}
	public int getDistance_in_cm() {
		return distance_in_cm;
	}
	public void setDistance_in_cm(int distance_in_cm) {
		this.distance_in_cm = distance_in_cm;
	}
	
	
}
