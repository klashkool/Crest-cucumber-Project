package com.AccountsPayable_Modules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.Utils.Base;
import com.Utils.WebdriverWait;

public class AP_Payments_Applications extends Base {

	public static void SelectInvoiceID(List<HashMap<String, String>> data) throws InterruptedException {

		WebdriverWait.findElement("link", "Applications").click();// Application
		// Link
		ArrayList<String> Invlist = new ArrayList<String>();

		for (int j = 14; j <= 17; j++) {
			Invlist.add(data.get(j).get("Currency"));
		}
		System.out.println(Invlist);

		List<WebElement> Inv_Pay_tble = WebdriverWait.findElements("xpath",
				"//*[@id='createPaymentApplication']/table/tbody/tr");
		String totalTabletext = null;
		int count = 0;
		for (int y = 2; y <= Inv_Pay_tble.size(); y++) {
			String before_xpath = "//*[@id='createPaymentApplication']/table/tbody/tr[";
			String after_xpath = "]/td";
			if (count >= 4) {
				break;
			}
			totalTabletext = WebdriverWait.findElement("xpath", before_xpath + y + after_xpath).getText();
			System.out.println(totalTabletext);
			if (Invlist.contains(totalTabletext)) {
				String before_xpath1 = "//*[@id='createPaymentApplication']/table/tbody/tr[";
				String after_xpath1 = "]/td[8]/input";
				WebdriverWait.findElement("xpath", before_xpath1 + y + after_xpath1).click();
				Thread.sleep(2000);
				count++;
			}
		}
		WebdriverWait.findElement("xpath", "//*[@id='createPaymentApplication']/div/input").click();
		WebdriverWait.findElement("link", "Sent").click();
	}

}
