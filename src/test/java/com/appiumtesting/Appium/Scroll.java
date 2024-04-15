package com.appiumtesting.Appium;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Scroll extends AppiumConfiguration {
	
	@Test
	public void scrollDemo() throws InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		// new UiScrollable -- create object for the class UiScrollable
		// new UiSelector() -- call the selector
		// scrollIntoView() -- method of UiScrollable class
		// text(\"WebView\")-- the text i want to locate
		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
	}

}
