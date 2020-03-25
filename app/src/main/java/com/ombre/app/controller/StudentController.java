package com.ombre.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ombre.app.entity.Course;
import com.ombre.app.entity.Student;
import com.ombre.app.service.CourseService;
import com.ombre.app.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/list")
	public String showAllStudents(Model theModel) {
		
		List<Student> students = studentService.findAll();
		
		theModel.addAttribute("students", students);
				
		return "list-students";
	}
	
	@GetMapping("/showInfo")
	public String saveCustomer(@RequestParam("studentId") int theStudentId, 
								@RequestParam(value="courseId", required = false) Integer theCourseId, 
								@RequestParam(value="removeCourseId", required = false) Integer removeCourseId, 
								Model theModel) {	
		
		// get the student from the service
		Student theStudent = studentService.findById(theStudentId);
				
		List<Course> studentsCourses = theStudent.getCourses();
		
		List<Course> courses = courseService.findAll();
		
		if(theCourseId != null) {
			Course theCourse = courseService.findById(theCourseId);
			studentsCourses.add(theCourse);
			studentService.save(theStudent);
			
		}
		if(removeCourseId != null) {
			Course theCourse = courseService.findById(removeCourseId);
			studentsCourses.remove(theCourse);
			studentService.save(theStudent);
			
		}
		
		courses.removeAll(studentsCourses);
		
		theModel.addAttribute("studentsCourses", studentsCourses);
		
		theModel.addAttribute("courses", courses);
		
		// set student as a model attribute to pre-populate the Form
		theModel.addAttribute("student", theStudent);
				
		// send over to our form
		return "student-form";
	}
	
	@PostMapping("/saveStudent")
	public String saveStudent(@Valid @ModelAttribute("student") Student theStudent, BindingResult bindingResult) {	
		
		if(bindingResult.hasErrors()) {
			return "student-form";
		}
		
		studentService.saveStudent(theStudent);
		
		return "redirect:/student/list";
	}
	
	@GetMapping("/search")
	public String searchStudent(@RequestParam("theSearchName") String theName, Model theModel) {	
		
		
		// get customers from the service
		List<Student> theStudents = studentService.getSearchedStudents(theName);
		
		// add the customers to the model
		theModel.addAttribute("students", theStudents);
		
		// send over to our form
		return "list-students";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {	
		
		// create model attribute to bind form data
		Student theStudent = new Student();
				
		theModel.addAttribute("student", theStudent);
		
		return "student-form";
	}

}
