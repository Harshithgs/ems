package com.Planotech.Employeemangmentsystem.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.Planotech.Employeemangmentsystem.dao.AdminDao;
import com.Planotech.Employeemangmentsystem.dao.EmployeeManageDao;
import com.Planotech.Employeemangmentsystem.dto.AccountsDepartment;
import com.Planotech.Employeemangmentsystem.dto.Attendance;
import com.Planotech.Employeemangmentsystem.dto.ClientServicingDepartment;
import com.Planotech.Employeemangmentsystem.dto.DesignDepartment;
import com.Planotech.Employeemangmentsystem.dto.HRDepartment;
import com.Planotech.Employeemangmentsystem.dto.ITDepartment;
import com.Planotech.Employeemangmentsystem.dto.MarketingDepartment;
import com.Planotech.Employeemangmentsystem.dto.ProductionDepartment;

import jakarta.servlet.http.HttpSession;

@Component
public class AdminService {
	@Autowired
	EmployeeManageDao employeeManageDao;
	@Autowired
	AdminDao adminDao;
	@Autowired
	HelperService helperService;

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

	public String Attandace(int id, String department, ModelMap map, HttpSession httpSession) {
		String Id = "";
		if (Integer.toString(id).length() == 3) {
			Id = "000000" + id;
		} else if (Integer.toString(id).length() == 2) {
			Id = "0000000" + id;
		} else {
			Id = "00000000" + id;
		}
		if (department.equals("IT")) {
			ITDepartment it = adminDao.findITReport(id).get();
			map.put("department", department);
			map.put("attendance", it);
			List<Attendance> list = helperService.getAllAttendanceById(Id);
			map.put("lists", list);
			return "Attendance.html";
		} else if (department.equals("HR")) {
			HRDepartment hr = adminDao.findHRReport(id).get();
			map.put("department", department);
			map.put("attendance", hr);
			List<Attendance> list = helperService.getAllAttendanceById(Id);
			map.put("lists", list);
			return "Attendance.html";
		} else if (department.equals("Accounts")) {
			AccountsDepartment acc = adminDao.findAccountsReport(id).get();
			map.put("department", department);
			map.put("attendance", acc);
			List<Attendance> list = helperService.getAllAttendanceById(Id);
			map.put("lists", list);
			return "Attendance.html";
		} else if (department.equals("Production")) {
			ProductionDepartment pro = adminDao.findProductionReport(id).get();
			map.put("department", department);
			map.put("attendance", pro);
			List<Attendance> list = helperService.getAllAttendanceById(Id);
			map.put("lists", list);
			return "Attendance.html";
		} else if (department.equals("Design")) {
			DesignDepartment des = adminDao.findDesignReport(id).get();
			map.put("department", department);
			map.put("attendance", des);
			List<Attendance> list = helperService.getAllAttendanceById(Id);
			map.put("lists", list);
			return "Attendance.html";
		} else if (department.equals("ClientServicing")) {
			ClientServicingDepartment cs = adminDao.findClientServicingReport(id).get();
			map.put("department", department);
			map.put("attendance", cs);
			List<Attendance> list = helperService.getAllAttendanceById(Id);
			map.put("lists", list);
			return "Attendance.html";
		} else if (department.equals("Marketing")) {
			MarketingDepartment mr = adminDao.findMarketingReport(id).get();
			map.put("department", department);
			map.put("attendance", mr);
			List<Attendance> list = helperService.getAllAttendanceById(Id);
			map.put("lists", list);
			return "Attendance.html";
		} else {
			return "AdminHome.html";
		}
	}

//	public void updateInAndOut(String department) {
//		LocalDate currentDate = LocalDate.now();
//		String useDate = "" + currentDate.getDayOfMonth() + "/" + currentDate.getMonthValue() + "/"
//				+ currentDate.getYear();
//		useDate = "3/2/2024";
//		List<Attendance> list = adminDao.findAllAttendance();
//		Set<String> uniqueEmpIds = new HashSet<>();
//		int num = 0;
//		for (Attendance i : list) {
//			String empId = i.getEmpId();
//			if (!uniqueEmpIds.contains(empId)) {
//				List<Attendance> emp = helperService.getAllAttendanceById(empId);
//				num++;
//				for (Attendance e : emp) {
//					if (e.getEmpdate().equals(useDate)) {
//						List<Attendance> emplist = adminDao.findByEmpDate(e.getEmpdate());
//						int count = 1;
//						for (Attendance ed : emplist) {
//							int ID = Integer.parseInt(i.getEmpId());
//							if (department.equals("IT")) {
//								if (!(employeeManageDao.findByIT(ID).isEmpty())) {
//									ITDepartment emps = employeeManageDao.findByIT(ID).get();
//									if (count == 1) {
//										emps.setIntime(ed.getEmptime());
//										employeeManageDao.saveIT(emps);
//										count++;
//									} else if (count == 2) {
//										emps.setOuttime(ed.getEmptime());
//										employeeManageDao.saveIT(emps);
//										count = 1;
//									}
//								}
//							} else if (department.equals("Accounts")) {
//								if (!(employeeManageDao.findByAccounts(ID).isEmpty())) {
//									AccountsDepartment emps = employeeManageDao.findByAccounts(ID).get();
//									if (count == 1) {
//										emps.setIntime(ed.getEmptime());
//										employeeManageDao.saveAccounts(emps);
//										count++;
//									} else if (count == 2) {
//										emps.setOuttime(ed.getEmptime());
//										employeeManageDao.saveAccounts(emps);
//										count = 1;
//									}
//								}
//							} else if (department.equals("Marketing")) {
//								if (!(employeeManageDao.findByMarketing(ID).isEmpty())) {
//									MarketingDepartment emps = employeeManageDao.findByMarketing(ID).get();
//									if (count == 1) {
//										emps.setIntime(ed.getEmptime());
//										employeeManageDao.saveMarketing(emps);
//										count++;
//									} else if (count == 2) {
//										emps.setOuttime(ed.getEmptime());
//										employeeManageDao.saveMarketing(emps);
//										count = 1;
//									}
//								}
//							} else if (department.equals("ClientServicing")) {
//								if (!(employeeManageDao.findByClientServicing(ID).isEmpty())) {
//									ClientServicingDepartment emps = employeeManageDao.findByClientServicing(ID).get();
//									if (count == 1) {
//										emps.setIntime(ed.getEmptime());
//										employeeManageDao.saveClientServicing(emps);
//										count++;
//									} else if (count == 2) {
//										emps.setOuttime(ed.getEmptime());
//										employeeManageDao.saveClientServicing(emps);
//										count = 1;
//									}
//								}
//							} else if (department.equals("Producton")) {
//								if (!(employeeManageDao.findByProduction(ID).isEmpty())) {
//									ProductionDepartment emps = employeeManageDao.findByProduction(ID).get();
//									if (count == 1) {
//										emps.setIntime(ed.getEmptime());
//										employeeManageDao.saveProduction(emps);
//										count++;
//									} else if (count == 2) {
//										emps.setOuttime(ed.getEmptime());
//										employeeManageDao.saveProduction(emps);
//										count = 1;
//									}
//								}
//							} else if (department.equals("HR")) {
//								if (!(employeeManageDao.findByHR(ID).isEmpty())) {
//									HRDepartment emps = employeeManageDao.findByHR(ID).get();
//									if (count == 1) {
//										emps.setIntime(ed.getEmptime());
//										employeeManageDao.saveHR(emps);
//										count++;
//									} else if (count == 2) {
//										emps.setOuttime(ed.getEmptime());
//										employeeManageDao.saveHR(emps);
//										count = 1;
//									}
//								}
//							} else {
//								if (!(employeeManageDao.findByDesign(ID).isEmpty())) {
//									DesignDepartment emps = employeeManageDao.findByDesign(ID).get();
//									if (count == 1) {
//										emps.setIntime(ed.getEmptime());
//										employeeManageDao.saveDesign(emps);
//										count++;
//									} else if (count == 2) {
//										emps.setOuttime(ed.getEmptime());
//										employeeManageDao.saveDesign(emps);
//										count = 1;
//									}
//								}
//							}
//						}
//					}
//				}
//
//				uniqueEmpIds.add(empId);
//			}
//		}
//	}
	public String loadsalary(int id, String department, ModelMap map, HttpSession httpSession) {
		System.out.println(id + " " + department);
		if (department.equals("IT")) {
			ITDepartment it = adminDao.findITReport(id).get();
			System.out.println(it);
			map.put("department", department);
			map.put("report", it);
			return "salary.html";
		} else if (department.equals("HR")) {
			HRDepartment hr = adminDao.findHRReport(id).get();
			map.put("department", department);
			map.put("report", hr);
			return "salary.html";
		} else if (department.equals("Accounts")) {
			AccountsDepartment acc = adminDao.findAccountsReport(id).get();
			map.put("department", department);
			map.put("report", acc);
			return "salary.html";
		} else if (department.equals("Production")) {
			ProductionDepartment pro = adminDao.findProductionReport(id).get();
			map.put("department", department);
			map.put("report", pro);
			return "salary.html";
		} else if (department.equals("Design")) {
			DesignDepartment des = adminDao.findDesignReport(id).get();
			map.put("department", department);
			map.put("report", des);
			return "salary.html";
		} else if (department.equals("ClientServicing")) {
			ClientServicingDepartment cs = adminDao.findClientServicingReport(id).get();
			map.put("department", department);
			map.put("report", cs);
			return "salary.html";
		} else if (department.equals("Marketing")) {
			MarketingDepartment mr = adminDao.findMarketingReport(id).get();
			map.put("department", department);
			map.put("report", mr);
			return "salary.html";
		} else {
			return "salary.html";
		}
	}

