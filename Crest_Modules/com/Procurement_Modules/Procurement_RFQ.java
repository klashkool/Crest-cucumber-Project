package com.Procurement_Modules;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.Select;

import com.Utils.Base;
import com.Utils.WebdriverWait;

public class Procurement_RFQ extends Base {

	public static Logger log = Logger.getLogger(Procurement_RFQ.class);

	public static void PO_RFQ(List<HashMap<String, String>> data, String sheetname) throws InterruptedException {

		log.info("Creating RFQ for PO");

		Calendar sys = Calendar.getInstance();
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String todayDate = (date.format(new Date()));
		String sysTime = (sdf.format(sys.getTime()));

		WebdriverWait.findElement("xpath", "//*[@id='custRequestName']")
				.sendKeys(todayDate + sysTime);

		// Organization DD
		Select rfqOrg_dd = new Select(WebdriverWait.findElement("id", "fromPartyId"));
		rfqOrg_dd.selectByVisibleText(data.get(0).get("Organization"));

		// Adding Request Date
		// Adding Current Date(From Date)
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String Fromdate = (dateFormat.format(new Date()));
		WebdriverWait.findElement("name", "custRequestDate_i18n").clear();
		WebdriverWait.findElement("name", "custRequestDate_i18n").sendKeys(Fromdate);

		// Response Required Date
		// Adding 10days extra from Current Date(ToDate)
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, 10);
		String newDate = dateFormat1.format(cal.getTime());
		WebdriverWait.findElement("name", "responseRequiredDate_i18n").sendKeys(newDate);

		// Numbering Type DD
		Select numType_dd = new Select(WebdriverWait.findElement("id", "numberingFormatId"));
		numType_dd.selectByVisibleText("RFQ");

		// Category DD
		Select category_dd = new Select(WebdriverWait.findElement("id", "custRequestCategoryId"));
		category_dd.selectByVisibleText("From Requirement");

		WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/div/a[1]").click();// Create Button

		Procurement_RFQ_RFQItem.RFQ_Status_Val();
		Procurement_RFQ_RFQItem.RFQ_LoadItems(data);
		Procurement_RFQ_RFQHeader.RFQ_ID_Capture(sheetname);
		Procurement_RFQ_RFQHeader.Update_QuoteInfo();

	}

}
