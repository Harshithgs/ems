package com.Planotech.Employeemangmentsystem.helper;

import java.io.InputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.Planotech.Employeemangmentsystem.dto.Attendance;

@Component
public class ExcelHelper {
	public boolean checkExcelFormat(MultipartFile file) {
		String filetype = file.getContentType();
		if (filetype.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		} else {
			return false;
		}
	}

	public List<Attendance> convertExcelToList(InputStream is) {
		List<Attendance> list=new ArrayList<>();
		try {
			
			XSSFWorkbook workbook=new XSSFWorkbook(is);
			XSSFSheet sheet=workbook.getSheet("data");
			
			int rowNumber=0;
			Iterator<Row> iterator=sheet.iterator();
			while(iterator.hasNext()) {
				Row row=iterator.next();
				if(rowNumber==0) {
					rowNumber++;
					continue;
				}
				Iterator<Cell> cells=row.iterator();
				int cid=0;
				Attendance p=new Attendance();
				while(cells.hasNext()) {
					Cell cell=cells.next();
					switch (cid) {
					case 0:
//						System.out.println("1");
//						System.out.println(cell.getStringCellValue());
						p.setEmpId(cell.getStringCellValue().trim());
						break;
					case 1:
//						System.out.println("2");
//						System.out.println(cell.getStringCellValue());
						p.setName(cell.getStringCellValue().trim());
						break;
					case 2:
//						System.out.println("3");
//						System.out.println(cell.getStringCellValue());
//						LocalDate date=cell.getDateCellValue();
//						System.out.println(date);
//						System.out.println(date.getDate()+"/"+date.getDay()+"/"+date.getYear()+"/"+date.getMonth());
//						p.setDate(date.getDate()+"/"+date.getMonth()+"/"+date.getYear());
//						p.setDate(cell.getStringCellValue());
						Date date = cell.getDateCellValue();

						// Convert the Date to LocalDate
						LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

						// Get the year, month, and day
						int year = localDate.getYear();
						int month = localDate.getMonthValue();
						int day = localDate.getDayOfMonth();

						p.setDate(day+"/"+month+"/"+year);
						break;
					case 3:
//						System.out.println("4");
						Date time=cell.getDateCellValue();
//						System.out.println(time);
						p.setTime(time.getHours()+":"+time.getMinutes()+":"+time.getSeconds());
					    break;
					default:
						break;
					}
					cid++;
				}
				list.add(p);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
