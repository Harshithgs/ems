package com.Planotech.Employeemangmentsystem.dto;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Component
@Data
@Entity

public class ClientServicingDepartment {
	@Id
	private int id;
	private String username;
	private String email;
	private long mobile;
	private String addres;
	private String report;
	private String intime;
	private String outtime;
	private int leaves;
	private double salary;
	private double dailyscroe;
	private double totalscroe;
	private String location;
}
