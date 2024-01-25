package com.Planotech.Employeemangmentsystem.contoroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Planotech.Employeemangmentsystem.service.AdminService;
import com.Planotech.Employeemangmentsystem.service.EmployeeManageService;

import jakarta.servlet.http.HttpSession;

@Controller
public class commoncontroller {
	@Autowired
	EmployeeManageService employeeManageService;
	@Autowired
	AdminService adminService;
	@GetMapping("/")
	public String loadHome() {
		return "homepage";
	}

	@GetMapping("/about-us")
	public String loadAboutUs() {
		return "AboutUs";
	}

	@GetMapping("/login")
	public String loadLogin() {
		return "login.html";
	}

	@GetMapping("/signup")
	public String loadSignup() {
		return "Signup";
	}

	@GetMapping("/profile")
	public String loadprofile(@RequestParam int Id,@RequestParam String department,ModelMap map) {
		map.put("Id",Id);
		map.put("department", department);
		return "Profile.html";
	}

	@PostMapping("/profile")
	public String profile(@RequestParam int Id,@RequestParam String username, @RequestParam String email, @RequestParam long phone,
			@RequestParam String address, @RequestParam String department, ModelMap map, HttpSession session) {
		return employeeManageService.profile(Id,username, email, phone, address, department, map, session);
	}
	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap map) {
		session.invalidate();
		map.put("pass", "Logout Success");
		return "login.html";
	}
	@GetMapping("/emphome/{department}/{Id}")
	public String empHome(@PathVariable String department,@PathVariable int Id,HttpSession httpSession,ModelMap map) {
		return employeeManageService.empHome(department,Id,httpSession,map);
	}
}
