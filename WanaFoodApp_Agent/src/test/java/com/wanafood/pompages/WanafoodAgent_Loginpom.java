package com.wanafood.pompages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.wanafood.testcases.WanaFoodApp_Launch;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class WanafoodAgent_Loginpom {
	AndroidDriver driver;

	public WanafoodAgent_Loginpom(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 6, TimeUnit.SECONDS), this);

	}

// login pageelements
	@FindBy(id = "com.ongo.wana_food_agent:id/etPhoneNumber")
	public AndroidElement phonenumber;

	@FindBy(id = "com.ongo.wana_food_agent:id/et1")
	public AndroidElement pin1;

	@FindBy(id = "com.ongo.wana_food_agent:id/tvLogin")
	public AndroidElement submitBtn;

	@FindBy(id = "com.ongo.wana_food_agent:id/et2")
	public AndroidElement pin2;

	@FindBy(id = "com.ongo.wana_food_agent:id/et3")
	public AndroidElement pin3;

	@FindBy(id = "com.ongo.wana_food_agent:id/et4")
	public AndroidElement pin4;

	@FindBy(id = "com.ongo.wana_food_agent:id/tvHeaderName")
	public AndroidElement orderstxt;
	
	public void login(String phoneNumber) {
		WanaFoodApp_Launch.extentTest.log(Status.INFO,
				MarkupHelper.createLabel("Given Credentials ", WanaFoodApp_Launch.color.TEAL));
		WanaFoodApp_Launch.extentTest.log(Status.INFO,
				MarkupHelper.createLabel("PhoneNumber : " + phoneNumber, WanaFoodApp_Launch.color.BLUE));
		WanaFoodApp_Launch.extentTest.log(Status.INFO,
				MarkupHelper.createLabel("OTP : " + "1234", WanaFoodApp_Launch.color.BLUE));
		setexplicitwait(phonenumber);
		phonenumber.sendKeys(phoneNumber);
		setexplicitwait(pin1);
		pin1.sendKeys("1");

		setexplicitwait(pin2);
		pin2.sendKeys("2");

		setexplicitwait(pin3);
		pin3.sendKeys("3");

		setexplicitwait(pin4);
		pin4.sendKeys("4");

		setexplicitwait(submitBtn);
		submitBtn.click();
	}

	public void login_validations(String phoneNumber) {
		WanaFoodApp_Launch.extentTest.log(Status.INFO,
				MarkupHelper.createLabel("Given Credentials ", WanaFoodApp_Launch.color.TEAL));
		WanaFoodApp_Launch.extentTest.log(Status.INFO,
				MarkupHelper.createLabel("PhoneNumber : " + phoneNumber, WanaFoodApp_Launch.color.BLUE));
		WanaFoodApp_Launch.extentTest.log(Status.INFO,
				MarkupHelper.createLabel("OTP : " + "1234", WanaFoodApp_Launch.color.BLUE));
		try {
			setexplicitwait(phonenumber);
			phonenumber.clear();
			setexplicitwait(pin1);
			pin1.clear();

			setexplicitwait(pin2);
			pin2.clear();

			setexplicitwait(pin3);
			pin3.clear();

			setexplicitwait(pin4);
			pin4.clear();
		} catch (Exception e) {

		}
		setexplicitwait(phonenumber);
		phonenumber.sendKeys(phoneNumber);
		setexplicitwait(pin1);
		pin1.sendKeys("1");

		setexplicitwait(pin2);
		pin2.sendKeys("2");

		setexplicitwait(pin3);
		pin3.sendKeys("3");

		setexplicitwait(pin4);
		pin4.sendKeys("4");

		setexplicitwait(submitBtn);
		submitBtn.click();
		
		try {
		setexplicitwait(orderstxt);
		boolean b = orderstxt.isDisplayed();
		String orderdisplay = display(b);
		System.out.println("displa --" + orderdisplay);
		String str = orderstxt.getText();
		WanaFoodApp_Launch.extentTest.log(Status.INFO,
				MarkupHelper.createLabel("Orders text Display : " + orderdisplay, WanaFoodApp_Launch.color.BLUE));

		if (str.equalsIgnoreCase("Orders")) {
			WanaFoodApp_Launch.extentTest.log(Status.PASS, MarkupHelper.createLabel(
					"Orderspage is displaying, hence looged into site successfully ", WanaFoodApp_Launch.color.GREEN));

		} else {
			WanaFoodApp_Launch.extentTest.log(Status.PASS, MarkupHelper.createLabel(
					"Orders page is not displaying , login is Unsuccessful", WanaFoodApp_Launch.color.RED));

		}
		}catch(Exception e) {}

	}

	// gooffduty test
	@FindBy(id = "com.ongo.wana_food_agent:id/tvOnDuty")
	public AndroidElement goonDuty;

	@FindBy(id = "com.ongo.wana_food_agent:id/tvOffDuty")
	public AndroidElement setgoOff;

	@FindBy(id = "com.ongo.wana_food_agent:id/tvPositive")
	public AndroidElement yesBtn;
	
	@FindBy(id="com.ongo.wana_food_agent:id/tvPositive")
	public AndroidElement yesAlertbtn;

	public void set_goOffDuty()
	{
		setexplicitwait(goonDuty);
		goonDuty.click();
		setexplicitwait(setgoOff);
		setgoOff.click();
		setexplicitwait(yesBtn);
		yesBtn.click();
		setexplicitwait(goonDuty);
		boolean b = goonDuty.isDisplayed();
		String imgdisplay = display(b);
		System.out.println("displa --" + imgdisplay);
		String str = goonDuty.getText();
		WanaFoodApp_Launch.extentTest.log(Status.INFO,
				MarkupHelper.createLabel("onduty text Display : " + imgdisplay, WanaFoodApp_Launch.color.BLUE));

		if (str.equalsIgnoreCase("Go On Duty")) {
			WanaFoodApp_Launch.extentTest.log(Status.PASS,
					MarkupHelper.createLabel("Set GoOFF duty option successfully ", WanaFoodApp_Launch.color.GREEN));

		} else {
			WanaFoodApp_Launch.extentTest.log(Status.PASS,
					MarkupHelper.createLabel("not set with GoOff duty ", WanaFoodApp_Launch.color.RED));

		}
	}

	public String display(boolean str) {
		String val = "false";
		if (str) {
			val = "true";
		}
		return val;

	}
	
	public void set_pickUpStart() {
		setexplicitwait(status_accept);
		status_accept.click();
		setexplicitwait(pickupstartBtn);
		pickupstartBtn.click();
		setexplicitwait(yesAlertbtn);
		yesAlertbtn.click();
		WanaFoodApp_Launch.extentTest.log(Status.INFO,MarkupHelper.createLabel("Pickup started for Order : " , WanaFoodApp_Launch.color.GREEN));
		
	}

	public void setexplicitwait(AndroidElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 12);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	@FindBy(id = "com.ongo.wana_food_agent:id/lvTimePuStart")
	public AndroidElement pickupstartBtn;

	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.ongo.wana_food_agent:id/tvOrderStatus' and @text='Status  :   Accept']")
	public AndroidElement status_accept;

	@FindBy(xpath = "//android.widget.TextView[contains(@text(),'welcome')]")
	public AndroidElement txt;

	// Order summary
	@FindBy(xpath="//android.widget.TextView[@resource-id='com.ongo.wana_food_agent:id/tvItemAmount' and @text='₹190.0']")
	public AndroidElement itemamnt;
	
	@FindBy(id = "com.ongo.wana_food_agent:id/tvCouponAmount")
	public AndroidElement couponAmnt;

	@FindBy(id = "com.ongo.wana_food_agent:id/tvUserWalletAmount")
	public AndroidElement userwalletamnt;

	@FindBy(id = "com.ongo.wana_food_agent:id/tvWanaWalletAmount")
	public AndroidElement wanaWalletAmnt;

	@FindBy(id = "com.ongo.wana_food_agent:id/tvDelCharges")
	public AndroidElement deliveryCharges;

	@FindBy(id = "com.ongo.wana_food_agent:id/tvRestDisct")
	public AndroidElement restaurentcharges;

	@FindBy(id = "com.ongo.wana_food_agent:id/tvPaidAmount")
	public AndroidElement paidAmnt;
	
	public void OrderSummary() throws InterruptedException {
		Float sum=0.00f;
		Thread.sleep(2000);
		scrollup();
		setexplicitwait(status_accept);
		status_accept.click();
		Thread.sleep(2000);
		scrollup();
		scrollup();
		setexplicitwait(itemamnt);
		String itemAmount=itemamnt.getText();
		itemAmount=itemAmount.replaceAll("[^.0-9]", "");
		Float iA=Float.valueOf(itemAmount);
		System.out.println("-->"+iA);
		WanaFoodApp_Launch.extentTest.log(Status.INFO,MarkupHelper.createLabel("Order Summary : " , WanaFoodApp_Launch.color.ORANGE));
		WanaFoodApp_Launch.extentTest.log(Status.INFO,MarkupHelper.createLabel("Item Amount : " + iA, WanaFoodApp_Launch.color.BLUE));
		
		setexplicitwait(couponAmnt);
		String couponAmount=couponAmnt.getText();
		couponAmount=couponAmount.replaceAll("[^.0-9]", "");
		Float cA=Float.valueOf(couponAmount);
		System.out.println("-->"+cA);
		WanaFoodApp_Launch.extentTest.log(Status.INFO,MarkupHelper.createLabel("Coupon Amount : " + cA, WanaFoodApp_Launch.color.BLUE));
		
		
		setexplicitwait(userwalletamnt);
		String userwalletAmount=userwalletamnt.getText();
		userwalletAmount=userwalletAmount.replaceAll("[^.0-9]", "");
		Float uwA=Float.valueOf(userwalletAmount);
		System.out.println("-->"+uwA);
		WanaFoodApp_Launch.extentTest.log(Status.INFO,MarkupHelper.createLabel("User Wallet Amount : " + uwA, WanaFoodApp_Launch.color.BLUE));
		
		
		setexplicitwait(wanaWalletAmnt);
		String wansWalletAmount=wanaWalletAmnt.getText();
		wansWalletAmount=wansWalletAmount.replaceAll("[^.0-9]", "");
		Float wwA=Float.valueOf(wansWalletAmount);
		System.out.println("-->"+wwA);
		WanaFoodApp_Launch.extentTest.log(Status.INFO,MarkupHelper.createLabel("WanaWallet Amount : " + wwA, WanaFoodApp_Launch.color.BLUE));
		
		
		setexplicitwait(deliveryCharges);
		String delChargesAmount=deliveryCharges.getText();
		delChargesAmount=delChargesAmount.replaceAll("[^.0-9]", "");
		Float dcA=Float.valueOf(delChargesAmount);
		System.out.println("-->"+dcA);
		WanaFoodApp_Launch.extentTest.log(Status.INFO,MarkupHelper.createLabel("Delivery Charges Amount : " + dcA, WanaFoodApp_Launch.color.BLUE));
		
		
		setexplicitwait(restaurentcharges);
		String restaurentAmount=restaurentcharges.getText();
		restaurentAmount=restaurentAmount.replaceAll("[^.0-9]", "");
		Float rA=Float.valueOf(restaurentAmount);
		System.out.println("-->"+rA);
		WanaFoodApp_Launch.extentTest.log(Status.INFO,MarkupHelper.createLabel("Restaurent Amount : " + rA, WanaFoodApp_Launch.color.BLUE));
		
		
		setexplicitwait(paidAmnt);
		String paidAmount=paidAmnt.getText();
		paidAmount=paidAmount.replaceAll("Rs.", "");
		paidAmount=paidAmount.replaceAll("[^.0-9]", "");
		Float pA=Float.valueOf(paidAmount);
		System.out.println("-->"+pA);
		WanaFoodApp_Launch.extentTest.log(Status.INFO,MarkupHelper.createLabel("Paid Amount : " + pA, WanaFoodApp_Launch.color.BLUE));
		
		
		sum=iA+cA-uwA+wwA+dcA-rA;
		System.out.println("--sum is->"+sum);
		WanaFoodApp_Launch.extentTest.log(Status.INFO,MarkupHelper.createLabel("Total Sum : " + sum, WanaFoodApp_Launch.color.BLUE));
		String s=String.valueOf(sum);
		if(s.equalsIgnoreCase(paidAmount)) {
			System.out.println("-->equals");
			WanaFoodApp_Launch.extentTest.log(Status.INFO,MarkupHelper.createLabel("Total sum and paid amounts are equals ", WanaFoodApp_Launch.color.GREEN));
			
		}
		else {
			System.out.println("-->not equals");
			WanaFoodApp_Launch.extentTest.log(Status.INFO,MarkupHelper.createLabel("Total sum and paid amounts are not equals ", WanaFoodApp_Launch.color.RED));
			
		}
		/*if(sum == pA) {
			System.out.println("-->equals");
			WanaFoodApp_Launch.extentTest.log(Status.INFO,MarkupHelper.createLabel("Total sum and paid amounts are equals ", WanaFoodApp_Launch.color.GREEN));
			
		}
		else {
			System.out.println("-->not equals");
			WanaFoodApp_Launch.extentTest.log(Status.INFO,MarkupHelper.createLabel("Total sum and paid amounts are not equals ", WanaFoodApp_Launch.color.RED));
			
		}*/
	}

	public void scrollup() {
		Dimension dim = driver.manage().window().getSize();
		int anchor = dim.getHeight() / 2;

		Double start = (double) (dim.getWidth() / 2);
		int scrollSta = start.intValue();
		Double end = dim.getHeight() * 0.01;
		int scrollen = end.intValue();
		for (int i = 0; i <= 1; i++) {
			TouchAction action = new TouchAction(driver);
			action.press(PointOption.point(scrollSta, anchor))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
					.moveTo(PointOption.point(scrollen, scrollSta)).release().perform();

		}

	}

}
