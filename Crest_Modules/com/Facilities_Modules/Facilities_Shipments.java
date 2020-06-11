package com.Facilities_Modules;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.Sales_Modules.Sales_SalesOrder_View;
import com.Utils.Base;
import com.Utils.ExcelWriter;
import com.Utils.WebdriverWait;

public class Facilities_Shipments extends Base {

	public static Logger log = Logger.getLogger(Facilities_Shipments.class);

	// Scenario: Receive PO Inventory

	public static void PO_ReceiveInv(List<HashMap<String, String>> data, String sheetname) throws InterruptedException {

		for (int Shp = 1; Shp <= 4; Shp++) {

			log.info("Receiving Inventory for all the products");

			WebdriverWait.findElement("link", "FACILITIES").click();
			WebdriverWait.findElement("link", "Shipments").click();
			WebdriverWait.findElement("link", "Create Shipment").click();

			Select ShpType_DD = new Select(WebdriverWait.findElement("id", "shipmentTypeId"));
			ShpType_DD.selectByVisibleText("Purchase Shipment");

			WebdriverWait.findElement("id", "0_lookupId_primaryOrderId").sendKeys(data.get(14).get("Supplier"));
			WebdriverWait.findElement("id", "additionalShippingCharge").click();

			Select F_ShipGrp_DDN = new Select(WebdriverWait.findElement("id", "primaryShipGroupSeqId"));
			if (Shp == 1) {
				log.info("Receiving Inventory with partial qty for Ship1");
				// F_ShipGrp_DDN.selectByVisibleText(data.get(0).get("Facility-ShipGroup"));

				List<WebElement> options = WebdriverWait.findElements("xpath", "//*[@id='primaryShipGroupSeqId']//option");
				for (WebElement option : options) {
					if (option.getText().contains(data.get(0).get("Facility-ShipGroup"))) {
						option.click();
						break;
					}
				}

				WebdriverWait.findElement("id", "createSubmit").click();

				Facilities_Shipments_View.PO_Capture_ShpID(sheetname, 15);
				Facilities_Shipments_OrderItems.PO_Partial_Shpmnt();
				Facilities_Facilities_StockManagement.PO_Receive_Shpmnt();
				Facilities_Shipments_View.PO_Shpmnt_Status_Val();

			} else if (Shp == 2) {
				log.info("Receiving Inventory with remaining partial qty for Ship1");
				// F_ShipGrp_DDN.selectByVisibleText(data.get(0).get("Facility-ShipGroup"));

				List<WebElement> options = WebdriverWait.findElements("xpath", "//*[@id='primaryShipGroupSeqId']//option");
				for (WebElement option : options) {
					if (option.getText().contains(data.get(0).get("Facility-ShipGroup"))) {
						option.click();
						break;
					}
				}
				WebdriverWait.findElement("id", "createSubmit").click();

				Facilities_Shipments_View.PO_Capture_ShpID(sheetname, 16);
				Facilities_Shipments_OrderItems.PO_Full_Shpmnt();
				Facilities_Facilities_StockManagement.PO_Receive_Shpmnt();
				Facilities_Shipments_View.PO_Shpmnt_Status_Val();

			} else if (Shp == 3) {
				log.info("Receiving Inventory with Full qty for Ship2");
				// F_ShipGrp_DDN.selectByVisibleText(data.get(5).get("Facility-ShipGroup"));

				List<WebElement> options = WebdriverWait.findElements("xpath", "//*[@id='primaryShipGroupSeqId']//option");
				for (WebElement option : options) {
					if (option.getText().contains(data.get(5).get("Facility-ShipGroup"))) {
						option.click();
						break;
					}
				}
				WebdriverWait.findElement("id", "createSubmit").click();

				Facilities_Shipments_View.PO_Capture_ShpID(sheetname, 17);
				Facilities_Shipments_OrderItems.PO_Full_Shpmnt();
				Facilities_Facilities_StockManagement.PO_Recv_Shpmnt_Mapping();
				Facilities_Shipments_View.PO_Shpmnt_Status_Val();

			} else if (Shp == 4) {
				log.info("Receiving Inventory with Full qty for Ship4");
				// F_ShipGrp_DDN.selectByVisibleText(data.get(8).get("Facility-ShipGroup"));

				List<WebElement> options = WebdriverWait.findElements("xpath", "//*[@id='primaryShipGroupSeqId']//option");
				for (WebElement option : options) {
					if (option.getText().contains(data.get(8).get("Facility-ShipGroup"))) {
						option.click();
						break;
					}
				}
				WebdriverWait.findElement("id", "createSubmit").click();

				Facilities_Shipments_View.PO_Capture_ShpID(sheetname, 18);
				Facilities_Shipments_OrderItems.PO_Full_Shpmnt();
				Facilities_Facilities_StockManagement.PO_Receive_Shpmnt();
				Facilities_Shipments_View.PO_Shpmnt_Status_Val();

				WebdriverWait.findElement("xpath", "//*[@id='primaryOrderIdRowAndPrimaryShipGroupSeqId']/td[2]/a").click();
			}
		}
	}

