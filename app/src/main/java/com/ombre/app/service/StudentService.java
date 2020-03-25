package com.ombre.app.service;

import java.util.List;

import com.ombre.app.entity.Student;

public interface StudentService {

	public List<Student> findAll();

	public Student findById(int theId);

	public void save(Student theEmployee);
	
	public void deleteById(int theId);

	public long count();

	public void saveStudent(Student theStudent);

	public List<Student> getSearchedStudents(String theName);
	
}
