package com.wanafood.testcases;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wanafood.pompages.WanafoodAgent_Loginpom;
import com.wanafood.utilities.DataDriven_Excel;

public class Wanafoodagent_OrderSummary extends WanaFoodApp_Launch {
	@Test(dataProvider = "returndata_login", priority = 0)
	public void login(HashMap<String, String> hash) throws InterruptedException {
		extentTest = extentReport.createTest("WanafoodAgentLogin");
		System.out.println(hash.get("PhoneNumber"));
		WanafoodAgent_Loginpom obj = new WanafoodAgent_Loginpom(driver);
		obj.login(hash.get("PhoneNumber"));
	}

	@Test(priority=1)
	public void orderSum() throws InterruptedException {
		extentTest = extentReport.createTest("OrderSummary");
		WanafoodAgent_Loginpom obj=new WanafoodAgent_Loginpom(driver); 
		obj.OrderSummary();
	}
	@DataProvider
	public Object[][] returndata_login() throws InvalidFormatException, IOException {
		return DataDriven_Excel.getData("C:\\Users\\HP\\eclipse-workspace\\WanaFoodApp_Agent\\src\\test\\java\\com\\wanafood\\utilities\\WanaFoodExceldata.xlsx",
				"UserLogin");

	}
}
