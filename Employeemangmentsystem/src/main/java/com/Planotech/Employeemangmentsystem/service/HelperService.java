package com.Planotech.Employeemangmentsystem.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.Planotech.Employeemangmentsystem.dto.Attendance;
import com.Planotech.Employeemangmentsystem.helper.ExcelHelper;
import com.Planotech.Employeemangmentsystem.repository.AttendanceRepository;

@Component
public class HelperService {
	@Autowired
	AttendanceRepository attendanceRepository;
	@Autowired
	ExcelHelper excelHelper;
	public void save(MultipartFile file) {
		try {
			List<Attendance> attendance=excelHelper.convertExcelToList(file.getInputStream());
			attendanceRepository.saveAll(attendance);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	public List<Attendance> getAllAttendanceById(String EmpId){
		List<Attendance> list = attendanceRepository.findByEmpId(EmpId);
		return list;
	}
}
