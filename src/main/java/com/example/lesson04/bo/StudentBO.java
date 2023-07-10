package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.dao.StudentMapper;
import com.example.lesson04.domain.Student;
import com.example.lesson07.dao.StudentRepository;
import com.example.lesson07.entity.StudentEntity;

@Service
public class StudentBO {
	
	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private StudentRepository studentRepository;

	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	public void getStudentById(Student student) {
		studentMapper.selectStudentById(student);
	}
	
	public StudentEntity addStudent(String name, String phoneNumber, String email, String dreamJob) {
		StudentEntity student = studentRepository.save(
					StudentEntity.builder()
					.name(name)
					.phoneNumber(phoneNumber)
					.email(email)
					.dreamJod(dreamJob)
					//.createdAt(ZonedDateTime.now())   @UpdateTimeStamp 생략 가능
					.build()
				);
		return student;
	}
	
	// input: id,  dreamJob
	// output: StudentEntity
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		// 기존 데이터 조회(id로)
		StudentEntity student = studentRepository.findById(id).orElse(null);
		
		// entity 변경(dreamJob 변경) => save
		if (student != null) {
			student = student.toBuilder()	// tobulider는 기존 값 유지하고 일부만 변경
				.dreamJod(dreamJob)
				.build();
			
			student = studentRepository.save(student);	//update
		}
		
		return student;
	}
}
