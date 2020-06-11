package com.Sales_Modules;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.support.ui.Select;

import com.Utils.Base;
import com.Utils.WebdriverWait;

public class Sales_Quotes extends Base {

	public static void Create_SO_Quotes(List<HashMap<String, String>> data, String sheetname) throws InterruptedException {

		WebdriverWait.findElement("link", "SALES").click();
		WebdriverWait.findElement("link", "Quotes").click();
		WebdriverWait.findElement("link", "Create Quote").click();

		Select orgName_dd = new Select(WebdriverWait.findElement("id", "billToCustomerPartyId"));
		orgName_dd.selectByVisibleText(data.get(0).get("Organization"));

		WebdriverWait.findElement("name", "partyId").sendKeys("11651");
		Calendar sys = Calendar.getInstance();
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String todayDate = (date.format(new Date()));
		String sysTime = (sdf.format(sys.getTime()));

		WebdriverWait.findElement("name", "description").sendKeys("SO " + todayDate + sysTime);

		Select prdStore_dd = new Select(WebdriverWait.findElement("id", "productStoreId"));
		prdStore_dd.selectByVisibleText("General Sales Store");

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String Fromdate = (dateFormat.format(new Date()));
		WebdriverWait.findElement("name", "issueDate_i18n").sendKeys(Fromdate);

		Select salesChn_dd = new Select(WebdriverWait.findElement("id", "salesChannelEnumId"));
		salesChn_dd.selectByVisibleText("E-Mail Channel");

		Select cur_dd = new Select(WebdriverWait.findElement("id", "currencyUomId"));
		cur_dd.selectByVisibleText(data.get(0).get("Currency"));

		Select ordType_dd = new Select(WebdriverWait.findElement("id", "orderType"));
		ordType_dd.selectByVisibleText(data.get(0).get("OrderType"));

		Select numType_dd = new Select(WebdriverWait.findElement("id", "numberingFormatId"));
		numType_dd.selectByVisibleText("Sales Quote");

		WebdriverWait.findElement("xpath", "//*[@id='createQuote']/div/table/tbody[1]/tr[17]/td/input").click();

		Sales_Quotes_Edit.Capture_SO_QuoteID(sheetname);
		Sales_Quotes_QuoteItems.Add_Products(data);
		Sales_Quotes_Edit.SO_Accept_Quote();
		Sales_Quotes_View.Quote_Header_Val();
		Sales_Quotes_View.SO_Quotes_GrndTotal_Val(data);
		Sales_Quotes_View.SO_Quotes_CreateOrderLink();

	}



}
