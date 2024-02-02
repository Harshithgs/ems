package com.Planotech.Employeemangmentsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Planotech.Employeemangmentsystem.dto.AccountsDepartment;
import com.Planotech.Employeemangmentsystem.dto.ClientServicingDepartment;
import com.Planotech.Employeemangmentsystem.dto.DesignDepartment;
import com.Planotech.Employeemangmentsystem.dto.HRDepartment;
import com.Planotech.Employeemangmentsystem.dto.ITDepartment;
import com.Planotech.Employeemangmentsystem.dto.MarketingDepartment;
import com.Planotech.Employeemangmentsystem.dto.ProductionDepartment;
import com.Planotech.Employeemangmentsystem.repository.AccountsDepartmentRepository;
import com.Planotech.Employeemangmentsystem.repository.ClientServicingDepartmentRepository;
import com.Planotech.Employeemangmentsystem.repository.DesignDepartmentRepository;
import com.Planotech.Employeemangmentsystem.repository.EmployeeManageRepository;
import com.Planotech.Employeemangmentsystem.repository.HRDepartmentRepository;
import com.Planotech.Employeemangmentsystem.repository.ITDepartmentRepository;
import com.Planotech.Employeemangmentsystem.repository.MarketingDepartmentRepository;
import com.Planotech.Employeemangmentsystem.repository.ProductionDepartmentRepository;

@Component
public class AdminDao {
	@Autowired
	EmployeeManageRepository manageRepository;
	@Autowired
	ITDepartmentRepository itDepartmentRepository;
	@Autowired
	AccountsDepartmentRepository accountsDepartmentRepository;
	@Autowired
	ClientServicingDepartmentRepository clientServicingDepartmentRepository;
	@Autowired
	EmployeeManageRepository employeeManageRepository;
	@Autowired
	HRDepartmentRepository hrDepartmentRepository;
	@Autowired
	MarketingDepartmentRepository marketingDepartmentRepository;
	@Autowired
	ProductionDepartmentRepository productionDepartmentRepository;
	@Autowired
	DesignDepartmentRepository departmentRepository;

	public List<ITDepartment> fetchAllItTable() {
		return itDepartmentRepository.findAll();
	}

	public List<HRDepartment> fecthAllHRtable() {
		return hrDepartmentRepository.findAll();

	}

	public List<AccountsDepartment> fecthAllAccountsTable() {
		return accountsDepartmentRepository.findAll();

	}

	public List<ClientServicingDepartment> fecthAllClientServicingTable() {
		return clientServicingDepartmentRepository.findAll();

	}

	public List<MarketingDepartment> fecthAllMarketingTable() {
		return marketingDepartmentRepository.findAll();

	}

	public List<ProductionDepartment> fecthAllProductionTable() {
		return productionDepartmentRepository.findAll();

	}

	public List<DesignDepartment> fecthAllDesignTable() {
		return departmentRepository.findAll();

	}
	
	public Optional<ITDepartment> findITReport(int id) {
			return itDepartmentRepository.findById(id);
	}
	public Optional<HRDepartment> findHRReport(int id) {
			return hrDepartmentRepository.findById(id);
	}
	public Optional<AccountsDepartment> findAccountsReport(int id) {
		return accountsDepartmentRepository.findById(id);
	}
	public Optional<ClientServicingDepartment> findClientServicingReport(int id) {
		return clientServicingDepartmentRepository.findById(id);
	}
	public Optional<ProductionDepartment> findProductionReport(int id) {
		return productionDepartmentRepository.findById(id);
	}
	public Optional<MarketingDepartment> findMarketingReport(int id) {
		return marketingDepartmentRepository.findById(id);
	}
	public Optional<DesignDepartment> findDesignReport(int id) {
		return departmentRepository.findById(id);
	}
	
}
