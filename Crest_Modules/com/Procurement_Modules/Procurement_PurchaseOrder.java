package com.Procurement_Modules;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.Utils.Base;
import com.Utils.CrestTestDataReader;
import com.Utils.ExcelWriter;
import com.Utils.WebdriverWait;

public class Procurement_PurchaseOrder extends Base {

	public static Logger log = Logger.getLogger(Procurement_PurchaseOrder.class);
	static List<HashMap<String, String>> PO_Enc_data = CrestTestDataReader.getPOEncData();

	public static String po_Number;
	public static String AdhocPo_Number;
	public static String EncPo_Number;

	public static void PO_Start_Order(List<HashMap<String, String>> data, String poname, String order_type) {

		log.info("Creating a New PO");
		WebdriverWait.findElement("link", "PROCUREMENT").click();
		WebdriverWait.findElement("link", "Purchase Order").click();
		WebdriverWait.findElement("link", "Create Purchase Order").click();

		Select org_dd = new Select(WebdriverWait.findElement("id", "billToCustomerPartyId"));
		org_dd.selectByVisibleText(data.get(0).get("Organization"));

		Select sup_dd = new Select(WebdriverWait.findElement("id", "supplierPartyId"));
		sup_dd.selectByVisibleText(data.get(0).get("Supplier"));

		WebdriverWait.findElement("id", "orderName").sendKeys(poname);

		Select ordType_dd = new Select(WebdriverWait.findElement("id", "orderType"));
		ordType_dd.selectByVisibleText(order_type);

		Select currency_dd = new Select(WebdriverWait.findElement("id", "currencyUomId"));
		currency_dd.selectByVisibleText(data.get(0).get("Currency"));

		WebdriverWait.findElement("id", "workeffortId").sendKeys("");

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String Fromdate = (dateFormat.format(new Date()));

		WebdriverWait.findElement("name", "orderDate_i18n").clear();
		WebdriverWait.findElement("name", "orderDate_i18n").sendKeys(Fromdate);

		Select numType_dd = new Select(WebdriverWait.findElement("id", "numberingFormatId"));
		numType_dd.selectByVisibleText("Purchase Order");

		Select payTerm_dd = new Select(WebdriverWait.findElement("id", "agreementId"));
		payTerm_dd.selectByVisibleText("-Select-");

		WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/form/div[3]/div[3]/a[1]").click();

	}
	public static void PO_Shipping_Details(List<HashMap<String, String>> data) {

		log.info("Adding Ship Groups");
		String facility = "_facilityId";

		for (int a = 0; a <= 2; a++) {
			Select shpFacility = new Select(WebdriverWait.findElement("id", a + facility));
			if (a == 0) {
				shpFacility.selectByVisibleText(data.get(1).get("Facility-ShipGroup"));
				WebdriverWait.findElement("link", "New Ship Group").click();
			} else if (a == 1) {
				shpFacility.selectByVisibleText(data.get(6).get("Facility-ShipGroup"));
				WebdriverWait.findElement("link", "New Ship Group").click();
			} else if (a == 2) {
				shpFacility.selectByVisibleText(data.get(9).get("Facility-ShipGroup"));
			}
		}
		WebdriverWait.findElement("link", "Continue").click();
	}

	public static void PO_OrderItems(List<HashMap<String, String>> data) throws InterruptedException {

		log.info("Adding products");
		for (int p = 0; p <= 9; p++) {
			Select ordType_dd = new Select(WebdriverWait.findElement("id", "addItemType"));
			ordType_dd.selectByVisibleText(data.get(0).get("OrderType"));
			Thread.sleep(1000);
			WebdriverWait.findElement("name", "add_product_id").sendKeys(data.get(p).get("Product ID"));
			WebdriverWait.findElement("name", "quantity").sendKeys(data.get(p).get("Qty"));

			Select uom_dd = new Select(WebdriverWait.findElement("id", "quantityUomId"));
			uom_dd.selectByVisibleText(data.get(p).get("UOM"));

			Select dept_dd = new Select(WebdriverWait.findElement("id", "departmentName"));
			dept_dd.selectByVisibleText(data.get(p).get("Dept"));

			WebdriverWait.findElement("name", "itemComment").sendKeys("Test");

			Select discountType_dd = new Select(WebdriverWait.findElement("id", "discountType"));
			discountType_dd.selectByVisibleText("-Select-");

			Select fac_dd = new Select(WebdriverWait.findElement("id", "toGroupIndex"));

			if (p <= 4) {

				List<WebElement> options = WebdriverWait.findElements("xpath", "//*[@id='toGroupIndex']//option");
				for (WebElement option : options) {
					if (option.getText().contains(data.get(0).get("Facility-ShipGroup"))) {
						option.click();
						break;
					}
				}

			} else if (p >= 5 && p <= 7) {

				List<WebElement> options = WebdriverWait.findElements("xpath", "//*[@id='toGroupIndex']//option");
				for (WebElement option : options) {
					if (option.getText().contains(data.get(5).get("Facility-ShipGroup"))) {
						option.click();
						break;
					}
				}

			} else if (p >= 8 && p <= 9) {

				List<WebElement> options = WebdriverWait.findElements("xpath", "//*[@id='toGroupIndex']//option");
				for (WebElement option : options) {
					if (option.getText().contains(data.get(8).get("Facility-ShipGroup"))) {
						option.click();
						break;
					}
				}
			}

			WebdriverWait.findElement("name", "submitItems").click();
		}
		WebdriverWait.findElement("link", "Continue").click();
	}

