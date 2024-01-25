package com.Planotech.Employeemangmentsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.Planotech.Employeemangmentsystem.dao.AdminDao;
import com.Planotech.Employeemangmentsystem.dao.EmployeeManageDao;
import com.Planotech.Employeemangmentsystem.dto.AccountsDepartment;
import com.Planotech.Employeemangmentsystem.dto.ClientServicingDepartment;
import com.Planotech.Employeemangmentsystem.dto.DesignDepartment;
import com.Planotech.Employeemangmentsystem.dto.HRDepartment;
import com.Planotech.Employeemangmentsystem.dto.ITDepartment;
import com.Planotech.Employeemangmentsystem.dto.MarketingDepartment;
import com.Planotech.Employeemangmentsystem.dto.ProductionDepartment;
import com.Planotech.Employeemangmentsystem.repository.ITDepartmentRepository;

import jakarta.servlet.http.HttpSession;

@Component
public class AdminService {
	@Autowired
	EmployeeManageDao employeeManageDao;
	@Autowired
	AdminDao adminDao;

	public String Department(String department, HttpSession httpSession, ModelMap map) {
		// System.out.println(department);
		if (department.equals("IT")) {
			List<ITDepartment> list = adminDao.fetchAllItTable();
			map.put("lists", list);
			return "ItTable.html";
		}

		if (department.equals("HR")) {
			List<HRDepartment> list = adminDao.fecthAllHRtable();
			map.put("lists", list);
			return "HRTable.html";
		}
		if (department.equals("Accounts")) {
			List<AccountsDepartment> list = adminDao.fecthAllAccountsTable();
			map.put("lists", list);
			return "AccountsTable.html";
		}
		if (department.equals("Marketing")) {
			List<MarketingDepartment> list = adminDao.fecthAllMarketingTable();
			map.put("lists", list);
			return "MarketingTable.html";
		}
		if (department.equals("ClientServicing")) {
			List<ClientServicingDepartment> list = adminDao.fecthAllClientServicingTable();
			map.put("lists", list);
			return "ClientServicingTable.html";
		}
		if (department.equals("Production")) {
			List<ProductionDepartment> list = adminDao.fecthAllProductionTable();
			map.put("lists", list);
			return "ProductionTable.html";
		}
		if (department.equals("Design")) {
			List<DesignDepartment> list = adminDao.fecthAllDesignTable();
			map.put("lists", list);
			return "DesignTable.html";
		} else {
			return "AdminHome.html";
		}
	}

	public String Report(int id, String department, ModelMap map, HttpSession httpSession) {
		if (department.equals("IT")) {
			ITDepartment it = adminDao.findITReport(id).get();
			map.put("department", department);
			map.put("report", it);
			return "AdminReport.html";
		} else if (department.equals("HR")) {
			HRDepartment hr = adminDao.findHRReport(id).get();
			map.put("department", department);
			map.put("report", hr);
			return "AdminReport.html";
		} else if (department.equals("Accounts")) {
			AccountsDepartment acc = adminDao.findAccountsReport(id).get();
			map.put("department", department);
			map.put("report", acc);
			return "AdminReport.html";
		} else if (department.equals("Production")) {
			ProductionDepartment pro = adminDao.findProductionReport(id).get();
			map.put("department", department);
			map.put("report", pro);
			return "AdminReport.html";
		} else if (department.equals("Design")) {
			DesignDepartment des = adminDao.findDesignReport(id).get();
			map.put("department", department);
			map.put("report", des);
			return "AdminReport.html";
		} else if (department.equals("ClientServicing")) {
			ClientServicingDepartment cs = adminDao.findClientServicingReport(id).get();
			map.put("department", department);
			map.put("report", cs);
			return "AdminReport.html";
		} else if (department.equals("Marketing")) {
			MarketingDepartment mr = adminDao.findMarketingReport(id).get();
			map.put("department", department);
			map.put("report", mr);
			return "AdminReport.html";
		} else {
			return "AdminHome.html";
		}
	}

