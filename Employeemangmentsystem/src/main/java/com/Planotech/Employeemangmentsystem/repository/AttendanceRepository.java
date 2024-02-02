package com.Planotech.Employeemangmentsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Planotech.Employeemangmentsystem.dto.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer>{

	List<Attendance> findByEmpId(String EmpId);


}