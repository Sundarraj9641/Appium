package com.appiumtesting.Appium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java. net.MalformedURLException;
import java.net.URISyntaxException;
import io.appium.java_client.AppiumBy;


public class Basics extends AppiumConfiguration {

	@Test
	public void wifiSettings() throws URISyntaxException, MalformedURLException {

		// By (used in selenium) -- ID, Classname and XPath locators
		// AppiumBy -- for accessibilityId and androidUiAutomator locators
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		
		//click on preference XDependencies
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		
		//click on checkbox
		driver.findElement(By.id("android:id/checkbox")).click();
		
		//click on wifi settings
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		//get text from pop up
		String popupText = driver.findElement(By.id("android:id/alertTitle")).getText();
		
		//verify with expected text
		String expectedText = "WiFi settings";
		Assert.assertEquals(popupText, expectedText);
		
		//enter text
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"android:id/edit\"]")).sendKeys("Pixel 6");
		
		//click on ok button
		driver.findElement(By.id("android:id/button1")).click();
	}

}
