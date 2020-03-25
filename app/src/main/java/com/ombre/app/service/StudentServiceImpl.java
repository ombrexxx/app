package com.ombre.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ombre.app.dao.StudentRepository;
import com.ombre.app.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;
	
	@Autowired
	public StudentServiceImpl(StudentRepository theStudentRepository) {
		studentRepository = theStudentRepository;
	}

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findById(int theId) {
		
		Optional<Student> result = studentRepository.findById(theId);
		
		Student theStudent = null;
		
		if(result.isPresent()) {
			theStudent = result.get();
		} else {
			// we did not find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return theStudent;
	}

	@Override
	public void save(Student theStudent) {
		studentRepository.save(theStudent);
	}

	@Override
	public void deleteById(int theId) {

		studentRepository.deleteById(theId);
		
	}

	@Override
	public long count() {
		
		return studentRepository.count();
	}

	@Override
	public void saveStudent(Student theStudent) {
		
		studentRepository.save(theStudent);
		
	}

	@Override
	public List<Student> getSearchedStudents(String theName) {
		
		return studentRepository.getSearchedStudents(theName);
	}


}
