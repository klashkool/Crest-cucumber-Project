package com.Utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;

public class testexcelreport_val extends Base {

	public static void testexcel(List<HashMap<String, String>> data) throws InterruptedException {

		log.info("Creating a New PO");
		driver.findElement(By.linkText("PROCUREMENT")).click();
		driver.findElement(By.linkText("Purchase Order")).click();
		driver.findElement(By.linkText("Reports")).click();
		driver.findElement(By.linkText("Purchase Order Excel")).click();

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String Fromdate = (dateFormat.format(new Date()));
		WebdriverWait.findElement("name", "minDate_i18n").sendKeys("04/03/2020");
		WebdriverWait.findElement("name", "maxDate_i18n").sendKeys("06/03/2020");

		// WebdriverWait.findElement("name", "minDate_i18n").sendKeys(Fromdate);
		// WebdriverWait.findElement("name", "maxDate_i18n").sendKeys(Fromdate);
		driver.findElement(By.name("supplierPartyId")).sendKeys("125550");

		driver.findElement(By.xpath("//*[@id='purchaseOrderSubmit']/td/input")).click();

		Thread.sleep(2000);

		FileRename.test();

		List<HashMap<String, String>> PO_Report = ExcelReader_ReportsVal.readExcelDatafromFile("C:\\Users\\KailashR\\Downloads\\report.xls",
						"purchase_order_report");

		Thread.sleep(5000);
		int counter = 0;
		for (int a = 2; a < PO_Report.size() - 1; a++) {

			if (PO_Report.get(a).get("P.O. No.").equals(data.get(14).get("Supplier"))) {
				counter++;
			}
		}
		System.out.println(counter);
		Assert.assertEquals(10, counter);

		if (counter == 10) {
			Assert.assertEquals(PO_Report.get(counter).get("P.O. Date"), "04/03/2020");
			System.out.println("PO Reports - Date validated Successfully");

		}

		File file = new File("C:\\Users\\KailashR\\Downloads\\report.xls");

		if (file.delete()) {
			System.out.println("file deleted");

		}

	}
}