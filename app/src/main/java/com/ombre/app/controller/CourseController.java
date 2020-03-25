package com.ombre.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ombre.app.entity.Course;
import com.ombre.app.entity.Student;
import com.ombre.app.service.CourseService;
import com.ombre.app.service.StudentService;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/list")
	public String showAllCourses(Model theModel) {
		
		List<Course> courses = courseService.findAll();
		
		theModel.addAttribute("courses", courses);
				
		return "list-course";
	}
	
	

}
