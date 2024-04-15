package com.appiumtesting.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class DragAndDrop extends AppiumConfiguration{

	@Test
	public void dragAndDropDemo() {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		
		WebElement drag = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		
		//drag and drop
		((JavascriptExecutor)driver).executeScript("mobile: dragGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement)drag). getId(),
				"endX", 621,
				"endY", 545
				));
		String text = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		
		//verify is it dropped
		Assert.assertEquals(text, "Dropped!");
	}
}
