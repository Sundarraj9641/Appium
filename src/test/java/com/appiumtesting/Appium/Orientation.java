package com.appiumtesting.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;
import java. net.MalformedURLException;
import java.net.URISyntaxException;
import io.appium.java_client.AppiumBy;


public class Orientation extends AppiumConfiguration {

	@Test
	public void orientationDemo() throws URISyntaxException, MalformedURLException {


		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		

		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		

		driver.findElement(By.id("android:id/checkbox")).click();
		
		//rotate the device to landscape (90 degree)
		DeviceRotation landscape = new DeviceRotation(0,0,90);
		
		driver.rotate(landscape);
		
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		
		String popupText = driver.findElement(By.id("android:id/alertTitle")).getText();
		
	
		String expectedText = "WiFi settings";
		
		Assert.assertEquals(popupText, expectedText);
		
	
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"android:id/edit\"]")).sendKeys("Pixel 6");
		
	
		driver.findElement(By.id("android:id/button1")).click();
	}

}
