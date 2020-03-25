package com.ombre.app.service;

import java.util.List;

import com.ombre.app.entity.Course;

public interface CourseService {

	List<Course> findAll();

	Course findById(int theId);

}
