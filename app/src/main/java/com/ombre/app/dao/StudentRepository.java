package com.ombre.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ombre.app.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>, CustomStudentRepository {
	
}