	public static void PO_ReviewCreatePO(String sheetname) {

		WebdriverWait.findElement("link", "Create").click();
		Procurement_PurchaseOrder_View.POnum_Capture(sheetname);
	}

	public static void PO_ReviewCreatePO_TDS(String sheetname) {
		WebdriverWait.findElement("link", "Create").click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Procurement_PurchaseOrder_View.POnum_Capture(sheetname);
	}

	// ************************************************************************************************************************************************//
	// PO With Adhoc Flow
	// ************************************************************************************************************************************************//

	public static void PO_Adhoc_OrderItems(List<HashMap<String, String>> data) throws InterruptedException {

		log.info("Adding Inv products & Adhoc Products");
		for (int p = 0; p <= 9; p++) {

			if (p <= 4) {
				Select OrdType_DD = new Select(WebdriverWait.findElement("id", "addItemType"));
				OrdType_DD.selectByVisibleText(data.get(p).get("OrderType"));

				Thread.sleep(1000);

				WebdriverWait.findElement("name", "add_product_id").sendKeys(data.get(p).get("Product ID"));
				WebdriverWait.findElement("name", "quantity").sendKeys(data.get(p).get("Qty"));

				Select uom_dd = new Select(WebdriverWait.findElement("id", "quantityUomId"));
				uom_dd.selectByVisibleText(data.get(p).get("UOM"));

				Select dept_dd = new Select(WebdriverWait.findElement("id", "departmentName"));
				dept_dd.selectByVisibleText(data.get(p).get("Dept"));

				WebdriverWait.findElement("name", "itemComment").sendKeys("Test");

				Select discountType_dd = new Select(WebdriverWait.findElement("id", "discountType"));
				discountType_dd.selectByVisibleText("-Select-");

				Select fac_dd = new Select(WebdriverWait.findElement("id", "toGroupIndex"));
				fac_dd.selectByVisibleText(data.get(0).get("Facility-ShipGroup"));

				WebdriverWait.findElement("name", "submitItems").click();

			} else if (p >= 5 && p <= 7) {

				Select ordType_dd = new Select(WebdriverWait.findElement("id", "addItemType"));
				ordType_dd.selectByVisibleText(data.get(p).get("OrderType"));

				Thread.sleep(2000);

				WebdriverWait.findElement("name", "add_item_description").sendKeys(data.get(p).get("Product ID"));
				WebdriverWait.findElement("xpath", "//*[@id='adHoc']/table/tbody/tr[2]/td[2]/input").sendKeys(data.get(p).get("Qty"));
				WebdriverWait.findElement("name", "price").sendKeys(data.get(p).get("Purchase Price"));

				Select taxCat_dd = new Select(WebdriverWait.findElement("id", "gstCategoryId"));
				taxCat_dd.selectByVisibleText("GST 5%");

				Select dept_dd = new Select(WebdriverWait.findElement("id", "departmentName1"));
				dept_dd.selectByVisibleText(data.get(p).get("Dept"));

				Select fac_dd = new Select(WebdriverWait.findElement("xpath",
								"/html/body/div[2]/div[4]/div/div[1]/div[2]/div[2]/form[2]/div/table/tbody/tr[4]/td[4]/select"));
				fac_dd.selectByVisibleText(data.get(5).get("Facility-ShipGroup"));

				WebdriverWait.findElement("xpath", "//*[@id='adHoc']/table/tbody/tr[6]/td[2]/input").click();

			} else if (p >= 8 && p <= 9) {

				Select ordType_dd = new Select(WebdriverWait.findElement("id", "addItemType"));
				ordType_dd.selectByVisibleText(data.get(p).get("OrderType"));

				Thread.sleep(2000);

				WebdriverWait.findElement("name", "add_item_description").sendKeys(data.get(p).get("Product ID"));
				WebdriverWait.findElement("xpath", "//*[@id='adHoc']/table/tbody/tr[2]/td[2]/input").sendKeys(data.get(p).get("Qty"));
				WebdriverWait.findElement("name", "price").sendKeys(data.get(p).get("Purchase Price"));

				Select taxCat_dd = new Select(WebdriverWait.findElement("id", "gstCategoryId"));
				taxCat_dd.selectByVisibleText("GST 18%");

				Select dept_dd = new Select(WebdriverWait.findElement("id", "departmentName1"));
				dept_dd.selectByVisibleText(data.get(p).get("Dept"));

				Select fac_dd = new Select(WebdriverWait.findElement("xpath",
								"/html/body/div[2]/div[4]/div/div[1]/div[2]/div[2]/form[2]/div/table/tbody/tr[4]/td[4]/select"));
				fac_dd.selectByVisibleText(data.get(8).get("Facility-ShipGroup"));

				WebdriverWait.findElement("xpath", "//*[@id='adHoc']/table/tbody/tr[6]/td[2]/input").click();
			}
		}
		WebdriverWait.findElement("link", "Continue").click();
		log.info("PO Number Created Successfully");

		// String AdhocPO_Num = WebdriverWait.findElement("xpath",
		// "//*[@id='content-main-section']/div[1]/div[2]/table/tbody/tr[1]/td[2]/a").getText();
		// System.out.println("Adhoc PO Number = " + AdhocPO_Num);
		// AdhocPo_Number = AdhocPO_Num;
		// ExcelWriter.writeExcelFile("PO_Adhoc", 14, 3, AdhocPO_Num);

	}

