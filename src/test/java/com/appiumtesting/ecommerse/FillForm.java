package com.appiumtesting.ecommerse;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class FillForm extends Configurations {

	@Test
	public void loginForm() throws InterruptedException {
		
		//click on country dropdown
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		
		//select India in dropdown
		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));")).click();
		
		//enter name in the field
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.androidsample.generalstore:id/nameField\"]"))
		.sendKeys("Sundarraj");
		
		//verify that male is enabled on radio button
		Assert.assertTrue(driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).isEnabled());
		
		//click on let's shop button
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
	}
	
	
	
	@Test(dependsOnMethods={"loginForm"})
	public void errorPopUp() throws InterruptedException {
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.androidsample.generalstore:id/nameField\"]"))
		.clear();
		
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		
		//get text for toast popup
		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getText();
		
		System.out.println(toastMessage);
		Assert.assertEquals(toastMessage, "Please enter your name");
		
		Thread.sleep(3000);
		
	}
	
	
}
