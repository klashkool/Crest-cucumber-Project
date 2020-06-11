package com.Procurement_Modules;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import com.Utils.Base;
import com.Utils.ExcelWriter;
import com.Utils.WebdriverWait;

public class Procurement_Requirements_Requirements extends Base {

	public static Logger log = Logger.getLogger(Procurement_Requirements_Requirements.class);

	public static void PO_Req(List<HashMap<String, String>> data, String sheetname) throws InterruptedException {

		log.info("Creating PO Requirements");
		WebdriverWait.findElement("link", "PROCUREMENT").click();
		WebdriverWait.findElement("link", "Requirements").click();
		WebdriverWait.findElement("link", "Create Requirement").click();
		// Requirement Type DD

		Select reqType_dd = new Select(WebdriverWait.findElement("id", "requirementTypeId"));
		reqType_dd.selectByVisibleText("Product Requirement");
		// Organization DD
		Select reqOrg_dd = new Select(WebdriverWait.findElement("id", "fromPartyId"));
		reqOrg_dd.selectByVisibleText(data.get(0).get("Organization"));

		log.info("Adding products for Requirements");
		for (int p = 0; p <= 9; p++) {

			if (p <= 4) {
			Select ordType_dd = new Select(WebdriverWait.findElement("id", "addItemType"));
			ordType_dd.selectByVisibleText(data.get(p).get("OrderType"));

			Thread.sleep(1000);
			WebdriverWait.findElement("name", "productId").sendKeys(data.get(p).get("Product ID"));
			WebdriverWait.findElement("name", "quantity").sendKeys(data.get(p).get("Qty"));

			Select reqUom_dd = new Select(WebdriverWait.findElement("id", "quantityUomId"));
			reqUom_dd.selectByVisibleText(data.get(p).get("UOM"));

			Select dept_dd = new Select(WebdriverWait.findElement("id", "departmentName"));
			dept_dd.selectByVisibleText(data.get(p).get("Dept"));

			WebdriverWait.findElement("name", "comments").sendKeys("Automation PO Req Test");

			Select fac_dd = new Select(WebdriverWait.findElement("id", "facilityId"));
			fac_dd.selectByVisibleText(data.get(1).get("Facility-ShipGroup"));

			WebdriverWait.findElement("name", "submitProduct").click();

			}  else if (p >= 5 && p <= 7) {

				Select ordType_dd = new Select(WebdriverWait.findElement("id", "addItemType"));
				ordType_dd.selectByVisibleText(data.get(p).get("OrderType"));

				Thread.sleep(2000);
				WebdriverWait.findElement("name", "quantity").sendKeys(data.get(p).get("Qty"));

				Select uom_dd = new Select(WebdriverWait.findElement("id", "quantityUomId"));
				uom_dd.selectByVisibleText(data.get(p).get("UOM"));

				Select taxCat_dd = new Select(WebdriverWait.findElement("id", "gstCategory"));
				taxCat_dd.selectByVisibleText("GST 5%");

				Select dept_dd = new Select(WebdriverWait.findElement("id", "departmentName"));
				dept_dd.selectByVisibleText(data.get(p).get("Dept"));

				Select fac_dd = new Select(WebdriverWait.findElement("xpath",
								"/html/body/div[2]/div[4]/div[2]/div[1]/form[1]/div[2]/div[2]/table[1]/tbody[1]/tr[5]/td[2]/select"));
				fac_dd.selectByVisibleText(data.get(6).get("Facility-ShipGroup"));

				WebdriverWait.findElement("name", "comments").sendKeys(data.get(p).get("Product ID"));

				WebdriverWait.findElement("name", "submitProduct").click();

			} else if (p >= 8 && p <= 9) {

				Select ordType_dd = new Select(WebdriverWait.findElement("id", "addItemType"));
				ordType_dd.selectByVisibleText(data.get(p).get("OrderType"));

				Thread.sleep(2000);
				WebdriverWait.findElement("name", "quantity").sendKeys(data.get(p).get("Qty"));

				Select uom_dd = new Select(WebdriverWait.findElement("id", "quantityUomId"));
				uom_dd.selectByVisibleText(data.get(p).get("UOM"));

				Select taxCat_dd = new Select(WebdriverWait.findElement("id", "gstCategory"));
				taxCat_dd.selectByVisibleText("GST 18%");

				Select dept_dd = new Select(WebdriverWait.findElement("id", "departmentName"));
				dept_dd.selectByVisibleText(data.get(p).get("Dept"));

				Select fac_dd = new Select(WebdriverWait.findElement("xpath",
								"/html/body/div[2]/div[4]/div[2]/div[1]/form[1]/div[2]/div[2]/table[1]/tbody[1]/tr[5]/td[2]/select"));
				fac_dd.selectByVisibleText(data.get(9).get("Facility-ShipGroup"));

				WebdriverWait.findElement("name", "comments").sendKeys(data.get(p).get("Product ID"));

				WebdriverWait.findElement("name", "submitProduct").click();
			}

		}

		WebdriverWait.findElement("xpath", "//*[@id='createRequirements']/div[3]/input").click();

		String reqPoNum = WebdriverWait.findElement("xpath", "//*[@id='editRequirements']/table/tbody[1]/tr[1]/td[2]")
				.getText();
		System.out.println("Req ID = " + reqPoNum);
		ExcelWriter.writeExcelFile(sheetname, 15, 0, reqPoNum);

		WebdriverWait.findElement("link", "Approve").click();

		String reqPoStatus = WebdriverWait
				.findElement("xpath", "//*[@id='editRequirements']/table/tbody[1]/tr[2]/td[4]").getText();
		Assert.assertEquals("Approved", reqPoStatus);

		System.out.println("PO Requirements Created Successfully");
		log.info("PO Requirements Created Successfully");

		WebdriverWait.findElement("link", "Create RFQ").click();

	}

