package com.Planotech.Employeemangmentsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.Planotech.Employeemangmentsystem.dao.EmployeeManageDao;
import com.Planotech.Employeemangmentsystem.dto.AccountsDepartment;
import com.Planotech.Employeemangmentsystem.dto.ClientServicingDepartment;
import com.Planotech.Employeemangmentsystem.dto.DesignDepartment;
import com.Planotech.Employeemangmentsystem.dto.EmployeeManage;
import com.Planotech.Employeemangmentsystem.dto.HRDepartment;
import com.Planotech.Employeemangmentsystem.dto.ITDepartment;
import com.Planotech.Employeemangmentsystem.dto.MarketingDepartment;
import com.Planotech.Employeemangmentsystem.dto.ProductionDepartment;

import jakarta.servlet.http.HttpSession;

@Component
@Service
public class EmployeeManageService {
	@Autowired
	EmployeeManageDao manageDao;
	@Autowired
	ITDepartment itDepartment;
	@Autowired
	AccountsDepartment accountsDepartment;
	@Autowired
	ClientServicingDepartment clientServicingDepartment;
	@Autowired
	DesignDepartment designDepartment;
	@Autowired
	MarketingDepartment marketingDepartment;
	@Autowired
	HRDepartment hrDepartment;
	@Autowired
	ProductionDepartment productionDepartment;

	public String signup(EmployeeManage employeeManage, ModelMap map) {
		List<EmployeeManage> oldemp = manageDao.findByEmailOrPhone(employeeManage.getEmail(),
				employeeManage.getPhone());
		if (!oldemp.isEmpty()) {
			map.put("fail", "Account Already Exixst");
			return "Signup";
		} else {
			manageDao.saveallemp(employeeManage);
			return "AdminHome";
		}
	}

	public String login(String emph, String password, ModelMap map, HttpSession session) {
		if (emph.equals("admin") && password.equals("admin")) {
			session.setAttribute("admin", "admin");
			map.put("pass", "Admin Login Success");
			return "AdminHome";
		} else {
			long mobile = 0;
			String email = null;
			try {
				mobile = Long.parseLong(emph);
			} catch (NumberFormatException e) {
				email = emph;
			}
			List<EmployeeManage> exEmp = manageDao.findByEmailOrPhone(email, mobile);
			if (exEmp.isEmpty()) {
				map.put("fail", "Invalid Email or Mobile");
				return "login.html";
			} else {
				EmployeeManage employeeManage = exEmp.get(0);
				if (employeeManage.getPassword().equals(password)) {
					session.setAttribute("employee", employeeManage);
					map.put("pass", "Login Success");
					if (employeeManage.getDeptarment().equals("IT")) {
						int id = employeeManage.getId();
						Optional<ITDepartment> itList = manageDao.findByIT(id);
						if (itList.isEmpty()) {
							map.put("department", employeeManage.getDeptarment());
							map.put("Id", id);
							return "Profile.html";
						} else {
							ITDepartment it = itList.get();
							map.put("list", it);
							map.put("Id", id);
							return "ITdepartment.html";
						}
					} else if (employeeManage.getDeptarment().equals("HR")) {
						int id = employeeManage.getId();
						Optional<HRDepartment> itList = manageDao.findByHR(id);
						if (itList.isEmpty()) {
							map.put("department", employeeManage.getDeptarment());
							map.put("Id", id);
							return "Profile.html";
						} else {
							HRDepartment it = itList.get();
							map.put("list", it);
							map.put("Id", id);
							return "HRdepartment.html";
						}
					} else if (employeeManage.getDeptarment().equals("Accounts")) {
						int id = employeeManage.getId();
						Optional<AccountsDepartment> itList = manageDao.findByAccounts(id);
						if (itList.isEmpty()) {
							map.put("department", employeeManage.getDeptarment());
							map.put("Id", id);
							return "Profile.html";
						} else {
							AccountsDepartment it = itList.get();
							map.put("list", it);
							map.put("Id", id);
							return "Accountsdepartment.html";
						}
					} else if (employeeManage.getDeptarment().equals("Design")) {
						int id = employeeManage.getId();
						Optional<DesignDepartment> itList = manageDao.findByDesign(id);
						if (itList.isEmpty()) {
							map.put("department", employeeManage.getDeptarment());
							map.put("Id", id);
							return "Profile.html";
						} else {
							DesignDepartment it = itList.get();
							map.put("list", it);
							map.put("Id", id);
							return "Designdepartment.html";
						}
					} else if (employeeManage.getDeptarment().equals("Marketing")) {
						int id = employeeManage.getId();
						Optional<MarketingDepartment> itList = manageDao.findByMarketing(id);
						if (itList.isEmpty()) {
							map.put("department", employeeManage.getDeptarment());
							map.put("Id", id);
							return "Profile.html";
						} else {
							MarketingDepartment it = itList.get();
							map.put("list", it);
							map.put("Id", id);
							return "Marketingdepartment.html";
						}
					} else if (employeeManage.getDeptarment().equals("Production")) {
						int id = employeeManage.getId();
						Optional<ProductionDepartment> itList = manageDao.findByProduction(id);
						if (itList.isEmpty()) {
							map.put("department", employeeManage.getDeptarment());
							map.put("Id", id);
							return "Profile.html";
						} else {
							ProductionDepartment it = itList.get();
							map.put("list", it);
							map.put("Id", id);
							return "Productiondepartment.html";
						}
					} else if (employeeManage.getDeptarment().equals("ClientServicing")) {
						int id = employeeManage.getId();
						Optional<ClientServicingDepartment> itList = manageDao.findByClientServicing(id);
						if (itList.isEmpty()) {
							map.put("department", employeeManage.getDeptarment());
							map.put("Id", id);
							return "Profile.html";
						} else {
							ClientServicingDepartment it = itList.get();
							map.put("list", it);
							map.put("Id", id);
							return "ClientServicingdepartment.html";
						}
					} else {
						return "login.html";
					}
				} else {
					map.put("fail", "Invalid password");
					return "login.html";
				}
			}
		}
	}