	// ************************************************************************************************************************************************//
	// PO With Encumbrance Flow
	// ************************************************************************************************************************************************//

	public static void PO_Enc_Start_Order() {

		log.info("Creating a New PO Encumbrance Flow");
		WebdriverWait.findElement("link", "PROCUREMENT").click();
		WebdriverWait.findElement("link", "Purchase Order").click();
		WebdriverWait.findElement("link", "Create Purchase Order").click();

		Select Org_DD = new Select(WebdriverWait.findElement("id", "billToCustomerPartyId"));
		Org_DD.selectByVisibleText(PO_Enc_data.get(0).get("Organization"));

		Select Sup_DD = new Select(WebdriverWait.findElement("id", "supplierPartyId"));
		Sup_DD.selectByVisibleText(PO_Enc_data.get(0).get("Supplier"));

		WebdriverWait.findElement("id", "orderName").sendKeys("PO Automation Encumbrance Flow");

		Select Ordtype_DD = new Select(WebdriverWait.findElement("id", "orderType"));
		Ordtype_DD.selectByVisibleText("Encumbrance");

		Select Currency_DD = new Select(WebdriverWait.findElement("id", "currencyUomId"));
		Currency_DD.selectByVisibleText(PO_Enc_data.get(0).get("Currency"));

		// Adding Current Date(From Date)
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String Fromdate = (dateFormat.format(new Date()));
		WebdriverWait.findElement("name", "fromDate_i18n").sendKeys(Fromdate);

		// Adding 10days extra from Current Date(ToDate)
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, 10);
		String newDate = dateFormat.format(cal.getTime());
		WebdriverWait.findElement("id", "thruDate_i18n").sendKeys(newDate);

		Select NumType_DD = new Select(WebdriverWait.findElement("id", "numberingFormatId"));
		NumType_DD.selectByVisibleText("Purchase Order");

