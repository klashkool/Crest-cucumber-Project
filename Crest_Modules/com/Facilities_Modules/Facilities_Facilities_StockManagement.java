package com.Facilities_Modules;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.Utils.Base;
import com.Utils.WebdriverWait;

public class Facilities_Facilities_StockManagement extends Base {

	public static void PO_Receive_Shpmnt() {

		List<WebElement> loc_table = WebdriverWait.findElements("xpath", "//*[@id='selectAllForm']/div[2]/table/tbody/tr");

		for (int j = 2; j <= loc_table.size() - 1; j++) {
			Select Loc_DD = new Select(WebdriverWait.findElement("id", "locationSeqId_o_" + (j - 2)));
			List<WebElement> DD = Loc_DD.getOptions();
			DD.size();
			if (DD.size() > 1) {
				Loc_DD.selectByVisibleText("500");
			} else if (DD.size() <= 1) {
				Loc_DD.selectByVisibleText("-Select-");
			}
		}
		WebdriverWait.findElement("id", "submitButton").click();
		WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/div[2]/table/tbody/tr[2]/td[1]/a").click();
	}

	public static void PO_Recv_Shpmnt_Mapping() throws InterruptedException {

		List<WebElement> map_table = WebdriverWait.findElements("xpath", "//*[@id='selectAllForm']/div[2]/table/tbody/tr");

		for (int j = 2; j <= map_table.size(); j++) {

			WebElement element = WebdriverWait.findElement("xpath", "//*[@id='selectAllForm']/div[2]/table/tbody/tr[" + j + "]/td[12]/a");
			String a = element.getAttribute("href");
			System.out.println(a);

			if (a != null) {
				System.out.println("entered if condition" + j);
				element.click();

				for (int v = 1; v <= 2; v++) {

					String radio_btn = WebdriverWait
									.findElement("xpath", "//*[@id='content-main-section']/form/div[1]/div[2]/table/tbody/tr[2]/td[4]/input[" + v + "]")
									.getAttribute("checked");
					System.out.println("-------" + radio_btn);

					if (StringUtils.isNotBlank(radio_btn) && radio_btn.equalsIgnoreCase("true")) {
						String value = WebdriverWait
										.findElement("xpath", "//*[@id='content-main-section']/form/div[1]/div[2]/table/tbody/tr[2]/td[4]/input[" + v + "]")
										.getAttribute("value");
						System.out.println(value);

						if (value.equalsIgnoreCase("S")) {

							WebdriverWait.findElement("id", "getButton").click();

							List<WebElement> Serial_table = WebdriverWait.findElements("xpath", "//*[@id='mappingContainer']/div[2]/table/tbody/tr");

							for (int k = 1; k <= Serial_table.size() - 1; k++) {

								WebdriverWait.findElement("id", "serialNumber_o_1_o_" + k).sendKeys("SerialNo" + k);

								// Expiry Date Validations
								// Adding Current Date(From Date)
								SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
								String Fromdate = (dateFormat.format(new Date()));

								// Adding 6months extra from Current
								// Date(ToDate)
								SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
								Calendar cal = Calendar.getInstance();
								cal.setTime(new Date());
								cal.add(Calendar.MONTH, 6);
								String newDate = dateFormat.format(cal.getTime());
								System.out.println("New Date" + newDate);

								String ExpDate = WebdriverWait.findElement("name", "expiryDate_o_1_o_1_i18n").getText();
								System.out.println("Exp date" + ExpDate);
								// Assert.assertEquals(newDate, ExpDate);
							}
							WebdriverWait.findElement("link", "Save").click();
						} else if (value.equalsIgnoreCase("L")) {

							WebdriverWait.findElement("xpath", "//input[starts-with(@id, 'noOfLots')]").sendKeys("5");

							WebdriverWait.findElement("id", "getButton").click();

							List<WebElement> Lot_table = WebdriverWait.findElements("xpath", "//*[@id='mappingContainer']/div[2]/table/tbody/tr");

							for (int k = 1; k <= Lot_table.size() - 1; k++) {

								WebdriverWait.findElement("id", "lotId_o_2_o_" + k).sendKeys("LotID" + k);
								WebdriverWait.findElement("id", "acceptedQty_o_2_o_" + k).sendKeys("1");

								// Expiry Date Validations
								// Adding Current Date(From Date)
								SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
								String Fromdate = (dateFormat.format(new Date()));

								// Adding 6months extra from Current
								// Date(ToDate)
								SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
								Calendar cal = Calendar.getInstance();
								cal.setTime(new Date());
								cal.add(Calendar.MONTH, 6);
								String newDate = dateFormat.format(cal.getTime());
								System.out.println(newDate);

								String ExpDate = WebdriverWait.findElement("name", "expiryDate_o_2_o_1_i18n").getText();
								// Assert.assertEquals(newDate, ExpDate);

							}
							WebdriverWait.findElement("link", "Save").click();
							break;
						}
					}
				}
			}
		}

		WebdriverWait.findElement("id", "submitButton").click();
		WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/div[2]/table/tbody/tr[2]/td[1]/a").click();
	}

}