	// ************************************************************************************************************************************************//
	// PO With Adhoc Flow
	// ************************************************************************************************************************************************//

	public static void PO_Adhoc_ReceiveInv(List<HashMap<String, String>> data, String sheetname) throws InterruptedException {

		for (int Shp = 1; Shp <= 4; Shp++) {

			log.info("Receiving Inventory for all the products");

			WebdriverWait.findElement("link", "FACILITIES").click();

			if (Shp == 1) {
				WebdriverWait.findElement("link", "Shipments").click();
				WebdriverWait.findElement("link", "Create Shipment").click();

				Select ShpType_DD = new Select(WebdriverWait.findElement("id", "shipmentTypeId"));
				ShpType_DD.selectByVisibleText("Purchase Shipment");

				WebdriverWait.findElement("id", "0_lookupId_primaryOrderId").sendKeys(data.get(14).get("Supplier"));
				WebdriverWait.findElement("id", "additionalShippingCharge").click();

				Select F_ShipGrp_DDN = new Select(WebdriverWait.findElement("id", "primaryShipGroupSeqId"));
				// F_ShipGrp_DDN.selectByVisibleText(data.get(0).get("Facility-ShipGroup"));
				List<WebElement> options = WebdriverWait.findElements("xpath", "//*[@id='primaryShipGroupSeqId']//option");
				for (WebElement option : options) {
					if (option.getText().contains(data.get(0).get("Facility-ShipGroup"))) {
						option.click();
						break;
					}
				}

				WebdriverWait.findElement("id", "createSubmit").click();

				Facilities_Shipments_View.PO_Capture_ShpID(sheetname, 15);
				Facilities_Shipments_OrderItems.PO_Partial_Shpmnt();
				Facilities_Facilities_StockManagement.PO_Receive_Shpmnt();
				Facilities_Shipments_View.PO_Shpmnt_Status_Val();

			} else if (Shp == 2) {
				WebdriverWait.findElement("link", "Shipments").click();
				WebdriverWait.findElement("link", "Create Shipment").click();

				Select ShpType_DD = new Select(WebdriverWait.findElement("id", "shipmentTypeId"));
				ShpType_DD.selectByVisibleText("Purchase Shipment");

				WebdriverWait.findElement("id", "0_lookupId_primaryOrderId").sendKeys(data.get(14).get("Supplier"));
				WebdriverWait.findElement("id", "additionalShippingCharge").click();

				Select F_ShipGrp_DDN = new Select(WebdriverWait.findElement("id", "primaryShipGroupSeqId"));
				// F_ShipGrp_DDN.selectByVisibleText(data.get(0).get("Facility-ShipGroup"));
				List<WebElement> options = WebdriverWait.findElements("xpath", "//*[@id='primaryShipGroupSeqId']//option");
				for (WebElement option : options) {
					if (option.getText().contains(data.get(0).get("Facility-ShipGroup"))) {
						option.click();
						break;
					}
				}
				WebdriverWait.findElement("id", "createSubmit").click();

				Facilities_Shipments_View.PO_Capture_ShpID(sheetname, 16);
				Facilities_Shipments_OrderItems.PO_Full_Shpmnt();
				Facilities_Facilities_StockManagement.PO_Receive_Shpmnt();
				Facilities_Shipments_View.PO_Shpmnt_Status_Val();

			} else if (Shp == 3) {
				Facilities_ReceiveAdHoc.PO_Adhoc_Recv_PartialShpmt(data);

			} else if (Shp == 4) {
				Facilities_ReceiveAdHoc.PO_Adhoc_Recv_FullShpmt(data);
			}

		}

		WebdriverWait.findElement("link", "PROCUREMENT").click();
		WebdriverWait.findElement("link", "Purchase Order").click();
		WebdriverWait.findElement("id", "orderId").sendKeys(data.get(14).get("Supplier"));
		WebdriverWait.findElement("xpath", "//*[@id='searchCriteria']/div/table/tbody/tr[17]/td/input").click();
		WebdriverWait.findElement("xpath", "//*[@id='example']/tbody/tr/td[3]/a").click();
	}