	public String salary(String department, double salary, int id, ModelMap map, HttpSession httpSession) {
		if (department.equals("IT")) {
			ITDepartment it = adminDao.findITReport(id).get();
			it.setSalary(salary);
			employeeManageDao.saveIT(it);
			List<ITDepartment> list = adminDao.fetchAllItTable();
			map.put("lists", list);
			return "ItTable.html";
		} else if (department.equals("HR")) {
			HRDepartment hr = adminDao.findHRReport(id).get();
			hr.setSalary(salary);
			employeeManageDao.saveHR(hr);
			List<HRDepartment> list = adminDao.fecthAllHRtable();
			map.put("lists", list);
			return "HRTable.html";
		} else if (department.equals("Accounts")) {
			AccountsDepartment acc = adminDao.findAccountsReport(id).get();
			acc.setSalary(salary);
			employeeManageDao.saveAccounts(acc);
			List<AccountsDepartment> list = adminDao.fecthAllAccountsTable();
			map.put("lists", list);
			return "AccountsTable.html";
		} else if (department.equals("Production")) {
			ProductionDepartment pro = adminDao.findProductionReport(id).get();
			pro.setSalary(salary);
			employeeManageDao.saveProduction(pro);
			List<ProductionDepartment> list = adminDao.fecthAllProductionTable();
			map.put("lists", list);
			return "ProductionTable.html";
		} else if (department.equals("Design")) {
			DesignDepartment des = adminDao.findDesignReport(id).get();
			des.setSalary(salary);
			employeeManageDao.saveDesign(des);
			List<DesignDepartment> list = adminDao.fecthAllDesignTable();
			map.put("lists", list);
			return "DesignTable.html";
		} else if (department.equals("ClientServicing")) {
			ClientServicingDepartment cs = adminDao.findClientServicingReport(id).get();
			cs.setSalary(salary);
			employeeManageDao.saveClientServicing(cs);
			List<ClientServicingDepartment> list = adminDao.fecthAllClientServicingTable();
			map.put("lists", list);
			return "ClientServicingTable.html";
		} else if (department.equals("Marketing")) {
			MarketingDepartment mr = adminDao.findMarketingReport(id).get();
			mr.setSalary(salary);
			employeeManageDao.saveMarketing(mr);
			System.out.println(salary);
			List<MarketingDepartment> list = adminDao.fecthAllMarketingTable();
			map.put("lists", list);
			return "MarketingTable.html";
		} else {
			return "AdminHome.html";
		}
	}

