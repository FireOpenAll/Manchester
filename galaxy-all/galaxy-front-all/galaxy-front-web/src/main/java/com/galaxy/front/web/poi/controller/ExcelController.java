package com.galaxy.front.web.poi.controller;



import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*author:huangshanqi
 *time  :2014年9月21日 下午1:22:20
 *email :hsqmobile@gmail.com
 */
@Controller
@RequestMapping(value = "/api/v1")
public class ExcelController {
	
	/*
	 * 注意区分contentType ，2003跟2007有较大不同
	 */

	@RequestMapping(value = "/excel",method = RequestMethod.GET)
	public void getExcel(HttpServletRequest request,HttpServletResponse response){
		
		
		
		List<String> headers = new ArrayList<String>();
		headers.add("姓名");
		headers.add("性别");
		headers.add("年龄");
		headers.add("班级");
		headers.add("成绩");
		
		List<Student> studentsList = new ArrayList<ExcelController.Student>();
		
		for (int i = 0; i < 10; i++) {
			studentsList.add(new Student("姓名"+i, (i%2 == 0)?"男":"女", 20+i, i+"班", 90+i));
		}
		
		/*
		 excel 2003
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		for (int i = 0; i < 3; i++) {
			HSSFSheet hssfSheet = hssfWorkbook.createSheet("sheet"+i);
			HSSFRow headRow = hssfSheet.createRow(0);
			
			for(int j= 0;j<headers.size();j++){
				HSSFCell hssfCell = headRow.createCell(j);
				hssfCell.setCellValue(headers.get(j));
			}
			
			for (int k = 1; k < studentsList.size()+1; k++) {
				HSSFRow hssfRow = hssfSheet.createRow(k);
				
					HSSFCell hssfCellName = hssfRow.createCell(0);
					hssfCellName.setCellValue(i+studentsList.get(k-1).getName());
					
					HSSFCell hssfCellGender = hssfRow.createCell(1);
					hssfCellGender.setCellValue(studentsList.get(k-1).getGender());
					
					HSSFCell hssfCellAge = hssfRow.createCell(2);
					hssfCellAge.setCellValue(studentsList.get(k-1).getAge());
					
					HSSFCell hssfCellClass = hssfRow.createCell(3);
					hssfCellClass.setCellValue(studentsList.get(k-1).getClassNumber());
					
					HSSFCell hssfCellScore = hssfRow.createCell(4);
					hssfCellScore.setCellValue(studentsList.get(k-1).getScore());
			}
		}
		
		ServletOutputStream servletOutputStream = null;
		try {
			servletOutputStream = response.getOutputStream();
			String filename = "成绩表";
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			
            hssfWorkbook.write(buffer);
            
            response.setContentType("application/vnd.ms-excel");
            response.setContentLength(buffer.size());
            response.setHeader("Content-Disposition", "attachment; filename=成绩表表"+filename);
            response.setHeader("Pragma", "public");
            response.setHeader("Cache-Control", "max-age=0");
            servletOutputStream.write(buffer.toByteArray());
            buffer.flush();
            servletOutputStream.flush();
            
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (servletOutputStream != null) {
				try {
					servletOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}		
		 */
		

		//excel 2007
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
		for (int i = 0; i < 3; i++) {
			XSSFSheet xssfSheet = xssfWorkbook.createSheet("sheet"+i);
			XSSFRow headRow = xssfSheet.createRow(0);
			
			for(int j= 0;j<headers.size();j++){
				XSSFCell xssfCell = headRow.createCell(j);
				xssfCell.setCellValue(headers.get(j));
			}
			
			for (int k = 1; k < studentsList.size()+1; k++) {
				XSSFRow xssfRow = xssfSheet.createRow(k);
				
					XSSFCell xssfCellName = xssfRow.createCell(0);
					xssfCellName.setCellValue(i+studentsList.get(k-1).getName());
					
					XSSFCell xssfCellGender = xssfRow.createCell(1);
					xssfCellGender.setCellValue(studentsList.get(k-1).getGender());
					
					XSSFCell xssfCellAge = xssfRow.createCell(2);
					xssfCellAge.setCellValue(studentsList.get(k-1).getAge());
					
					XSSFCell xssfCellClass = xssfRow.createCell(3);
					xssfCellClass.setCellValue(studentsList.get(k-1).getClassNumber());
					
					XSSFCell xssfCellScore = xssfRow.createCell(4);
					xssfCellScore.setCellValue(studentsList.get(k-1).getScore());
			}
		}
		
		ServletOutputStream servletOutputStream = null;
		try {
			servletOutputStream = response.getOutputStream();
			String filename = "成绩表";
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			
            xssfWorkbook.write(buffer);
            
            //response.setContentType("application/vnd.ms-excel");
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setContentLength(buffer.size());
            response.setHeader("Content-Disposition", "attachment; filename=成绩表表"+filename);
            response.setHeader("Pragma", "public");
            response.setHeader("Cache-Control", "max-age=0");
            servletOutputStream.write(buffer.toByteArray());
            buffer.flush();
            servletOutputStream.flush();
            
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (servletOutputStream != null) {
				try {
					servletOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}		
		
	}
	

	
	
	public static class Student{
		
		private String name;
		private String gender;
		private int age;
		private String classNumber;
		private double score;
		public Student() {
			super();
		}
		public Student(String name, String gender, int age, String classNumber, double score) {
			super();
			this.name = name;
			this.gender = gender;
			this.age = age;
			this.classNumber = classNumber;
			this.score = score;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getClassNumber() {
			return classNumber;
		}
		public void setClassNumber(String classNumber) {
			this.classNumber = classNumber;
		}
		public double getScore() {
			return score;
		}
		public void setScore(double score) {
			this.score = score;
		}	
	}
	
	
}