	public String profile(int Id, String username, String email, long phone, String address, String department,
			ModelMap map, HttpSession session) {
		if (department.equals("IT")) {
			itDepartment.setId(Id);
			itDepartment.setAddres(address);
			itDepartment.setEmail(email);
			itDepartment.setMobile(phone);
			itDepartment.setUsername(username);
			manageDao.saveprofileIT(itDepartment);
			Optional<ITDepartment> itList = manageDao.findByIT(Id);
			ITDepartment it = itList.get();
			map.put("list", it);
			map.put("Id", Id);
			return "ITdepartment.html";
		} else if (department.equals("Production")) {
			productionDepartment.setId(Id);
			productionDepartment.setAddres(address);
			productionDepartment.setEmail(email);
			productionDepartment.setMobile(phone);
			productionDepartment.setUsername(username);
			manageDao.saveProduction(productionDepartment);
			Optional<ProductionDepartment> itList = manageDao.findByProduction(Id);
			ProductionDepartment it = itList.get();
			map.put("list", it);
			map.put("Id", Id);
			return "Productiondepartment.html";
		} else if (department.equals("Design")) {
			designDepartment.setId(Id);
			designDepartment.setAddres(address);
			designDepartment.setEmail(email);
			designDepartment.setMobile(phone);
			designDepartment.setUsername(username);
			manageDao.saveDesign(designDepartment);
			Optional<DesignDepartment> itList = manageDao.findByDesign(Id);
			DesignDepartment it = itList.get();
			map.put("list", it);
			map.put("Id", Id);
			return "Designdepartment.html";
		} else if (department.equals("HR")) {
			hrDepartment.setId(Id);
			hrDepartment.setAddres(address);
			hrDepartment.setEmail(email);
			hrDepartment.setMobile(phone);
			hrDepartment.setUsername(username);
			manageDao.saveHR(hrDepartment);
			Optional<HRDepartment> itList = manageDao.findByHR(Id);
			HRDepartment it = itList.get();
			map.put("list", it);
			map.put("Id", Id);
			return "HRdepartment.html";
		} else if (department.equals("ClientServicing")) {
			clientServicingDepartment.setId(Id);
			clientServicingDepartment.setAddres(address);
			clientServicingDepartment.setEmail(email);
			clientServicingDepartment.setMobile(phone);
			clientServicingDepartment.setUsername(username);
			manageDao.saveClientServicing(clientServicingDepartment);
			Optional<ClientServicingDepartment> itList = manageDao.findByClientServicing(Id);
			ClientServicingDepartment it = itList.get();
			map.put("list", it);
			map.put("Id", Id);
			return "ClientServicingdepartment.html";
		} else if (department.equals("Marketing")) {
			marketingDepartment.setId(Id);
			marketingDepartment.setAddres(address);
			marketingDepartment.setEmail(email);
			marketingDepartment.setMobile(phone);
			marketingDepartment.setUsername(username);
			manageDao.saveMarketing(marketingDepartment);
			Optional<MarketingDepartment> itList = manageDao.findByMarketing(Id);
			MarketingDepartment it = itList.get();
			map.put("list", it);
			map.put("Id", Id);
			return "Marketingdepartment.html";
		} else if (department.equals("Accounts")) {
			accountsDepartment.setId(Id);
			accountsDepartment.setAddres(address);
			accountsDepartment.setEmail(email);
			accountsDepartment.setMobile(phone);
			accountsDepartment.setUsername(username);
			manageDao.saveAccounts(accountsDepartment);
			Optional<AccountsDepartment> itList = manageDao.findByAccounts(Id);
			AccountsDepartment it = itList.get();
			map.put("list", it);
			map.put("Id", Id);
			return "Accountsdepartment.html";
		} else {
			return "Profile.html";
		}
	}

