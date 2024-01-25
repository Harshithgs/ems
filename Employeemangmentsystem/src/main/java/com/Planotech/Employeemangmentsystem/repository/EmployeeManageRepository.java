package com.Planotech.Employeemangmentsystem.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Planotech.Employeemangmentsystem.dto.EmployeeManage;

public interface EmployeeManageRepository extends JpaRepository<EmployeeManage, Integer>{
	List<EmployeeManage> findByEmailOrPhone(String email, long phone);
}
