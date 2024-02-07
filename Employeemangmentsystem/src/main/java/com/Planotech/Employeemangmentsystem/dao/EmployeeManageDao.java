package com.Planotech.Employeemangmentsystem.dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Planotech.Employeemangmentsystem.dto.AccountsDepartment;
import com.Planotech.Employeemangmentsystem.dto.ClientServicingDepartment;
import com.Planotech.Employeemangmentsystem.dto.DesignDepartment;
import com.Planotech.Employeemangmentsystem.dto.EmployeeManage;
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
public class EmployeeManageDao {
	@Autowired
	EmployeeManageRepository manageRepository;
	@Autowired
	ITDepartmentRepository itDepartmentRepository;
	@Autowired
	HRDepartmentRepository hrDepartmentRepository;
	@Autowired
	AccountsDepartmentRepository accountsDepartmentRepository;
	@Autowired
	ClientServicingDepartmentRepository clientServicingDepartmentRepository;
	@Autowired
	ProductionDepartmentRepository productionDepartmentRepository;
	@Autowired
	MarketingDepartmentRepository marketingDepartmentRepository;
	@Autowired
	DesignDepartmentRepository designDepartmentRepository;

	public List<EmployeeManage> findByEmailOrPhone(String email, long phone) {
		return manageRepository.findByEmailOrPhone(email, phone);
	}

	public void saveallemp(EmployeeManage employeeManage) {
		manageRepository.save(employeeManage);
	}

	public void saveprofileIT(ITDepartment i) {
		itDepartmentRepository.save(i);
	}

	public Optional<ITDepartment> findByIT(int id) {
		return itDepartmentRepository.findById(id);
	}

	public Optional<HRDepartment> findByHR(int id) {
		return hrDepartmentRepository.findById(id);
	}

	public Optional<AccountsDepartment> findByAccounts(int id) {
		return accountsDepartmentRepository.findById(id);
	}

	public Optional<ProductionDepartment> findByProduction(int id) {
		return productionDepartmentRepository.findById(id);
	}

	public Optional<DesignDepartment> findByDesign(int id) {
		return designDepartmentRepository.findById(id);
	}

	public Optional<ClientServicingDepartment> findByClientServicing(int id) {
		return clientServicingDepartmentRepository.findById(id);
	}

	public Optional<MarketingDepartment> findByMarketing(int id) {
		return marketingDepartmentRepository.findById(id);
	}

	public void saveIT(ITDepartment it) {
		itDepartmentRepository.save(it);
	}

	public void saveHR(HRDepartment hr) {
		hrDepartmentRepository.save(hr);
	}

	public void saveAccounts(AccountsDepartment acc) {
		accountsDepartmentRepository.save(acc);
	}

	public void saveProduction(ProductionDepartment pro) {
		productionDepartmentRepository.save(pro);
	}

	public void saveDesign(DesignDepartment des) {
		designDepartmentRepository.save(des);
	}

	public void saveClientServicing(ClientServicingDepartment cs) {
		clientServicingDepartmentRepository.save(cs);
	}

	public void saveMarketing(MarketingDepartment mar) {
		marketingDepartmentRepository.save(mar);
	}

	public List<Integer> findAllId() {
		List<EmployeeManage> entities = manageRepository.findAll();
		List<Integer> ids = entities.stream().map(EmployeeManage::getId).collect(Collectors.toList());
		return ids;
	}
}
