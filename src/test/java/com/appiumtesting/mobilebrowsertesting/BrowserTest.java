package com.appiumtesting.mobilebrowsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class BrowserTest extends MobileBrowserTestingBase {

	@Test
	public void mobileBrowserTest() throws InterruptedException {
		
		driver.get("https://www.saucedemo.com/v1/");
		
		//Login page
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
		driver.findElement(By.id("login-button")).click();
		
		Thread.sleep(3000);
		
		//scroll and click on product
		WebElement prod = driver.findElement(By.xpath("//a[@id='item_2_title_link']"));
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript("arguments[0].click();", prod);
		
		Thread.sleep(3000);
		
		//get name and description of the product
		String prodName = driver.findElement(By.xpath("//div[@class='inventory_details_name']")).getText();
		String prodDesc = driver.findElement(By.xpath("//div[@class='inventory_details_desc']")).getText();
		
		//print name and description of the product
		System.out.println("Product Name: "+prodName);
		System.out.println("Product Description: "+prodDesc);
		
		}
}
