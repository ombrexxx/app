package com.ombre.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ombre.app.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
