package com.Sales_Modules;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.Utils.Base;
import com.Utils.CrestTestDataReader;
import com.Utils.WebdriverWait;

public class Sales_SalesOrder extends Base {

	public static Logger log = Logger.getLogger(Sales_SalesOrder.class);
	static List<HashMap<String, String>> SO_data = CrestTestDataReader.getSO_Offline_Data();

	public static String so_Number;

	public static void SO_StartOrder(List<HashMap<String, String>> data, String soname, String ordertype) {

		WebdriverWait.findElement("link", "SALES").click();
		WebdriverWait.findElement("link", "Sales Order").click();
		WebdriverWait.findElement("link", "Create Sales Order").click();

		Select org_dd = new Select(WebdriverWait.findElement("id", "billToCustomerPartyId"));
		org_dd.selectByVisibleText(SO_data.get(0).get("Organization"));

		WebdriverWait.findElement("name", "partyId").sendKeys("11651");//

		WebdriverWait.findElement("name", "orderName").sendKeys(soname);

		// Adding Current Date(From Date)

		// SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		// String Fromdate = (dateFormat.format(new Date()));
		// WebdriverWait.findElement("name",
		// "orderDate_i18n").sendKeys(Fromdate);

		Select ordType_dd = new Select(WebdriverWait.findElement("id", "orderType"));
		ordType_dd.selectByVisibleText(ordertype);

		Select currency_dd = new Select(WebdriverWait.findElement("id", "currencyUomId"));
		currency_dd.selectByVisibleText(data.get(0).get("Currency"));

		Select prdStore_dd = new Select(WebdriverWait.findElement("id", "productStoreId"));
		prdStore_dd.selectByVisibleText("General Sales Store");

		Select salesChn_dd = new Select(WebdriverWait.findElement("id", "salesChannelEnumId"));
		salesChn_dd.selectByVisibleText("Web Channel");

		Select numType_dd = new Select(WebdriverWait.findElement("id", "numberingFormatId"));
		numType_dd.selectByVisibleText("UIDAI Sales Order");

	}

	public static void SO_ShippingDetails(List<HashMap<String, String>> data) {

		log.info("SO Adding Ship Groups");
		String facility = "_shipGroupFacilityId";
		String shpAdd = "_contactMechId";
		String shpmethd = "_shipping_method";

		for (int a = 0; a <= 2; a++) {
			Select shpFacility = new Select(WebdriverWait.findElement("id", a + facility));
			Select shpAddress = new Select(WebdriverWait.findElement("id", a + shpAdd));
			Select shpMethod = new Select(WebdriverWait.findElement("id", a + shpmethd));
			if (a == 0) {
				shpFacility.selectByVisibleText(data.get(1).get("Facility-ShipGroup"));
				shpAddress.selectByVisibleText("Workphilia");
				shpMethod.selectByVisibleText("Standard");
				WebdriverWait.findElement("xpath", "//*[@id='content-main-section']//div//a").click();
			} else if (a == 1) {
				shpFacility.selectByVisibleText(data.get(6).get("Facility-ShipGroup"));
				shpAddress.selectByVisibleText("Workphilia");
				shpMethod.selectByVisibleText("Standard");
				WebdriverWait.findElement("xpath", "//*[@id='content-main-section']//div//a").click();
			} else if (a == 2) {
				shpFacility.selectByVisibleText(data.get(9).get("Facility-ShipGroup"));
				shpAddress.selectByVisibleText("Workphilia");
				shpMethod.selectByVisibleText("Standard");
			}
		}
		WebdriverWait.findElement("xpath", "//*[@id='content-main-section']//div[3]//a[1]").click();
	}

	public static void SO_OrderItems(List<HashMap<String, String>> data) throws InterruptedException {

		log.info("SO Adding products");
		for (int p = 0; p <= 9; p++) {

			Thread.sleep(1000);
			WebdriverWait.findElement("name", "add_product_id").sendKeys(data.get(p).get("Product ID"));

			WebdriverWait.findElement("name", "quantity").sendKeys(data.get(p).get("Qty"));

			Select dept_dd = new Select(WebdriverWait.findElement("id", "departmentName"));
			dept_dd.selectByVisibleText(data.get(p).get("Dept"));

			Select discountType_dd = new Select(WebdriverWait.findElement("id", "discountType"));
			discountType_dd.selectByVisibleText("-Select-");

			Select fac_dd = new Select(WebdriverWait.findElement("id", "toGroupIndex"));
			if (p <= 4) {
				fac_dd.selectByVisibleText(data.get(0).get("Facility-ShipGroup"));

				WebElement ATP = WebdriverWait.findElement("id", "ATP");
				WebElement QOH = WebdriverWait.findElement("id", "QOH");
				Assert.assertEquals(true, ATP.isDisplayed());
				Assert.assertEquals(true, QOH.isDisplayed());

			} else if (p >= 5 && p <= 7) {
				fac_dd.selectByVisibleText(data.get(5).get("Facility-ShipGroup"));

				WebElement ATP = WebdriverWait.findElement("id", "ATP");
				WebElement QOH = WebdriverWait.findElement("id", "QOH");
				Assert.assertEquals(true, ATP.isDisplayed());
				Assert.assertEquals(true, QOH.isDisplayed());
			} else if (p >= 8 && p <= 9) {
				fac_dd.selectByVisibleText(data.get(8).get("Facility-ShipGroup"));

				WebElement ATP = WebdriverWait.findElement("id", "ATP");
				WebElement QOH = WebdriverWait.findElement("id", "QOH");
				Assert.assertEquals(true, ATP.isDisplayed());
				Assert.assertEquals(true, QOH.isDisplayed());
			}

			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dropShipReq")));
			// Select DropShp_DD = new
			// Select(WebdriverWait.findElement("id","dropShipReq")));
			// DropShp_DD.selectByVisibleText("No");

			WebElement price = WebdriverWait.findElement("id", "priceValue");
			Assert.assertEquals(true, price.isDisplayed());
			WebdriverWait.findElement("name", "itemComment").sendKeys("Test");

			Thread.sleep(3000);

			WebElement addBtn = WebdriverWait.findElement("name", "submitItems");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addBtn);

		}

		WebdriverWait.findElement("link", "Continue").click();
	}

	public static void SO_ReviewCreateSO(String sheetname) {

		WebdriverWait.findElement("link", "Create").click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		log.info("SO Number Created Successfully");

		Sales_SalesOrder_View.Capture_SONum(sheetname);

	}

	public static void OfflinePayment_Chkbox() {

		WebdriverWait.findElement("xpath", "//*[@id= 'paymentMethodTypeAndId'][@value = 'EXT_OFFLINE']").click();
		WebdriverWait.findElement("link", "Continue").click();
	}

	public static void BillingAcct_Chkbox() {

		WebdriverWait.findElement("xpath", "//*[@id='paymentMethodTypeAndId'][@value ='Payment_billing']").click();
		WebElement billingAcctBal = WebdriverWait.findElement("id", "remainingBalance");
		Assert.assertEquals(true, billingAcctBal.isDisplayed());

		WebdriverWait.findElement("link", "Continue").click();
	}
}