	public String score(int id, Double dailyScore, String department, HttpSession httpSession, ModelMap map) {
		if (department.equals("IT")) {
			ITDepartment it = adminDao.findITReport(id).get();
			it.setDailyscroe(dailyScore);
			it.setTotalscroe(((it.getTotalscroe() + dailyScore) / 2));
			employeeManageDao.saveIT(it);
			List<ITDepartment> list = adminDao.fetchAllItTable();
			map.put("lists", list);
			return "ItTable.html";
		} else if (department.equals("HR")) {
			HRDepartment hr = adminDao.findHRReport(id).get();
			hr.setDailyscroe(dailyScore);
			hr.setTotalscroe(((hr.getTotalscroe() + dailyScore) / 2));
			employeeManageDao.saveHR(hr);
			List<HRDepartment> list = adminDao.fecthAllHRtable();
			map.put("lists", list);
			return "HRTable.html";
		} else if (department.equals("Accounts")) {
			AccountsDepartment acc = adminDao.findAccountsReport(id).get();
			acc.setDailyscroe(dailyScore);
			acc.setTotalscroe(((acc.getTotalscroe() + dailyScore) / 2));
			employeeManageDao.saveAccounts(acc);
			List<AccountsDepartment> list = adminDao.fecthAllAccountsTable();
			map.put("lists", list);
			return "AccountsTable.html";
		} else if (department.equals("Production")) {
			ProductionDepartment pro = adminDao.findProductionReport(id).get();
			pro.setDailyscroe(dailyScore);
			pro.setTotalscroe(((pro.getTotalscroe() + dailyScore) / 2));
			employeeManageDao.saveProduction(pro);
			List<ProductionDepartment> list = adminDao.fecthAllProductionTable();
			map.put("lists", list);
			return "ProductionTable.html";
		} else if (department.equals("Design")) {
			DesignDepartment des = adminDao.findDesignReport(id).get();
			des.setDailyscroe(dailyScore);
			des.setTotalscroe(((des.getTotalscroe() + dailyScore) / 2));
			employeeManageDao.saveDesign(des);
			List<DesignDepartment> list = adminDao.fecthAllDesignTable();
			map.put("lists", list);
			return "DesignTable.html";
		} else if (department.equals("ClientServicing")) {
			ClientServicingDepartment cs = adminDao.findClientServicingReport(id).get();
			cs.setDailyscroe(dailyScore);
			cs.setTotalscroe(((cs.getTotalscroe() + dailyScore)) / 2);
			employeeManageDao.saveClientServicing(cs);
			List<ClientServicingDepartment> list = adminDao.fecthAllClientServicingTable();
			map.put("lists", list);
			return "ClientServicingTable.html";
		} else if (department.equals("Marketing")) {
			MarketingDepartment mr = adminDao.findMarketingReport(id).get();
			mr.setDailyscroe(dailyScore);
			mr.setTotalscroe(((mr.getTotalscroe() + dailyScore) / 2));
			employeeManageDao.saveMarketing(mr);
			List<MarketingDepartment> list = adminDao.fecthAllMarketingTable();
			map.put("lists", list);
			return "MarketingTable.html";
		} else {
			return "AdminHome.html";
		}
	}

	public String EmpHomeTable(String department, HttpSession httpSession, ModelMap map) {
		if (department.equals("IT")) {
			List<ITDepartment> list = adminDao.fetchAllItTable();
			map.put("lists", list);
			return "ItTable.html";
		} else if (department.equals("HR")) {
			List<HRDepartment> list = adminDao.fecthAllHRtable();
			map.put("lists", list);
			return "HRTable.html";
		} else if (department.equals("Accounts")) {
			List<AccountsDepartment> list = adminDao.fecthAllAccountsTable();
			map.put("lists", list);
			return "AccountsTable.html";
		} else if (department.equals("Production")) {
			List<ProductionDepartment> list = adminDao.fecthAllProductionTable();
			map.put("lists", list);
			return "ProductionTable.html";
		} else if (department.equals("Design")) {
			List<DesignDepartment> list = adminDao.fecthAllDesignTable();
			map.put("lists", list);
			return "DesignTable.html";
		} else if (department.equals("ClientServicing")) {
			List<ClientServicingDepartment> list = adminDao.fecthAllClientServicingTable();
			map.put("lists", list);
			return "ClientServicingTable.html";
		} else if (department.equals("Marketing")) {
			List<MarketingDepartment> list = adminDao.fecthAllMarketingTable();
			map.put("lists", list);
			return "MarketingTable.html";
		} else {
			return "AdminHome.html";
		}
	}
}
