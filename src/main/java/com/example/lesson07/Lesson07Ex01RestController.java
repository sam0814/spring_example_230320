package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07/ex01")
@RestController
public class Lesson07Ex01RestController {
	
	@Autowired
	private StudentBO studentBO;
	
	// CUD
	
	// C: Create
	@GetMapping("/1")
	public StudentEntity create() {
		String name = "송새미";
		String phoneNumber = "010-1111-2222";
		String email = "songsaemiye@naver.com";
		String dreamJob = "개발자";
		
		StudentEntity student = studentBO.addStudent(name, phoneNumber, email, dreamJob);
		return student;		// @ResponseBody + return 객체 => JSON
	}
	
	// U : Update
	@GetMapping("/2")
	public StudentEntity update() {
		// id가 5번인 dreamJob 변경 => 디자이너
		StudentEntity student = studentBO.updateStudentDreamJobById(5, "디자이너");
		return student;
	}
}
