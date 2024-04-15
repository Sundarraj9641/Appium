package com.appiumtesting.ecommerse;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ValidateTotalPriceInCart extends Configurations {

	@Test
	public void totalPrice() throws InterruptedException {

		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.androidsample.generalstore:id/nameField\"]"))
		.sendKeys("Sundarraj");
		Assert.assertTrue(driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).isEnabled());
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//click on 1st item's add to cart
		driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(0).click();
		
		//click on 2nd item's add to cart
		driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(1).click();
		
		//click on add to cart icon
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		Thread.sleep(3000);
		
		//get the web elements of items in the cart
		List<WebElement> price = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		
		//count of item in cart
		int count = price.size();
		double sum =0;
		
		for (int i=0; i<count; i++) {
			//get price of items as a string
			String text = price.get(i).getText();
			
			//convert the price into double and remove the dollar symbol in the price
			//text.substring(1) -- remove dollar symbol 
			//Double.parseDouble(text.substring(1)); -- convert string into double
			double amount = Double.parseDouble(text.substring(1));
			
			sum = sum + amount;
		}
		
		//get total price value at the bottom
		String strTotal = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		
		double total = Double.parseDouble(strTotal.substring(1));
		
		//verify both the value is same
		Assert.assertEquals(sum, total);

	}
}