		WebdriverWait.findElement("link", "Continue").click();
	}

	public static void PO_Enc_Add_ShpGrps() {

		log.info("Adding Ship Groups for PO Encumbrance Flow");
		String facility = "_facilityId";

		for (int a = 0; a <= 1; a++) {
			Select Shpfacility = new Select(WebdriverWait.findElement("id", a + facility));
			if (a == 0) {
				Shpfacility.selectByVisibleText(PO_Enc_data.get(1).get("Facility-ShipGroup"));
				System.out.println(PO_Enc_data.get(1).get("Facility-ShipGroup"));
				WebdriverWait.findElement("name", "newShipGroup").click();
			} else if (a == 1) {
				Shpfacility.selectByVisibleText(PO_Enc_data.get(3).get("Facility-ShipGroup"));
				System.out.println(PO_Enc_data.get(3).get("Facility-ShipGroup"));
			}
		}
		WebdriverWait.findElement("link", "Continue").click();
	}

	public static void PO_Enc_Add_Prd() throws InterruptedException {

		for (int p = 0; p <= 3; p++) {
			log.info("Adding Products for Encumbrance Order");

			Select OrdType_DD = new Select(WebdriverWait.findElement("id", "addItemType"));
			OrdType_DD.selectByVisibleText(PO_Enc_data.get(0).get("OrderType"));

			Thread.sleep(1000);
			WebdriverWait.findElement("name", "add_product_id").sendKeys(PO_Enc_data.get(p).get("Product ID"));
			WebdriverWait.findElement("name", "quantity").sendKeys(PO_Enc_data.get(p).get("Qty"));

			Select UOM_DD = new Select(WebdriverWait.findElement("id", "quantityUomId"));
			UOM_DD.selectByVisibleText(PO_Enc_data.get(p).get("UOM"));

			Thread.sleep(1000);

			Select Dept_DD = new Select(WebdriverWait.findElement("id", "departmentName"));
			Dept_DD.selectByVisibleText(PO_Enc_data.get(p).get("Dept"));

			WebdriverWait.findElement("name", "itemComment").sendKeys("Test");

			Select Fac_DD = new Select(WebdriverWait.findElement("id", "toGroupIndex"));

			if (p <= 1) {
				Fac_DD.selectByVisibleText(PO_Enc_data.get(0).get("Facility-ShipGroup"));
			} else {
				Fac_DD.selectByVisibleText(PO_Enc_data.get(2).get("Facility-ShipGroup"));
			}
			WebdriverWait.findElement("name", "submitItems").click();
		}
		WebdriverWait.findElement("link", "Continue").click();
		WebdriverWait.findElement("link", "Create").click();
		log.info("PO Number Created Successfully");

		String Enc_PO_Num = WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/div[1]/div[2]/table/tbody/tr[1]/td[2]/a").getText();
		System.out.println("PO Number = " + Enc_PO_Num);
		EncPo_Number = Enc_PO_Num;
		ExcelWriter.writeExcelFile("PO_Enc", 8, 0, Enc_PO_Num);
	}

	public static void PO_Enc_GrdTotal_Val() {

		log.info("Validating GrandTotal");
		String PO_EncGrdTotal = WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/div[6]/div[2]/table/tbody/tr[8]/td[3]/span").getText()
						.replace("₹", "").replace(",", "");
		System.out.println(PO_EncGrdTotal);
		System.out.println(PO_Enc_data.get(7).get("Product ID"));
		Assert.assertEquals(PO_Enc_data.get(7).get("Product ID"), PO_EncGrdTotal);
		log.info("Grand Total & Tax Amt validated Successfully for PO Encumbrance Flow");
	}

	public static void Po_Enc_Approve_Po() {

		log.info("Approve PO for Encumbrance");
		WebdriverWait.findElement("link", "Review Order").click();
		WebdriverWait.findElement("link", "Review 2 Order").click();
		WebdriverWait.findElement("link", "Approve Order").click();
		String App_Status_Val = WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/div[1]/div[2]/table/tbody/tr[5]/td[2]").getText();
		Assert.assertEquals("Approved", App_Status_Val);
		log.info("Status validated successfully as Approved");

	}

	public static void Search_PO(List<HashMap<String, String>> data) {

		WebdriverWait.findElement("link", "PROCUREMENT").click();
		WebdriverWait.findElement("link", "Purchase Order").click();
		WebdriverWait.findElement("id", "orderId").sendKeys(data.get(14).get("Supplier"));
		WebdriverWait.findElement("xpath", "//*[@id='searchCriteria']/div/table/tbody/tr[17]/td/input").click();
		WebdriverWait.findElement("xpath", "//*[@id='example']/tbody/tr/td[3]/a").click();

	}

	public static void Edit_lineItem_Discounts(List<HashMap<String, String>> data) {

		Search_PO(data);
		Procurement_PurchaseOrder_View.EditOrderLink();

		for (int a = 1; a <= 4; a++) {

			Select disType = new Select(WebdriverWait.findElement("id", "dvmValDisc_" + a));
			disType.selectByVisibleText(data.get(a - 1).get("Discount Type"));

			WebdriverWait.findElement("id", "dvmVal_" + a).sendKeys(data.get(a - 1).get("Discount"));

			WebdriverWait.findElement("id", "selectedItem_" + a).click();
		}

		WebdriverWait.findElement("link", "Recalculate Selected").click();
	}

	public static void Edit_Adjustments(List<HashMap<String, String>> data) {

		Search_PO(data);
		Procurement_PurchaseOrder_View.EditOrderLink();

		Select adj = new Select(WebdriverWait.findElement("name", "orderAdjustmentTypeId"));
		adj.selectByVisibleText("Fee");

		Select fac = new Select(WebdriverWait.findElement("name", "shipGroupSeqId"));
		fac.selectByVisibleText("UIDAI - Inventory - WH");

		WebdriverWait.findElement("id", "description").sendKeys("Transport Charges");
		WebdriverWait.findElement("id", "amount").clear();
		WebdriverWait.findElement("id", "amount").sendKeys(data.get(32).get("Adjustments"));
		WebdriverWait.findElement("xpath", "//*[@id='content-main-section']/div//form[8]//tr[3]//td//input").click();

		String adj_success_msg = WebdriverWait.findElement("xpath", "//*[@id='content-messages']/div/p").getText();
		Assert.assertEquals("Order Adjustment created successfully.", adj_success_msg);

	}
}
