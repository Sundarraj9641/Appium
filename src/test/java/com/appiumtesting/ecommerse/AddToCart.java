package com.appiumtesting.ecommerse;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class AddToCart extends Configurations {

	@Test
	public void addProductToCart() throws InterruptedException {

		
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();

		
		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));")).click();

		
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.androidsample.generalstore:id/nameField\"]"))
		.sendKeys("Sundarraj");

		
		Assert.assertTrue(driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).isEnabled());

		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan Lift Off\"));"));
		
		//get the count of web elements
		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		
		for(int i =0; i<count; i++) {
			
			//get the text from the web elements
			String product = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			
			//if the test is equal to Jordan Lift Off then click on add to cart
			if(product.equalsIgnoreCase("Jordan Lift Off")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
		}
		
		//click on add to cart logo
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(3000));
		
		//WebElement cart = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
		
		
		
		//Thread.sleep(3000);
		
		WebElement productName = driver.findElement(By.id("com.androidsample.generalstore:id/productName"));
		wait.until(ExpectedConditions.visibilityOf(productName));
		
		String product_Name = productName.getText();
		
		//verify that product is added to cart or not
		Assert.assertEquals(product_Name, "Jordan Lift Off");
		
		
		
	}
}
