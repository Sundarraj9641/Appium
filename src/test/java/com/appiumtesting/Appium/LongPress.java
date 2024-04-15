package com.appiumtesting.Appium;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class LongPress extends AppiumConfiguration {

	@Test
	public void longPress() throws InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();

		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

		WebElement longPress = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']")); 
		
		//long press
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)longPress).getId(),"duration", 2000));
		
		//verify sample menu is displayed or not
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());

	}
}
