package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//@Table(name="Fit")
@Entity
public class Fit {
	@Id
	private int id;
	private String Goal;
	
    private String name;
    private String age;
 
//    @Column(name="TrackingSteps")
    private String SleepHour;
	public String getGoal() {
		return Goal;
	}
	public void setGoal(String goal) {
		Goal = goal;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	public String getSleepHour() {
		return SleepHour;
	}
	public void setSleepHour(String sleepHour) {
		SleepHour = sleepHour;
	}
	@Override
	public String toString() {
		return "Fit [Goal=" + Goal + ", id=" + id + ", name=" + name + ", age=" + age +   ", SleepHour=" + SleepHour + "]";
	}
    
}
