package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "courses2")
public class Courses {

	@Id
	@GeneratedValue
	private int id;
	private String title;
	private String description;
	private int duration;
	private int fees;
	private boolean isDiscounted;
	private float coupan;
	@ManyToOne
	@JoinColumn(name = "student_id",nullable = false)
	private StudentBean students;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	public boolean isDiscounted() {
		return isDiscounted;
	}
	public void setDiscounted(boolean isDiscounted) {
		this.isDiscounted = isDiscounted;
	}
	public float getCoupan() {
		return coupan;
	}
	public void setCoupan(float coupan) {
		this.coupan = coupan;
	}
	
	
	
}
