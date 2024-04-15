package com.appiumtesting.ecommerse;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ContextHandles extends Configurations {

	@Test
	public void contextHandlesDemo() throws InterruptedException {
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
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(5000);
		
		//Get the contexts
		Set<String> context = driver.getContextHandles();
		
		for(String contexts:context) {
			System.out.println(contexts);
		}
		
		//Navigate to the handles
		Iterator<String> it = context.iterator();
		
		String nativeApp = it.next();
		String webApp = it.next();
		
		//Switch to context
		driver.context(webApp);
		
		//enter "Ecommerse" in the google
		driver.findElement(By.name("q")).sendKeys("Ecommerce");
		
		//click enter key 
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

}
