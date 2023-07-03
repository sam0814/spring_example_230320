package com.example.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBO;

@Controller
@RequestMapping("/lesson06/ex01")
public class Lesson06Ex01Controller {
	
	@Autowired
	private UserBO userBo;
	
	// 회원가입 페이지
	@GetMapping("/add_user_view")
	public String addUserView() {
		return "lesson06/addUser";
	}
	
	// AJAX가 요청한 곳 => response String(data)이어야 함
	@PostMapping("/add_user")
	@ResponseBody	// String data
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "introduce", required = false) String introduce) {
		
		// db insert
		userBo.addUser(name, yyyymmdd, introduce);
		// return string
		return "성공";
	}
	
	// 입력 성공 페이지
	@GetMapping("after_add_user_view")
	public String afterAddUserView() {
		return "lesson06/afterAddUser";
	}
	
}
