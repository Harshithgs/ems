package com.Planotech.Employeemangmentsystem.contoroller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Planotech.Employeemangmentsystem.helper.ExcelHelper;
import com.Planotech.Employeemangmentsystem.service.AdminService;
import com.Planotech.Employeemangmentsystem.service.HelperService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminService;
	@Autowired
	ExcelHelper excelHelper;
	@Autowired
	HelperService helperService;
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
//		LocalDate currentDate = LocalDate.now();
//		String useDate = "" + currentDate.getDayOfMonth() + "/" + currentDate.getMonthValue() + "/"
//				+ currentDate.getYear();
//		adminService.updateInAndOut(useDate);
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
	@GetMapping("/attandace/{id}/{department}")
	public String Attandace(@PathVariable int id, @PathVariable String department, ModelMap map, HttpSession httpSession) {
		return adminService.Attandace(id, department, map, httpSession);
	}
	@PostMapping(value = "/upload", consumes = "multipart/form-data")
	public String upload(@RequestParam MultipartFile file, HttpSession httpSession, ModelMap map) {
	    if (excelHelper.checkExcelFormat(file)) {
	        helperService.save(file);
	        LocalDate currentDate = LocalDate.now();
			String useDate = "" + currentDate.getDayOfMonth() + "/" + currentDate.getMonthValue() + "/"
					+ currentDate.getYear();
			adminService.updateInAndOut(useDate);
	        map.put("pass", "Uploaded");
	        return "AdminHome.html";
	    } else {
	        map.put("fail", "Please upload an Excel file");
	        return "AdminHome.html";
	    }
	}
	@PostMapping("/sala")
	public String Salary(@RequestParam String department,@RequestParam double salary,@RequestParam int id,ModelMap map,HttpSession httpSession) {
		return adminService.salary(department, salary, id, map, httpSession);

	}
	@GetMapping("/salary/{id}/{department}")
	public String UpdateSalary(@PathVariable int id, @PathVariable String department, ModelMap map, HttpSession httpSession) {
//		System.out.println(id+" "+department);
		return adminService.loadsalary(id, department, map, httpSession);
	}
}
