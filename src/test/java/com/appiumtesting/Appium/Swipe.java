package com.appiumtesting.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class Swipe extends AppiumConfiguration {
	
	@Test
	public void swipeDemo() {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		
		WebElement image = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
		
		//to verify that first element is focused or not
		Assert.assertEquals(image.getAttribute("focusable"),"true");
		
		//swipe
		//direction:left -- which direction you want to swipe
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement)image).getId(),
				"direction", "left",
				"percent", 0.75
				));
	}

}
