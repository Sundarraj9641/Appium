package com.appiumtesting.Appium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java. net.MalformedURLException;
import java.net.URISyntaxException;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


public class MobileKeyEvents extends AppiumConfiguration {

	@Test
	public void MobileKeyEventsDemo() throws URISyntaxException, MalformedURLException, InterruptedException {


		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		

		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		

		driver.findElement(By.id("android:id/checkbox")).click();
		
		//press back button in mobile
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

		
		//press home button in mobile
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
		Thread.sleep(2000);
	}

}
