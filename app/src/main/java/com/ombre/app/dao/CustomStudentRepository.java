package com.ombre.app.dao;

import java.util.List;

import com.ombre.app.entity.Student;

public interface CustomStudentRepository {

	public List<Student> getSearchedStudents(String theName);
	
}
