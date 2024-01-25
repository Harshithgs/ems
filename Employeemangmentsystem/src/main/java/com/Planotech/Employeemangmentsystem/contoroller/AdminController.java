package com.Planotech.Employeemangmentsystem.contoroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Planotech.Employeemangmentsystem.service.AdminService;
import com.Planotech.Employeemangmentsystem.service.EmployeeManageService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminService;
	@GetMapping("/department")
	public String Department(@RequestParam String department, ModelMap map, HttpSession httpSession) {
		if(httpSession.getAttribute("admin")!=null) {
		return adminService.Department(department, httpSession, map);
		}else {
			map.put("fail", "login again");
			return "login.html";
		}
	}

	@GetMapping("/report/{id}/{department}")
	public String Report(@PathVariable int id, @PathVariable String department, ModelMap map, HttpSession httpSession) {
		return adminService.Report(id, department, map, httpSession);
	}

	@PostMapping("/score")
	public String score(@RequestParam Double dailyScore, @RequestParam int id,
			@RequestParam String department, HttpSession httpSession,ModelMap map) {
		return adminService.score(id,dailyScore,department,httpSession,map);
	}
	@GetMapping("/adminHome")
	public String AdminHome(HttpSession httpSession) {
		return "AdminHome.html";
	}
	@GetMapping("/emphometable/{department}")
	public String empHome(@PathVariable String department,HttpSession httpSession,ModelMap map) {
		return adminService.EmpHomeTable(department,httpSession,map);
	}
}