	public String reportSubmit(String department, String report, int id, ModelMap map, HttpSession httpSession) {
		// TODO Auto-generated method stub
		if (department.equals("IT")) {
			Optional<ITDepartment> itList = manageDao.findByIT(id);
			ITDepartment it = itList.get();
			it.setReport(report);
			manageDao.saveIT(it);
			map.put("Id", id);
			map.put("list", it);
			return "ITdepartment.html";
		} else if (department.equals("HR")) {
			Optional<HRDepartment> itList = manageDao.findByHR(id);
			HRDepartment it = itList.get();
			it.setReport(report);
			manageDao.saveHR(it);
			map.put("Id", id);
			map.put("list", it);
			return "HRdepartment.html";
		} else if (department.equals("Accounts")) {
			Optional<AccountsDepartment> itList = manageDao.findByAccounts(id);
			AccountsDepartment it = itList.get();
			it.setReport(report);
			manageDao.saveAccounts(it);
			map.put("Id", id);
			map.put("list", it);
			return "Accountsdepartment.html";
		} else if (department.equals("Production")) {
			Optional<ProductionDepartment> itList = manageDao.findByProduction(id);
			ProductionDepartment it = itList.get();
			it.setReport(report);
			manageDao.saveProduction(it);
			map.put("Id", id);
			map.put("list", it);
			return "Productiondepartment.html";
		} else if (department.equals("Design")) {
			Optional<DesignDepartment> itList = manageDao.findByDesign(id);
			DesignDepartment it = itList.get();
			it.setReport(report);
			manageDao.saveDesign(it);
			map.put("Id", id);
			map.put("list", it);
			return "Designdepartment.html";
		} else if (department.equals("Marketing")) {
			Optional<MarketingDepartment> itList = manageDao.findByMarketing(id);
			MarketingDepartment it = itList.get();
			it.setReport(report);
			manageDao.saveMarketing(it);
			map.put("Id", id);
			map.put("list", it);
			return "Marketingdepartment.html";
		} else if (department.equals("ClientServicing")) {
			Optional<ClientServicingDepartment> itList = manageDao.findByClientServicing(id);
			ClientServicingDepartment it = itList.get();
			it.setReport(report);
			manageDao.saveClientServicing(it);
			map.put("Id", id);
			map.put("list", it);
			return "ClientServicingdepartment.html";
		} else {
			return "Report.html";
		}

	}

	public String empHome(String department, int id, HttpSession httpSession, ModelMap map) {
		if (department.equals("IT")) {
			Optional<ITDepartment> itList = manageDao.findByIT(id);
			ITDepartment it = itList.get();
			map.put("Id", id);
			map.put("list", it);
			return "ITdepartment.html";
		} else if (department.equals("HR")) {
			Optional<HRDepartment> itList = manageDao.findByHR(id);
			HRDepartment it = itList.get();
						map.put("Id", id);
			map.put("list", it);
			return "HRdepartment.html";
		} else if (department.equals("Accounts")) {
			Optional<AccountsDepartment> itList = manageDao.findByAccounts(id);
			AccountsDepartment it = itList.get();
			map.put("Id", id);
			map.put("list", it);
			return "Accountsdepartment.html";
		} else if (department.equals("Production")) {
			Optional<ProductionDepartment> itList = manageDao.findByProduction(id);
			ProductionDepartment it = itList.get();
			map.put("Id", id);
			map.put("list", it);
			return "Productiondepartment.html";
		} else if (department.equals("Design")) {
			Optional<DesignDepartment> itList = manageDao.findByDesign(id);
			DesignDepartment it = itList.get();
			map.put("Id", id);
			map.put("list", it);
			return "Designdepartment.html";
		} else if (department.equals("Marketing")) {
			Optional<MarketingDepartment> itList = manageDao.findByMarketing(id);
			MarketingDepartment it = itList.get();
			map.put("Id", id);
			map.put("list", it);
			return "Marketingdepartment.html";
		} else if (department.equals("ClientServicing")) {
			Optional<ClientServicingDepartment> itList = manageDao.findByClientServicing(id);
			ClientServicingDepartment it = itList.get();
			map.put("Id", id);
			map.put("list", it);
			return "ClientServicingdepartment.html";
		} else {
			return "homepage.html";
		}
	}
}
