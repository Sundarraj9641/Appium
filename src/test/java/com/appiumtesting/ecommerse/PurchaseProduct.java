package com.appiumtesting.ecommerse;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class PurchaseProduct extends Configurations{
	
	@Test
	public void purchas() throws InterruptedException {
		
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.androidsample.generalstore:id/nameField\"]"))
		.sendKeys("Sundarraj");
		Assert.assertTrue(driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).isEnabled());
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(0).click();
		driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(1).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		
		WebElement conditions = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		
		//long pree on terms and conditions
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)conditions).getId(),"duration", 2000));
		
		//get text for pop up
		String popUpText = driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).getText();
		
		//verify the text on pop up
		Assert.assertEquals(popUpText, "Terms Of Conditions");
		
		//click on close button on pop up
		driver.findElement(By.id("android:id/button1")).click();
		
		//click on checkbox
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		
		//click on complete purchase
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		Thread.sleep(2000);
		
		
	}

}