	public static void PO_Req_Inv(List<HashMap<String, String>> data, String sheetname) throws InterruptedException {

		log.info("Creating PO Requirements");
		WebdriverWait.findElement("link", "PROCUREMENT").click();
		WebdriverWait.findElement("link", "Requirements").click();
		WebdriverWait.findElement("link", "Create Requirement").click();
		// Requirement Type DD

		Select reqType_dd = new Select(WebdriverWait.findElement("id", "requirementTypeId"));
		reqType_dd.selectByVisibleText("Product Requirement");
		// Organization DD
		Select reqOrg_dd = new Select(WebdriverWait.findElement("id", "fromPartyId"));
		reqOrg_dd.selectByVisibleText(data.get(0).get("Organization"));

		log.info("Adding products for Requirements");
		for (int p = 0; p <= 9; p++) {

			Select ordType_dd = new Select(WebdriverWait.findElement("id", "addItemType"));
			ordType_dd.selectByVisibleText(data.get(p).get("OrderType"));

			Thread.sleep(1000);
			WebdriverWait.findElement("name", "productId").sendKeys(data.get(p).get("Product ID"));
			WebdriverWait.findElement("name", "quantity").sendKeys(data.get(p).get("Qty"));

			Select reqUom_dd = new Select(WebdriverWait.findElement("id", "quantityUomId"));
			reqUom_dd.selectByVisibleText(data.get(p).get("UOM"));

			Select dept_dd = new Select(WebdriverWait.findElement("id", "departmentName"));
			dept_dd.selectByVisibleText(data.get(p).get("Dept"));

			WebdriverWait.findElement("name", "comments").sendKeys("Automation PO Req Test");

			Select fac_dd = new Select(WebdriverWait.findElement("id", "facilityId"));

			if (p <= 4) {
				fac_dd.selectByVisibleText(data.get(1).get("Facility-ShipGroup"));
			} else if (p >= 5 && p <= 7) {
				fac_dd.selectByVisibleText(data.get(6).get("Facility-ShipGroup"));
			} else if (p >= 8 && p <= 9) {
				fac_dd.selectByVisibleText(data.get(9).get("Facility-ShipGroup"));
			}
			WebdriverWait.findElement("name", "submitProduct").click();
		}

		WebdriverWait.findElement("name", "createProduct").click();

		String reqPoNum = WebdriverWait.findElement("xpath", "//*[@id='editRequirements']/table/tbody[1]/tr[1]/td[2]")
				.getText();
		System.out.println("Req ID = " + reqPoNum);
		ExcelWriter.writeExcelFile(sheetname, 15, 0, reqPoNum);

		WebdriverWait.findElement("link", "Approve").click();

		String reqPoStatus = WebdriverWait
				.findElement("xpath", "//*[@id='editRequirements']/table/tbody[1]/tr[2]/td[4]").getText();
		Assert.assertEquals("Approved", reqPoStatus);

		System.out.println("PO Requirements Created Successfully");
		log.info("PO Requirements Created Successfully");

		WebdriverWait.findElement("link", "Create RFQ").click();

	}
	}