	public void updateInAndOut(final String useDate) {
		String noon = "12:0:0";
		String h = noon.substring(0, noon.indexOf(':'));
		int afternoon = Integer.parseInt(h);
		List<Integer> Ids = employeeManageDao.findAllId();
		if (!(adminDao.findByEmpDate(useDate).isEmpty())) {
			for (int i : Ids) {
				String Id = "";
				if (Integer.toString(i).length() == 3) {
					Id = "000000" + i;
				} else if (Integer.toString(i).length() == 2) {
					Id = "0000000" + i;
				} else {
					Id = "00000000" + i;
				}

				if (!(employeeManageDao.findByIT(i).isEmpty())) {
					List<Attendance> emp = helperService.getAllAttendanceById(Id);

					List<Attendance> filteredList = emp.stream()
							.filter(attendance -> attendance.getEmpdate().equals(useDate)).collect(Collectors.toList());

					for (Attendance a : filteredList) {
						int H = Integer.parseInt(a.getEmptime().substring(0, a.getEmptime().indexOf(':')));
						ITDepartment it = adminDao.findITReport(i).get();
						if (afternoon > H) {
							it.setIntime(a.getEmptime());
							employeeManageDao.saveIT(it);
						} else {
							it.setOuttime(a.getEmptime());
							employeeManageDao.saveIT(it);
						}
					}

				} else if (!(employeeManageDao.findByAccounts(i).isEmpty())) {
					List<Attendance> emp = helperService.getAllAttendanceById(Id);
					List<Attendance> filteredList = emp.stream()
							.filter(attendance -> attendance.getEmpdate().equals(useDate)).collect(Collectors.toList());
					for (Attendance a : filteredList) {
						int H = Integer.parseInt(a.getEmptime().substring(0, a.getEmptime().indexOf(':')));
						AccountsDepartment it = adminDao.findAccountsReport(i).get();
						if (afternoon > H) {
							it.setIntime(a.getEmptime());
							employeeManageDao.saveAccounts(it);
						} else {
							it.setOuttime(a.getEmptime());
							employeeManageDao.saveAccounts(it);
						}
					}
				} else if (!(employeeManageDao.findByClientServicing(i).isEmpty())) {
					List<Attendance> emp = helperService.getAllAttendanceById(Id);
					List<Attendance> filteredList = emp.stream()
							.filter(attendance -> attendance.getEmpdate().equals(useDate)).collect(Collectors.toList());
					for (Attendance a : filteredList) {
						int H = Integer.parseInt(a.getEmptime().substring(0, a.getEmptime().indexOf(':')));
						ClientServicingDepartment it = adminDao.findClientServicingReport(i).get();
						if (afternoon > H) {
							it.setIntime(a.getEmptime());
							employeeManageDao.saveClientServicing(it);
						} else {
							it.setOuttime(a.getEmptime());
							employeeManageDao.saveClientServicing(it);
						}
					}
				} else if (!(employeeManageDao.findByHR(i).isEmpty())) {
					List<Attendance> emp = helperService.getAllAttendanceById(Id);
					List<Attendance> filteredList = emp.stream()
							.filter(attendance -> attendance.getEmpdate().equals(useDate)).collect(Collectors.toList());
					for (Attendance a : filteredList) {
						int H = Integer.parseInt(a.getEmptime().substring(0, a.getEmptime().indexOf(':')));
						HRDepartment it = adminDao.findHRReport(i).get();
						if (afternoon > H) {
							it.setIntime(a.getEmptime());
							employeeManageDao.saveHR(it);
						} else {
							it.setOuttime(a.getEmptime());
							employeeManageDao.saveHR(it);
						}
					}
				} else if (!(employeeManageDao.findByDesign(i).isEmpty())) {
					List<Attendance> emp = helperService.getAllAttendanceById(Id);
					List<Attendance> filteredList = emp.stream()
							.filter(attendance -> attendance.getEmpdate().equals(useDate)).collect(Collectors.toList());
					for (Attendance a : filteredList) {
						int H = Integer.parseInt(a.getEmptime().substring(0, a.getEmptime().indexOf(':')));
						DesignDepartment it = adminDao.findDesignReport(i).get();
						if (afternoon > H) {
							it.setIntime(a.getEmptime());
							employeeManageDao.saveDesign(it);
						} else {
							it.setOuttime(a.getEmptime());
							employeeManageDao.saveDesign(it);
						}
					}
				} else if (!(employeeManageDao.findByMarketing(i).isEmpty())) {
					List<Attendance> emp = helperService.getAllAttendanceById(Id);
					List<Attendance> filteredList = emp.stream()
							.filter(attendance -> attendance.getEmpdate().equals(useDate)).collect(Collectors.toList());
					for (Attendance a : filteredList) {
						int H = Integer.parseInt(a.getEmptime().substring(0, a.getEmptime().indexOf(':')));
						MarketingDepartment it = adminDao.findMarketingReport(i).get();
						if (afternoon > H) {
							it.setIntime(a.getEmptime());
							employeeManageDao.saveMarketing(it);
						} else {
							it.setOuttime(a.getEmptime());
							employeeManageDao.saveMarketing(it);
						}
					}
				} else {
					List<Attendance> emp = helperService.getAllAttendanceById(Id);
					List<Attendance> filteredList = emp.stream()
							.filter(attendance -> attendance.getEmpdate().equals(useDate)).collect(Collectors.toList());
					for (Attendance a : filteredList) {
						int H = Integer.parseInt(a.getEmptime().substring(0, a.getEmptime().indexOf(':')));
						ProductionDepartment it = adminDao.findProductionReport(i).get();
						if (afternoon > H) {
							it.setIntime(a.getEmptime());
							employeeManageDao.saveProduction(it);
						} else {
							it.setOuttime(a.getEmptime());
							employeeManageDao.saveProduction(it);
						}
					}
				}

			}
		} else {
			LocalDate currentDate = LocalDate.now();
			String newDate = "" +( currentDate.getDayOfMonth()-1 )+ "/" + currentDate.getMonthValue() + "/"
					+ currentDate.getYear();
			updateInAndOut(newDate);
		}
	}
}
