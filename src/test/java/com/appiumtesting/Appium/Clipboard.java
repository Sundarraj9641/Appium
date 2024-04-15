package com.appiumtesting.Appium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java. net.MalformedURLException;
import java.net.URISyntaxException;
import io.appium.java_client.AppiumBy;


public class Clipboard extends AppiumConfiguration {

	@Test
	public void clipboadrDemo() throws URISyntaxException, MalformedURLException {


		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		

		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		

		driver.findElement(By.id("android:id/checkbox")).click();
		
	
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		
		String popupText = driver.findElement(By.id("android:id/alertTitle")).getText();
		
	
		String expectedText = "WiFi settings";
		
		Assert.assertEquals(popupText, expectedText);
		
		//text copied in clipboard
		driver.setClipboardText("Sundarraj's Wifi");
		
		//paste the text copied in clipboard as sendkeys text
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"android:id/edit\"]"))
			.sendKeys(driver.getClipboardText());
		
	
		driver.findElement(By.id("android:id/button1")).click();
	}

}
