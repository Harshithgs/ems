package com.Planotech.Employeemangmentsystem.contoroller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Planotech.Employeemangmentsystem.dto.EmployeeManage;
import com.Planotech.Employeemangmentsystem.service.EmployeeManageService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/employee")
public class EmployeeManageController {
	@Autowired
	EmployeeManageService manageService;
	
	@Autowired
	EmployeeManage employeeManage;
	
	@PostMapping("/signup")
	public String signup(EmployeeManage emp,ModelMap map)
	{	
		return manageService.signup(emp, map);
	}
	@PostMapping("/login")
	public String login(@RequestParam String emph, @RequestParam String password, ModelMap map, HttpSession session) {
		return manageService.login(emph, password, map, session);
	}
	@GetMapping("/report")
	public String loadReport(@RequestParam String department,@RequestParam int Id,ModelMap map,HttpSession httpSession) {
		map.put("Id", Id);
		map.put("department", department);
		return "Report.html";
	}
	@GetMapping("/reportSubmit")
	public String ReportSubmit(@RequestParam String department,@RequestParam String report,@RequestParam int Id,ModelMap map,HttpSession httpSession) {
		return manageService.reportSubmit(department, report, Id, map, httpSession);
	}
	@GetMapping("/profile/{id}/{department}")
	public String Profile(@PathVariable int id, @PathVariable String department,ModelMap map,HttpSession httpSession) {
		return manageService.editProfile(id,department,httpSession,map);
	}
	@PostMapping("/profile")
	public String profile(@RequestParam int Id,@RequestParam String username, @RequestParam String email, @RequestParam long phone,
			@RequestParam String address, @RequestParam String department, ModelMap map, HttpSession session) {
		return manageService.profile(Id,username, email, phone, address, department, map, session);
	}
}
