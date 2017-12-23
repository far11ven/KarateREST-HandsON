package com.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.ui.Select;

import com.intuit.karate.cucumber.CucumberRunner;

import cucumber.api.java.en.Given;

public class DemoClass {  

	public DemoClass() {

		System.out.println("Inside constructor of DemoClass");
	}
	
	public static void main(String[] args) {
		
		createExcelFile("D:/B1.xlsx");
		writeExcelFile("D:/B1.xlsx");
		System.out.println(readExcelFile("D:/B1.xlsx"));
	}

	

	public String dc(String val) {

		System.out.println("2131231 " + val);
		return "2131231 " + val;


	}
	
	public static  void createExcelFile(String filepath) {
		try {
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Sheet1");
			XSSFRow row = sheet.createRow(0);
			row.createCell(0, CellType.STRING);
			FileOutputStream fos = new FileOutputStream(filepath);
			workbook.write(fos);
			fos.flush();
			fos.close();
			workbook.close();

		}catch(FileNotFoundException e) {
			
			System.out.println("file not found");

		}
		catch(IOException e) {
			
			System.out.println("ioexception");

		}

	}


	public static String readExcelFile(String filepath) {

		String value = null;

		try {

			FileInputStream fis = new FileInputStream(new File(filepath));
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			XSSFRow row = sheet.getRow(0);
			XSSFCell cell = row.getCell(0);
			value = cell.getStringCellValue();
			workbook.close();

			return value;

		}catch(FileNotFoundException e) {

			System.out.println("fILE NOT FOUND");

		}
		catch(IOException e) {

		}

		return value;


	}

	
	public static boolean writeExcelFile(String filepath) {

		try {

			FileInputStream fis = new FileInputStream(new File(filepath));
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			XSSFRow row = sheet.getRow(0);
			XSSFCell cell = row.getCell(0);

			cell.setCellType(CellType.STRING);
			cell.setCellValue("Kushal entered first value!");


			FileOutputStream fos = new FileOutputStream(filepath);
			workbook.write(fos);
			fos.flush();
			fos.close();
			workbook.close();
			
			return true;

		}catch(FileNotFoundException e) {

			System.out.println("fILE NOT FOUND");
			
			return false;
			
			
			
		}
		catch(IOException e) {
			
			return false;

		}


	}

}
