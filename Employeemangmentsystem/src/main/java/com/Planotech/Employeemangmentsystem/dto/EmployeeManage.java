package com.Planotech.Employeemangmentsystem.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Component
@Data
@Entity

public class EmployeeManage {
	@Id
	private int id;
	private String username;
	private String email;
	private String password;
	private long phone;
	private String gender;
	private String deptarment;
	private LocalDate dob;

}
