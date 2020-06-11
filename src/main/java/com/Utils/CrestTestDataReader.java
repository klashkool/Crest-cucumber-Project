package com.Utils;

import java.util.HashMap;
import java.util.List;

public class CrestTestDataReader {

	public static  List<HashMap<String, String>> getPOInvData() {
		return ExcelReader.readExcelDatafromFile(
				"D:\\Projects\\CrestCucumber\\src\\main\\java\\com\\Utils\\Crest_TestData.xlsx", "PO_Inv");
	}

	public static List<HashMap<String, String>> getPOInvAdhocData() {
		return ExcelReader.readExcelDatafromFile(
				"D:\\Projects\\CrestCucumber\\src\\main\\java\\com\\Utils\\Crest_TestData.xlsx", "PO_Adhoc");
	}

	public static List<HashMap<String, String>> getPOEncData() {
		return ExcelReader.readExcelDatafromFile(
				"D:\\Projects\\CrestCucumber\\src\\main\\java\\com\\Utils\\Crest_TestData.xlsx", "PO_Enc");
	}

	public static List<HashMap<String, String>> getSO_Offline_Data() {
		return ExcelReader.readExcelDatafromFile("D:\\Projects\\CrestCucumber\\src\\main\\java\\com\\Utils\\Crest_TestData.xlsx", "SO_Offline");
	}

	public static List<HashMap<String, String>> getSO_BillingAcct_Data() {
		return ExcelReader.readExcelDatafromFile(
				"D:\\Projects\\CrestCucumber\\src\\main\\java\\com\\Utils\\Crest_TestData.xlsx", "SO_BillingAcct");
	}

	public static List<HashMap<String, String>> get_ML_Data() {
		return ExcelReader.readExcelDatafromFile(
						"D:\\Projects\\CrestCucumber\\src\\main\\java\\com\\Utils\\Crest_TestData.xlsx", "ML_Data");
}
	public static List<HashMap<String, String>> get_PO_Edit_Data() {
		return ExcelReader.readExcelDatafromFile("D:\\Projects\\CrestCucumber\\src\\main\\java\\com\\Utils\\Crest_TestData.xlsx", "PO_Edit");
	}

	public static List<HashMap<String, String>> get_PO_TDS_Data() {
		return ExcelReader.readExcelDatafromFile("D:\\Projects\\CrestCucumber\\src\\main\\java\\com\\Utils\\Crest_TestData.xlsx", "PO_TDS");
}
}