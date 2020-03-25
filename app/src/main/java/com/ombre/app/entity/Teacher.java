package com.ombre.app.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher extends Person {

	
	//private List<Course> listOfCourses;
	
	public Teacher() {
		
	}

	

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
}
