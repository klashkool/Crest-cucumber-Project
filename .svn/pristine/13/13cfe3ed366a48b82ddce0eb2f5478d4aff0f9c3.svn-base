package com.Procurement_Modules;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.Utils.Base;
import com.Utils.WebdriverWait;

public class Procurement_Quotes extends Base {

	public static Logger log = Logger.getLogger(Procurement_Quotes.class);

	public static void PO_Quotes(List<HashMap<String, String>> data) {

		List<WebElement> itemDetails = WebdriverWait.findElements("xpath",
				"//*[@id='content-main-section']/form/div[2]/div[2]/table/tbody/tr");
		System.out.println(itemDetails.size());

		int b = 0;
		for (int a = 2; a <= itemDetails.size(); a++) {

			WebElement unitprice = WebdriverWait.findElement("id", "unitPrice_o_0");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", unitprice);

			WebdriverWait.findElement("id", "unitPrice_o_" + b).sendKeys(data.get(b).get("Purchase Price"));

			// Adding 10days extra from Current Date(ToDate)
			// Estimated Delivery date
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(Calendar.DATE, 10);
			String newDate = dateFormat1.format(cal.getTime());
			WebdriverWait.findElement("name", "givenDate_o_" + b + "_i18n").sendKeys(newDate);
			b++;
		}

		WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/form/div[4]/input").click();

		Procurement_Quotes_UpdateQuoteStatus.UpdateQuoteStatus();

	}



}