	// ************************************************************************************************************************************************//
	// SO Offline Flow
	// ************************************************************************************************************************************************//

	public static void SO_CreateShipment(List<HashMap<String, String>> data, String sheetname) throws InterruptedException {

		for (int Shp = 1; Shp <= 4; Shp++) {

			log.info("Create Shipments for all the products");

			WebdriverWait.findElement("link", "FACILITIES").click();
			WebdriverWait.findElement("link", "Shipments").click();
			WebdriverWait.findElement("link", "Create Shipment").click();

			Select ShpType_DD = new Select(WebdriverWait.findElement("id", "shipmentTypeId"));
			ShpType_DD.selectByVisibleText("Sales Shipment");

			WebdriverWait.findElement("id", "0_lookupId_primaryOrderId").sendKeys(data.get(14).get("Customer"));
			WebdriverWait.findElement("id", "picklistBinId").click();

			Select F_ShipGrp_DDN = new Select(WebdriverWait.findElement("id", "primaryShipGroupSeqId"));
			if (Shp == 1) {
				log.info("Create Shipment with partial qty for Ship1");
				// F_ShipGrp_DDN.selectByVisibleText(data.get(0).get("Facility-ShipGroup"));

				List<WebElement> options = WebdriverWait.findElements("xpath", "//*[@id='primaryShipGroupSeqId']//option");
				for (WebElement option : options) {
					if (option.getText().contains(data.get(0).get("Facility-ShipGroup"))) {
						option.click();
						break;
					}
				}

				WebdriverWait.findElement("id", "createSubmit").click();
				String Ship1 = WebdriverWait.findElement("id", "shipmentIdDisplay").getText();
				ExcelWriter.writeExcelFile(sheetname, 15, 4, Ship1);

				Facilities_Shipments_OrderItems.SO_Partial_Shpmnt();
				Facilities_Shipments_Edit.ShpStatus();

			} else if (Shp == 2) {

				log.info("Create Shipment for remaining partial qty for Ship1");
				// F_ShipGrp_DDN.selectByVisibleText(data.get(0).get("Facility-ShipGroup"));

				List<WebElement> options = WebdriverWait.findElements("xpath", "//*[@id='primaryShipGroupSeqId']//option");
				for (WebElement option : options) {
					if (option.getText().contains(data.get(0).get("Facility-ShipGroup"))) {
						option.click();
						break;
					}
				}
				WebdriverWait.findElement("id", "createSubmit").click();
				String Ship2 = WebdriverWait.findElement("id", "shipmentIdDisplay").getText();
				ExcelWriter.writeExcelFile(sheetname, 16, 4, Ship2);

				Facilities_Shipments_OrderItems.SO_Full_Shpmnt();
				Facilities_Shipments_Edit.ShpStatus();

			} else if (Shp == 3) {

				log.info("Receiving Inventory with Full qty for Ship2");
				// F_ShipGrp_DDN.selectByVisibleText(data.get(5).get("Facility-ShipGroup"));

				List<WebElement> options = WebdriverWait.findElements("xpath", "//*[@id='primaryShipGroupSeqId']//option");
				for (WebElement option : options) {
					if (option.getText().contains(data.get(5).get("Facility-ShipGroup"))) {
						option.click();
						break;
					}
				}
				WebdriverWait.findElement("id", "createSubmit").click();
				String Ship2 = WebdriverWait.findElement("id", "shipmentIdDisplay").getText();
				ExcelWriter.writeExcelFile(sheetname, 17, 4, Ship2);

				Facilities_Shipments_OrderItems.SO_Full_Shpmnt();
				Facilities_Shipments_Edit.ShpStatus();

			} else if (Shp == 4) {

				log.info("Receiving Inventory with Full qty for Ship4");
				// F_ShipGrp_DDN.selectByVisibleText(data.get(8).get("Facility-ShipGroup"));

				List<WebElement> options = WebdriverWait.findElements("xpath", "//*[@id='primaryShipGroupSeqId']//option");
				for (WebElement option : options) {
					if (option.getText().contains(data.get(8).get("Facility-ShipGroup"))) {
						option.click();
						break;
					}
				}
				WebdriverWait.findElement("id", "createSubmit").click();
				String Ship2 = WebdriverWait.findElement("id", "shipmentIdDisplay").getText();
				ExcelWriter.writeExcelFile(sheetname, 18, 4, Ship2);

				Facilities_Shipments_OrderItems.SO_Full_Shpmnt();
				Facilities_Shipments_Edit.ShpStatus();
			}
		}

		// Capturing all the Invoice ID's
		Sales_SalesOrder_View.SO_CaptureInvID(sheetname);
	}
}