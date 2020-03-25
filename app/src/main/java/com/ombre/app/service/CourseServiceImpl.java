package com.ombre.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ombre.app.dao.CourseRepository;
import com.ombre.app.dao.StudentRepository;
import com.ombre.app.entity.Course;
import com.ombre.app.entity.Student;

@Service
public class CourseServiceImpl implements CourseService {

	private CourseRepository courseRepository;
	
	@Autowired
	public CourseServiceImpl(CourseRepository theCourseRepository) {
		courseRepository = theCourseRepository;
	}

	@Override
	public List<Course> findAll() {
		return courseRepository.findAll();
	}
	
	@Override
	public Course findById(int theId) {
		
		Optional<Course> result = courseRepository.findById(theId);
		
		Course theCourse = null;
		
		if(result.isPresent()) {
			theCourse = result.get();
		} else {
			// we did not find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return theCourse;
	}

	

}
