package com.Financials_Modules;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Utils.Base;
import com.Utils.WebdriverWait;

public class Financials_AcctTransaction_GLTransactionViewEntry extends Base {

	public static void Acct_Trans_Val_ShipID(List<HashMap<String, String>> data, String acctName1, String acctName2) {

		int a = 14;
		for (int Shp = 1; Shp <= 4; Shp++) {
			WebdriverWait.findElement("link", "GL Transaction View/Entry").click();
			WebdriverWait.findElement("xpath", "//*[@id='toggleLink']").click();
			WebdriverWait.findElement("name", "shipmentId").sendKeys(data.get(a).get("OrderType"));
			System.out.println(data.get(a).get("OrderType"));
			WebdriverWait.findElement("xpath", "//*[@id='findAcctgTrans']/div/table/tbody[1]/tr[13]/td/input").click();

			List<WebElement> glTransTable = WebdriverWait.findElements("xpath", "//*[@id='example']/tbody/tr");
			for (int t = 1; t <= glTransTable.size(); t++) {
				String Posted_Status = driver.findElement(By.xpath("//*[@id='example']/tbody/tr[" + t + "]/td[5]")).getText();
				Assert.assertEquals("Y", Posted_Status);
				WebdriverWait.findElement("xpath", "//*[@id= 'example']/tbody/tr[" + t + "]/td[1]/a").click();

				for (int g = 1; g <= 2; g++) {
					String glAcctName = WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/div[3]/div[2]/table/tbody/tr[" + g + "]/td[2]")
									.getText();
					if (glAcctName.equalsIgnoreCase(acctName1)) {

						String flag = WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/div[3]/div[2]/table/tbody/tr[" + g + "]/td[6]")
										.getText();
						Assert.assertEquals("C", flag);

					} else if (glAcctName.equalsIgnoreCase(acctName2)) {

						String flag = WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/div[3]/div[2]/table/tbody/tr[" + g + "]/td[6]")
										.getText();
						Assert.assertEquals("D", flag);
					}
				}
				WebdriverWait.findElement("link", "Back to Search").click();
			}
			a++;
		}

	}

	public static void Acct_Trans_Val_InvoiceID(List<HashMap<String, String>> data, String acctName1, String acctName2, String acctName3, String acctName4,
					String flag1, String flag2) {

		int a = 14;
		for (int inv = 1; inv <= 4; inv++) {
			WebdriverWait.findElement("link", "GL Transaction View/Entry").click();
			WebdriverWait.findElement("xpath", "//*[@id='toggleLink']").click();
			WebdriverWait.findElement("name", "invoiceId").sendKeys(data.get(a).get("Currency"));
			WebdriverWait.findElement("xpath", "//*[@id='findAcctgTrans']/div/table/tbody[1]/tr[13]/td/input").click();

			String Posted_Status = driver.findElement(By.xpath("//*[@id='example']/tbody/tr/td[5]")).getText();
			Assert.assertEquals("Y", Posted_Status);
			WebdriverWait.findElement("xpath", "//*[@id= 'example']/tbody/tr/td[1]/a").click();

			List<WebElement> acctTransEntries = WebdriverWait.findElements("xpath", "//*[@id='content-main-section']/div[3]/div[2]/table/tbody/tr");

			for (int g = 1; g <= acctTransEntries.size(); g++) {
				String glAcctName = WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/div[3]/div[2]/table/tbody/tr[" + g + "]/td[2]")
								.getText();

				if (glAcctName.equalsIgnoreCase(acctName1)) {

					String flag = WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/div[3]/div[2]/table/tbody/tr[" + g + "]/td[6]").getText();
					Assert.assertEquals(flag1, flag);

				} else if (glAcctName.equalsIgnoreCase(acctName2)) {

					String flag = WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/div[3]/div[2]/table/tbody/tr[" + g + "]/td[6]").getText();
					Assert.assertEquals(flag1, flag);

				} else if (glAcctName.equalsIgnoreCase(acctName3)) {

					String flag = WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/div[3]/div[2]/table/tbody/tr[" + g + "]/td[6]").getText();
					Assert.assertEquals(flag1, flag);

				} else if (glAcctName.equalsIgnoreCase(acctName4)) {

					String flag = WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/div[3]/div[2]/table/tbody/tr[" + g + "]/td[6]").getText();
					Assert.assertEquals(flag2, flag);

					String acctPay_Recv = WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/div[3]/div[2]/table/tbody/tr[" + g + "]/td[7]")
									.getText().replace("₹", "").replace(",", "");
					Assert.assertEquals(data.get(a).get("Facility-ShipGroup"), acctPay_Recv);

				}
			}
			a++;
		}
	}

	public static void Acct_Trans_Val_PaymentID(List<HashMap<String, String>> data, String acctName1, String acctName2, String flag1, String flag2) {

		WebdriverWait.findElement("link", "GL Transaction View/Entry").click();
		WebdriverWait.findElement("xpath", "//*[@id='toggleLink']").click();
		WebdriverWait.findElement("name", "paymentId").sendKeys(data.get(14).get("Dept"));
		WebdriverWait.findElement("xpath", "//*[@id='findAcctgTrans']/div/table/tbody[1]/tr[13]/td/input").click();

		String Posted_Status = driver.findElement(By.xpath("//*[@id='example']/tbody/tr/td[5]")).getText();
		Assert.assertEquals("Y", Posted_Status);
		WebdriverWait.findElement("xpath", "//*[@id= 'example']/tbody/tr/td[1]/a").click();

		for (int g = 1; g <= 2; g++) {
			String glAcctName = WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/div[3]/div[2]/table/tbody/tr[" + g + "]/td[2]").getText();

			if (glAcctName.equalsIgnoreCase(acctName1)) {

				String flag = WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/div[3]/div[2]/table/tbody/tr[" + g + "]/td[6]").getText();
				Assert.assertEquals(flag1, flag);

				String bank = WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/div[3]/div[2]/table/tbody/tr[" + g + "]/td[7]").getText()
								.replace("₹", "").replace(",", "");
				Assert.assertEquals(data.get(18).get("Dept"), bank);

			} else if (glAcctName.equalsIgnoreCase(acctName2)) {

				String flag = WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/div[3]/div[2]/table/tbody/tr[" + g + "]/td[6]").getText();
				Assert.assertEquals(flag2, flag);

				String acctPay_Recv = WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/div[3]/div[2]/table/tbody/tr[" + g + "]/td[7]")
								.getText().replace("₹", "").replace(",", "");
				Assert.assertEquals(data.get(18).get("Dept"), acctPay_Recv);
			}
		}

	}

}
