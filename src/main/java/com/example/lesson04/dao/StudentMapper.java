package com.example.lesson04.dao;

import org.springframework.stereotype.Repository;

import com.example.lesson04.domain.Student;

@Repository
public interface StudentMapper {

	public void insertStudent(Student student);
	
	public void selectStudentById(Student student);
}
